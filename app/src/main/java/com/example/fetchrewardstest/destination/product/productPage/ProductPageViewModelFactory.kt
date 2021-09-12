package com.example.fetchrewardstest.destination.product.productPage

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fetchrewardstest.model.Product

class ProductPageViewModelFactory(private val application: Application, private val products: List<Product>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductPageViewModel::class.java)) {
            return ProductPageViewModel(application, products) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}