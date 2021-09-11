package com.retheviper.application.web.resource

import com.retheviper.application.web.model.request.MemberUpsertForm
import com.retheviper.application.web.model.response.MemberResponse
import com.retheviper.common.extension.toMulti
import com.retheviper.common.extension.toUni
import com.retheviper.domain.dto.MemberDto
import com.retheviper.domain.service.MemberService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/api/v1/web/members")
class MemberResource(private val service: MemberService) {

    @GET
    fun listMember(): Multi<MemberResponse> {
        return service.listMember().toMulti().map(MemberResponse::from)
    }

    @GET
    @Path("/{id}")
    fun getMember(id: Int): Uni<MemberResponse> {
        return service.getMember(id).toUni().map(MemberResponse::from)
    }

    @POST
    fun createMember(request: MemberUpsertForm): Uni<MemberResponse> {
        return service.createMember(MemberDto.from(request)).toUni().map(MemberResponse::from)
    }
}