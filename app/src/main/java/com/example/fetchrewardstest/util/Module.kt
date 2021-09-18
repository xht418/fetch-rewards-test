package com.example.fetchrewardstest.util

import com.example.fetchrewardstest.repository.ProductRepository
import org.koin.dsl.module

val appModule = module {
    single { ProductRepository() }
}