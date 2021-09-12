package com.example.fetchrewardstest.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("data")
fun <T> setData(recyclerView: RecyclerView, data: List<T>?) {
    (recyclerView.adapter as ListAdapter<T, RecyclerView.ViewHolder>).submitList(data)
}