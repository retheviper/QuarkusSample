package com.retheviper.domain.service

import com.retheviper.domain.dto.MemberDto
import com.retheviper.infrastructure.entity.Member
import com.retheviper.infrastructure.repository.MemberRepository
import org.jboss.logging.Logger
import java.time.LocalDateTime
import javax.enterprise.context.ApplicationScoped
import kotlin.system.measureTimeMillis

@ApplicationScoped
class MemberService(private val repository: MemberRepository, private val log: Logger) {

    fun listMember(): List<MemberDto> {
        var result: List<Member>
        val elapse = measureTimeMillis {
            result = repository.list()
        }
        log.info("measured time was $elapse ms")
        return result.map(MemberDto::from)
    }

    fun getMember(id: Int): MemberDto {
        return repository.findById(id).let(MemberDto::from)
    }

    fun createMember(dto: MemberDto): MemberDto {
        return repository.create(
            Member(
                id = 12,
                userId = "id12",
                name = "name12",
                password = "password12",
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
        ).let(MemberDto::from)
    }
}