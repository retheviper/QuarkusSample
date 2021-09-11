package com.retheviper.domain.dto

import com.retheviper.application.web.model.request.MemberUpsertForm
import com.retheviper.infrastructure.entity.Member

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

        fun from(entity: Member): MemberDto =
            MemberDto(
                id = entity.id,
                userId = entity.userId,
                name = entity.name,
                password = entity.password,
                memberInformationId = entity.memberInformationId,
                accountNonExpired = entity.accountNonExpired,
                accountNonLocked = entity.accountNonLocked,
                credentialsNonExpired = entity.credentialsNonExpired,
                enabled = entity.enabled,
                deleted = entity.deleted
            )
    }
}