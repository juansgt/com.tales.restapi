package com.tales.models

import kotlinx.serialization.Serializable

@Serializable
data class Tales(
    val id: String,
    val name: String,
    val description: String,
    val author: String)
