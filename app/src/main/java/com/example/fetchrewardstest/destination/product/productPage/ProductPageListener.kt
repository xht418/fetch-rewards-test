package com.example.fetchrewardstest.destination.product.productPage

import com.example.fetchrewardstest.model.Product

class ProductPageListener(private val itemClickAction: (Product) -> Unit) {
    fun onItemClick(product: Product) = itemClickAction(product)
}