package com.example.myapplication.day8.products.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.day8.dto.Product
import com.example.myapplication.day8.products.repo.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val repo: ProductsRepository
): ViewModel() {

    /*
    * Don't (NEVER EVER) depend on CONCRETE type,
    * ALWAYS depend on ABSTRACT type (abstract class & interface)
    * Don't HIDE dependency
    * */

    private val _productsList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>> = _productsList

    private val _isRemoteSourceError = MutableLiveData<String>()
    val isRemoteSourceError: LiveData<String> = _isRemoteSourceError

    fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getAllProductsFromRemoteDataSource()

            if (response.isSuccessful) {
                val productsList = response.body()?.productsList ?: emptyList()
                _productsList.postValue(productsList)
                Log.d("asd -> ", response.toString())

                for (item in productsList) {
                    repo.insert(item)
                }
            } else {
                // handle error response
                /*
                * {
                *   code: 200
                *   message: "API service is down"
                * }
                * */
                Log.d("asd -> ", response.toString())
                when (response.code()) {
                    in 300 .. 399 -> _isRemoteSourceError.postValue("Error message for the range from 300 > 399")
                    400 -> _isRemoteSourceError.postValue("Bad Request")
                    401 -> _isRemoteSourceError.postValue("Unauthorized")
                    403 -> _isRemoteSourceError.postValue("Forbidden")
                    in 404 .. 499 -> _isRemoteSourceError.postValue("404 Not Found - problems in request - client error")
                    in 500 .. 599 -> _isRemoteSourceError.postValue("Error message Server Error")
                }

            }
        }
    }
}