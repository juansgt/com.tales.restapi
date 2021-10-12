package com.tales.model.dataaccess.talesrepository

import com.tales.model.dataaccess.entities.Tale

class TaleRepository : ITaleRepository {
    private val customerStorage = mutableListOf<Tale>(Tale("1","Name","Description","Author"))

    override fun getAllTales(): List<Tale> = customerStorage
}