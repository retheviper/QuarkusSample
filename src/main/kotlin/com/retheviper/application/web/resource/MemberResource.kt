package com.retheviper.application.web.resource

import com.retheviper.application.web.model.response.MemberResponse
import com.retheviper.domain.service.MemberService
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/api/v1/web/members")
class MemberResource(private val service: MemberService) {

    @GET
    suspend fun listMember(): List<MemberResponse> {
        return service.listMember().map { MemberResponse.from(it) }
    }
}