package com.retheviper.domain.dto

import com.retheviper.application.web.model.request.MemberUpsertForm

data class MemberDto(
    val id: Int? = null,
    val userId: String,
    val name: String,
    val password: String,
    val newPassword: String? = null,
    val memberInformationId: Int? = null,
    val accountNonExpired: Boolean? = true,
    val accountNonLocked: Boolean? = true,
    val credentialsNonExpired: Boolean? = true,
    val enabled: Boolean? = true,
    val deleted: Boolean? = false
) {
    companion object {
        fun from(request: MemberUpsertForm): MemberDto =
            MemberDto(
                id = null,
                userId = request.userId,
                name = request.name,
                password = request.password
            )
    }
}