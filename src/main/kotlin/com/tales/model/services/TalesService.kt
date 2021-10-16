package com.tales.model.services

import com.tales.model.dataaccess.entities.Tale
import com.tales.model.dataaccess.talesrepository.ITaleRepository
import com.tales.model.dataaccess.talesrepository.TaleRepository

class TalesService(private val taleRepository: ITaleRepository) : ITalesService {
    override fun getAllTales(): List<Tale> = taleRepository.getAllTales()
}