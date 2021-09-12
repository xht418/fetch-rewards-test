package com.example.fetchrewardstest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Product(val id: Long, val listId: Long, val name: String?) : Parcelable