package com.tales.modules

data class Tale(
    val id: String,
    val name: String,
    val description: String,
    val Author: String)

val customerStorage = mutableListOf<Tale>()

