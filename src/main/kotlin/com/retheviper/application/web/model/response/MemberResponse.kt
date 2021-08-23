package com.retheviper.application.web.model.response

import com.retheviper.domain.dto.MemberDto

data class MemberResponse(

    /** ID */
    val id: Int,

    /** Member's ID (User ID) */
    val userId: String,

    /** Member's real name */
    val name: String
) {
    companion object {
        fun from(dto: MemberDto): MemberResponse =
            MemberResponse(
                id = checkNotNull(dto.id),
                userId = dto.userId,
                name = dto.name,
            )
    }
}