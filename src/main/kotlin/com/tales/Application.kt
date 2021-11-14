package com.tales

import com.tales.model.dataaccess.talesrepository.ITaleRepository
import com.tales.model.dataaccess.talesrepository.TaleRepository
import com.tales.model.services.IQueryServiceNoInput
import com.tales.model.services.findalltales.FindAllTalesResult
import com.tales.model.services.findalltales.FindAllTalesService
import com.tales.routes.allTales
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.serialization.*
import org.koin.dsl.module
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject
import org.litote.kmongo.KMongo


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

val koinModule = module {
    val client = KMongo.createClient("mongodb+srv://atlasAdmin:L0git3ch@cluster0.yolpv.mongodb.net/Books?retryWrites=true&w=majority) //get com.mongodb.MongoClient new instance")
    val database = client.getDatabase("Books") //normal java driver usage

    single<ITaleRepository>() { TaleRepository(database) }
    single<IQueryServiceNoInput<FindAllTalesResult>>() { FindAllTalesService(get()) }
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    install(Koin) {
        modules(koinModule)
    }
    val talesService: IQueryServiceNoInput<FindAllTalesResult> by inject()

    routing {
        allTales(talesService)
    }
}
