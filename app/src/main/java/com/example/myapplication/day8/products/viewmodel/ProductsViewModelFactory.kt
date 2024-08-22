package com.example.myapplication.day8.products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.day8.products.repo.ProductsRepository

class ProductsViewModelFactory(
    private val repo: ProductsRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            ProductsViewModel(repo) as T
        } else {
            throw IllegalArgumentException("ProductsViewModel class not found")
        }
    }
}