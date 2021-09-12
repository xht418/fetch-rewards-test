package com.example.fetchrewardstest.destination.product

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardstest.model.Product
import com.example.fetchrewardstest.repository.ProductRepository
import com.example.fetchrewardstest.util.showToastLong
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ProductViewModel(application: Application, private val repository: ProductRepository) : AndroidViewModel(application) {
    private val uiScope = viewModelScope
    private val _products = MutableStateFlow<List<List<Product>>>(emptyList())
    private val _isLoading = MutableStateFlow(false)

    val products: StateFlow<List<List<Product>>>
        get() = _products

    val isLoading: StateFlow<Boolean>
        get() = _isLoading

    init {
        getDataFromNetwork()
    }

    private fun getDataFromNetwork() = uiScope.launch {
        try {
            _isLoading.value = true

            val rawProducts = repository.getProducts()

            _products.value = getOrganizedProducts(rawProducts)

            _isLoading.value = false
        } catch (e: Exception) {
            _isLoading.value = false

            showToastLong(e.message.toString())
        }
    }

    private suspend fun getOrganizedProducts(rawProducts: List<Product>) = withContext(Dispatchers.Default) {
        val organizedProducts = mutableListOf<List<Product>>()
        val validProducts = rawProducts.filter { it.name != null && it.name.isNotEmpty() }
        val sortedProducts = validProducts.sortedBy { it.name }

        for (listId in 1..4) {
            organizedProducts.add(sortedProducts.filter { it.listId == listId.toLong() })
        }

        organizedProducts
    }

    /*private suspend fun getOrganizedProducts(rawProducts: List<Product>) = withContext(Dispatchers.Default) {
        val validProducts = rawProducts.filter { it.name != null && it.name.isNotEmpty() }
        val sortedProducts = validProducts.sortedBy { it.name }

        sortedProducts.groupBy { it.listId }.toSortedMap()
    }*/
}