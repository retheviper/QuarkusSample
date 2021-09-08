package com.retheviper.application.web.filter

import org.jboss.logging.Logger
import org.jboss.resteasy.reactive.server.ServerRequestFilter
import org.jboss.resteasy.reactive.server.ServerResponseFilter
import javax.inject.Inject
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerResponseContext

class LoggingFilter {

    @Inject
    private lateinit var log: Logger

    @ServerRequestFilter
    fun filterRequest(context: ContainerRequestContext) {
        log.info("[${context.method}] ${context.uriInfo.path}")
    }

    @ServerResponseFilter
    fun filterResponse(context: ContainerResponseContext) {
        log.info("Finished with status ${context.status} ${context.statusInfo.reasonPhrase}.")
    }
}