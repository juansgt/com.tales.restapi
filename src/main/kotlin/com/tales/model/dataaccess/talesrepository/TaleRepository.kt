package com.tales.model.dataaccess.talesrepository

import com.mongodb.client.MongoDatabase
import com.tales.model.dataaccess.entities.Tale
import org.litote.kmongo.KMongo
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

class TaleRepository(private val mongoDatabase: MongoDatabase) : ITaleRepository {

    override fun getAllTales() : List<Tale>{
        val talesMongoCollection = mongoDatabase.getCollection<Tale>("Tales")

        return  talesMongoCollection.find().toList()
    }
}