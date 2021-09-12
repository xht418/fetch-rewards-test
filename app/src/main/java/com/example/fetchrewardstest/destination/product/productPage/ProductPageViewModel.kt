package com.example.fetchrewardstest.destination.product.productPage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardstest.model.Product

class ProductPageViewModel(application: Application, val products: List<Product>) : AndroidViewModel(application)