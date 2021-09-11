package com.retheviper.application.web.resource

import com.retheviper.application.config.GreetingConfig
import io.smallrye.mutiny.Uni
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/")
class GreetingResource(private val config: GreetingConfig) {

    @GET
    fun getGreetingMessage(): Uni<String> {
        return Uni.createFrom().item(config.message() ?: "hello there!")
    }
}