package com.tales.model.dataaccess.talesrepository

import com.tales.model.dataaccess.entities.Tale

class TaleRepositoryNoMongo : ITaleRepository {
    override fun getAllTales(): List<Tale> = ArrayList<Tale>()

}