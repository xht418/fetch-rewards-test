package com.example.fetchrewardstest.repository

import com.example.fetchrewardstest.network.product.ProductService

class ProductRepository {
    private val retrofitHelper = ProductService.retrofitHelper

    suspend fun getProducts() = retrofitHelper.getProducts()
}