package com.dicoding.jetpackprosub2.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private const val RESOURCE: String = "GLOBAL"
    private val esIdlingRes = CountingIdlingResource(RESOURCE)

    fun increment() = esIdlingRes.increment()
    fun decrement() = esIdlingRes.decrement()
    fun getEspressoIdlingResource(): IdlingResource = esIdlingRes
}