package com.retheviper.domain.service

import com.retheviper.domain.dto.MemberDto
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MemberService {

    fun listMember(): List<MemberDto> {
        return (0..10).map {
            MemberDto(
                id = it,
                userId = "id$it",
                name = "name$it",
                password = "password$it"
            )
        }
    }
}