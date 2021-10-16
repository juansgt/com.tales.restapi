package com.tales.model.services

import com.tales.model.dataaccess.entities.Tale

interface ITalesService {
    fun getAllTales(): List<Tale>
}