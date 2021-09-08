package com.retheviper.domain.service

import com.retheviper.domain.dto.MemberDto
import io.quarkus.test.junit.DisabledOnNativeImage
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@QuarkusTest
@DisabledOnNativeImage
class MemberServiceTest {

    @Inject
    private lateinit var service: MemberService

    @Test
    fun listMemberTest() {
        val expected = (0..10).map {
            MemberDto(
                id = it,
                userId = "id$it",
                name = "name$it",
                password = "password$it"
            )
        }

        val actual = service.listMember()

        Assertions.assertEquals(expected, actual)
    }
}