package com.tales.routes

import com.tales.model.dataaccess.entities.Tale
import com.tales.model.services.ITalesService
import com.tales.models.Tales
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.allTales(talesService: ITalesService) {
    get("/tales") {
        val tales: List<Tale> = talesService.getAllTales()

        if (tales.isNotEmpty()) {
            call.respond(tales.map { Tales(it.id, it.name, it.description, it.author) })
        } else {
            call.respondText("No customers found", status = HttpStatusCode.NotFound)
        }
    }
}
