package com.example.fetchrewardstest.destination.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.fetchrewardstest.R
import com.example.fetchrewardstest.databinding.FragmentProductBinding
import com.example.fetchrewardstest.repository.ProductRepository
import com.example.fetchrewardstest.util.collect
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.ext.android.inject

class ProductFragment : Fragment() {
    private lateinit var binding: FragmentProductBinding
    private lateinit var viewModelFactory: ProductViewModelFactory
    private lateinit var viewModel: ProductViewModel

    private val productRepository by inject<ProductRepository>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)
        viewModelFactory = ProductViewModelFactory(requireActivity().application, productRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ProductViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.products.collect(lifecycleScope) {
            if (it.isNotEmpty()) {
                binding.viewPager.adapter = ProductAdapter(this, it)
                //binding.viewPager.offscreenPageLimit = 3

                TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
                    tab.text = "listId ${position + 1}"
                }.attach()
            }
        }

        return binding.root
    }
}