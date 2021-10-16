package com.tales.routes

import com.tales.model.dataaccess.entities.Tale
import com.tales.model.services.IQueryServiceNoInput
import com.tales.model.services.findalltales.FindAllTalesResult
import com.tales.models.Tales
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.allTales(talesService: IQueryServiceNoInput<FindAllTalesResult>) {
    get("/tales") {
        val tales: List<Tale> = talesService.execute().tales

        if (tales.isNotEmpty()) {
            call.respond(tales.map { Tales(it.id, it.name, it.description, it.author) })
        } else {
            call.respondText("No customers found", status = HttpStatusCode.NotFound)
        }
    }
}
