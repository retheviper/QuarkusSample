package com.retheviper.application.web.resource

import com.retheviper.application.web.model.response.MemberResponse
import com.retheviper.domain.service.MemberService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/api/v1/web/members")
class MemberResource {

    @Inject
    private lateinit var service: MemberService

    @GET
    fun listMember(): List<MemberResponse> {
        return service.listMember().map { MemberResponse.from(it) }
    }
}