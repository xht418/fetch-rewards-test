package com.example.fetchrewardstest.util

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.MediaType

fun String.toMediaType(): MediaType = MediaType.get(this)

fun <T> StateFlow<T>.collect(coroutineScope: CoroutineScope, action: (T) -> Unit) = coroutineScope.launch {
    collect { T -> action(T) }
}

fun AppCompatActivity.getNavHostFragmentById(id: Int) = supportFragmentManager.findFragmentById(id) as NavHostFragment

fun AndroidViewModel.showToastLong(text: String) = Toast.makeText(getApplication(), text, Toast.LENGTH_LONG).show()