package com.example.fetchrewardstest.network.product

import com.example.fetchrewardstest.util.toMediaType
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.Retrofit

object ProductService {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    private val contentType = "application/json".toMediaType()
    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder().run {
        addConverterFactory(json.asConverterFactory(contentType))
        baseUrl(BASE_URL)
        build()
    }

    val retrofitHelper: ProductApi by lazy {
        retrofit.create(ProductApi::class.java)
    }
}