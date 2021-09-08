package com.retheviper.application.web.resource

import com.fasterxml.jackson.databind.ObjectMapper
import com.retheviper.application.web.model.response.MemberResponse
import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
@TestHTTPEndpoint(MemberResource::class)
class MemberResourceTest {

    private val mapper = ObjectMapper()

    @Test
    fun listMemberTest() {
        val expected = (0..10).map {
            MemberResponse(
                id = it,
                userId = "id$it",
                name = "name$it"
            )
        }.let { mapper.writeValueAsString(it) }

        given()
            .`when`().get()
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body(`is`(expected))
    }
}