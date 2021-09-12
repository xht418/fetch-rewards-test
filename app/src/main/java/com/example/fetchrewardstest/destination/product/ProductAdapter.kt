package com.example.fetchrewardstest.destination.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fetchrewardstest.destination.product.productPage.ProductPageFragment
import com.example.fetchrewardstest.model.Product

class ProductAdapter(fragment: Fragment, private val products: List<List<Product>>) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = products.size

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle().apply {
            putParcelableArrayList("products", ArrayList(products[position]))
        }

        return ProductPageFragment().apply {
            arguments = bundle
        }
    }
}