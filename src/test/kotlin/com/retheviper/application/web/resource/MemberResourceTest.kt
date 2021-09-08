package com.retheviper.application.web.resource

import com.retheviper.application.web.model.response.MemberResponse
import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@QuarkusTest
@TestHTTPEndpoint(MemberResource::class)
class MemberResourceTest {

    @Test
    fun listMemberTest() {
        val expected = (0..10).map {
            MemberResponse(
                id = it,
                userId = "id$it",
                name = "name$it"
            )
        }

        val actual = given()
            .`when`().get()
            .then().statusCode(HttpStatus.SC_OK)
            .extract().body()
            .jsonPath().getList(".", MemberResponse::class.java)

        Assertions.assertEquals(expected, actual)
    }
}