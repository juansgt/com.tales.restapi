package com.tales.model.dataaccess.talesrepository

import com.tales.model.dataaccess.entities.Tale

interface ITaleRepository {
    fun getAllTales(): List<Tale>
}