package com.devtechnology.coi.fuzzy

import com.devtechnology.coi.fuzzy.data.Hello
import com.devtechnology.coi.fuzzy.data.MongoConnector
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.host.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.util.toMap
import org.litote.kmongo.getCollection
import org.litote.kmongo.save


fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText(getAllHellosFromMongo(), ContentType.Text.Html)
            }
            get(path = "/mirror") {
                val sb = StringBuilder()
                call.request.queryParameters.forEach { s, list -> sb.append(s).append(list) }
                call.respondText ( sb.toString(), ContentType.Text.Html )
            }
            post(path = "/putHello") {
                val entries: List<Hello> = call.request.queryParameters.toMap()
                        .map { entry -> Hello(name = entry.key, text = entry.value[0]) }
                entries.forEach(insertHello(it))

            }
        }
    }
    server.start(wait = true)
}

fun getHelloString() = "Hello World"

fun getAllHellosFromMongo() : String {
    val sb = StringBuilder()
    MongoConnector.getCollection("hello").find().forEach { sb.append(" ${it.text} by ${it.by} @ ${it.date}") }
    return sb.toString()
}

fun insertHello(newHello: Hello) {
    MongoConnector.database.getCollection<Hello>().save(newHello)
}