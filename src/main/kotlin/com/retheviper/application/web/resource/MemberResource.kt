package com.retheviper.application.web.resource

import com.retheviper.application.web.model.request.MemberUpsertForm
import com.retheviper.application.web.model.response.MemberResponse
import com.retheviper.domain.dto.MemberDto
import com.retheviper.domain.service.MemberService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType

@Path("/api/v1/web/members")
class MemberResource(private val service: MemberService) {

    @GET
    fun listMember(): Multi<MemberResponse> {
        return Multi.createFrom().iterable(service.listMember()).map { MemberResponse.from(it) }
    }

    @GET
    @Path("/{id}")
    fun getMember(id: Int): Uni<MemberResponse> {
        return Uni.createFrom().item(service.getMember(id)).map { MemberResponse.from(it) }
    }

    @POST
    fun createMember(request: MemberUpsertForm): Uni<MemberResponse> {
        return Uni.createFrom().item(service.createMember(MemberDto.from(request))).map { MemberResponse.from(it) }
    }
}