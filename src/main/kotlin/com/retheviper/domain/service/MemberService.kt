package com.retheviper.domain.service

import com.retheviper.domain.dto.MemberDto
import org.jboss.logging.Logger
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class MemberService {

    @Inject
    private lateinit var log: Logger

    fun listMember(): List<MemberDto> {
        log.info("listMember")
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