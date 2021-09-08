package com.retheviper.application.web.resource

import com.retheviper.application.web.config.GreetingConfig
import com.retheviper.application.web.model.response.MemberResponse
import com.retheviper.domain.service.MemberService
import org.jboss.logging.Logger
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import kotlin.system.measureTimeMillis

@Path("/")
class GreetingResource {

    @Inject
    private lateinit var config: GreetingConfig

    @GET
    fun listMember(): String {
        return config.message() ?: "hello there!"
    }
}