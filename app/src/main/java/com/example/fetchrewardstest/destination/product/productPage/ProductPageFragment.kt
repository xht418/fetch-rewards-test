package com.example.fetchrewardstest.destination.product.productPage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fetchrewardstest.R
import com.example.fetchrewardstest.databinding.FragmentProductPageBinding
import com.example.fetchrewardstest.model.Product

class ProductPageFragment : Fragment() {
    private lateinit var binding: FragmentProductPageBinding
    private lateinit var args: Bundle
    private lateinit var viewModelFactory: ProductPageViewModelFactory
    private lateinit var viewModel: ProductPageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_page, container, false)
        args = requireArguments()
        viewModelFactory = ProductPageViewModelFactory(requireActivity().application, args.getParcelableArrayList("products")!!)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ProductPageViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.recyclerView.adapter = getProductPageAdapter()

        Log.v("xxx", "loaded!")

        return binding.root
    }

    private fun getProductPageAdapter(): ProductPageAdapter {
        val itemClickAction: (Product) -> Unit = {
            findNavController().navigate(R.id.action_productFragment_to_productDetailFragment)
        }

        return ProductPageAdapter(ProductPageListener(itemClickAction))
    }
}