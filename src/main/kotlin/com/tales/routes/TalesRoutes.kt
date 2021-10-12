package com.tales.routes

import com.tales.model.dataaccess.entities.Tale
import com.tales.model.dataaccess.talesrepository.ITaleRepository
import com.tales.model.dataaccess.talesrepository.TaleRepository
import com.tales.models.Tales
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.registerTalesRoutes(taleRepository: ITaleRepository) {
    routing {
        talesRouting(taleRepository)
    }
}

fun Route.talesRouting(taleRepository: ITaleRepository) {
    route("/tales") {
        get {
            val tales: List<Tale> = taleRepository.getAllTales()

            if (tales.isNotEmpty()) {
                call.respond(tales.map { Tales(it.id, it.name, it.description, it.author) })
            } else {
                call.respondText("No customers found", status = HttpStatusCode.NotFound)
            }
        }
    }
}
