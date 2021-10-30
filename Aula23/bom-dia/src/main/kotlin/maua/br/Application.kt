package maua.br

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import maua.br.plugins.*

fun main() {
    //padrão port = 8080
    embeddedServer(Netty, port = 80, host = "0.0.0.0") {
        routing {
            get("/"){
                call.respondText("Ola Mundo!")
            }
            get("/ola"){
                call.respondText { "Agora você mudou de rota" }
            }
            get("/nome/{nome}"){
                call.respondText{"Bem vindo ${call.parameters["nome"]}"}
            }
        }
    }.start(wait = true)
}
