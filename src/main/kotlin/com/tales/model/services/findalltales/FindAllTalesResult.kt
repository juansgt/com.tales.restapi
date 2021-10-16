package com.tales.model.services.findalltales

import com.tales.model.dataaccess.entities.Tale

data class FindAllTalesResult(val tales: List<Tale>)