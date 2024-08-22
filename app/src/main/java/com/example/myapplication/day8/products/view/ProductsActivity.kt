package com.example.myapplication.day8.products.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.day8.db.LocalDataSourceImpl
import com.example.myapplication.day8.network.APIClient
import com.example.myapplication.day8.products.repo.ProductsRepositoryImpl
import com.example.myapplication.day8.products.viewmodel.ProductsViewModel
import com.example.myapplication.day8.products.viewmodel.ProductsViewModelFactory

class ProductsActivity : AppCompatActivity() {

//    private val productsViewModel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_retrofit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val thumbnail = findViewById<ImageView>(R.id.thumbnail)

        val productsViewModelFactory = ProductsViewModelFactory(
            repo = ProductsRepositoryImpl(
                remoteDataSource = APIClient,
                localDataSource = LocalDataSourceImpl(applicationContext)
            )
        )
        val viewModel = ViewModelProvider(this, productsViewModelFactory)
            .get(ProductsViewModel::class.java)

        viewModel.getAllProducts()
        viewModel.productList.observe(this) { productsList ->
            for (item in productsList) {
                Log.d("asd -> ", item.toString())
            }

            Glide
                .with(this)
                .load(productsList[0].thumbnail)
                .apply(RequestOptions()
                    .placeholder(R.drawable.six)
                    .error(R.drawable.seven)
                )
                .into(thumbnail)
        }

        viewModel.isRemoteSourceError.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }
    }
}