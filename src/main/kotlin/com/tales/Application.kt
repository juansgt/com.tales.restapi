package com.tales

import com.tales.model.dataaccess.talesrepository.ITaleRepository
import com.tales.model.dataaccess.talesrepository.TaleRepository
import com.tales.routes.registerTalesRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import org.koin.core.scope.get
import org.koin.dsl.module
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject
import org.koin.ktor.ext.modules


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

val koinModule = module {
    single<ITaleRepository>() { TaleRepository() }
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    install(Koin) {
        modules(koinModule)
    }
    val taleRepository: ITaleRepository by inject()
    registerTalesRoutes(taleRepository)
}
