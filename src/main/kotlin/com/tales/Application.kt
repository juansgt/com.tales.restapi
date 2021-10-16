package com.tales

import com.tales.model.dataaccess.talesrepository.ITaleRepository
import com.tales.model.dataaccess.talesrepository.TaleRepository
import com.tales.model.services.ITalesService
import com.tales.model.services.TalesService
import com.tales.routes.allTales
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.serialization.*
import org.koin.dsl.module
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

val koinModule = module {
    single<ITaleRepository>() { TaleRepository() }
    single<ITalesService>() { TalesService(get()) }
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    install(Koin) {
        modules(koinModule)
    }
    val talesService: ITalesService by inject()

    routing {
        allTales(talesService)
    }
}
