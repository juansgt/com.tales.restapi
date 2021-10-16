package com.tales.model.dataaccess.entities

import org.bson.codecs.pojo.annotations.BsonId

data class Tale (
    @BsonId val id: String,
    val name: String,
    val description: String,
    val author: String)