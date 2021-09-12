package com.example.fetchrewardstest.network.product

import com.example.fetchrewardstest.model.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("hiring.json")
    suspend fun getProducts(): List<Product>
}