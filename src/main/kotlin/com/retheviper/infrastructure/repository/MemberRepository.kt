package com.retheviper.infrastructure.repository

import com.retheviper.infrastructure.entity.Member
import java.time.LocalDateTime
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MemberRepository {

    fun list(): List<Member> {
        return (0..10).map {
            findById(it)
        }
    }

    fun findById(id: Int): Member {
        return Member(
            id = id,
            userId = "id$id",
            name = "name$id",
            password = "password$id",
            createdBy = "System",
            createdDate = LocalDateTime.now(),
            lastModifiedBy = "System",
            lastModifiedDate = LocalDateTime.now(),
            accountNonExpired = true,
            accountNonLocked = true,
            credentialsNonExpired = true,
            enabled = true,
            deleted = false,
            memberInformationId = null
        )
    }

    fun create(entity: Member): Member {
        return entity
    }
}