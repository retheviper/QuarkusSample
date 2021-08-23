package com.retheviper.application.web.config

import org.jboss.logging.Logger
import javax.inject.Inject
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.ext.Provider

@Provider
class LoggingInterceptor : ContainerRequestFilter {

    @Inject
    private lateinit var log: Logger

    override fun filter(requestContext: ContainerRequestContext?) {
        log.info("[${requestContext?.request?.method}] ${requestContext?.uriInfo?.path}")
    }
}