package com.tales.model.services.findalltales

import com.tales.model.dataaccess.talesrepository.ITaleRepository
import com.tales.model.services.IQueryServiceNoInput

class FindAllTalesService(private val taleRepository: ITaleRepository) : IQueryServiceNoInput<FindAllTalesResult> {
    override fun execute(): FindAllTalesResult = FindAllTalesResult(taleRepository.getAllTales())
}