package com.tales.plugins

import com.tales.model.dataaccess.talesrepository.ITaleRepository
import com.tales.model.dataaccess.talesrepository.TaleRepository
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

//fun Application.configureRouting() {
//    routing {
//        get("/tales") {
//                val taleRepository: ITaleRepository  = TaleRepository()
//                call.respond(taleRepository.getAllTales())
//        }
//    }
//}
