package com.retheviper.domain.service

import com.retheviper.domain.dto.MemberDto
import javax.enterprise.context.ApplicationScoped
import kotlin.random.Random

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

    fun getMember(id: Int): MemberDto {
        return MemberDto(
            id = id,
            userId = "id$id",
            name = "name$id",
            password = "password$id"
        )
    }

    fun createMember(dto: MemberDto): MemberDto {
        return MemberDto(
            id = 12,
            userId = dto.userId,
            name = dto.name,
            password = dto.password,
        )
    }
}