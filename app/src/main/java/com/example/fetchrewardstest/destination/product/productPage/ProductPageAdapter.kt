package com.example.fetchrewardstest.destination.product.productPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardstest.databinding.ItemProductPageBinding
import com.example.fetchrewardstest.model.Product

class ProductPageAdapter : ListAdapter<Product, ProductPageAdapter.ProductPageViewHolder>(ProductDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPageViewHolder {
        return ProductPageViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProductPageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductPageViewHolder private constructor(private val binding: ItemProductPageBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): ProductPageViewHolder {
                val binding = ItemProductPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

                return ProductPageViewHolder(binding)
            }
        }

        fun bind(product: Product) {
            binding.product = product

            binding.executePendingBindings()
        }
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
    }
}