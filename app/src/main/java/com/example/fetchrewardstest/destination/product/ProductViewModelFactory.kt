package com.example.fetchrewardstest.destination.product

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fetchrewardstest.repository.ProductRepository

class ProductViewModelFactory(private val application: Application, private val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            return ProductViewModel(application, repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}