package com.retheviper.application.web.resource

import com.retheviper.application.web.model.request.MemberUpsertForm
import com.retheviper.application.web.model.response.MemberResponse
import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
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

    @Test
    fun getMemberTest() {
        val expected = MemberResponse(
            id = 11,
            userId = "id11",
            name = "name11"
        )

        val actual = given()
            .`when`().get("/11")
            .then().statusCode(HttpStatus.SC_OK)
            .extract()
            .`as`(MemberResponse::class.java)

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun createMemberTest() {
        val expected = MemberResponse(
            id = 12,
            userId = "userId",
            name = "userName"
        )

        val request = MemberUpsertForm(
            userId = expected.userId,
            name = expected.name,
            password = "1234"
        )

        val actual = given()
            .contentType(ContentType.JSON)
            .body(request)
            .`when`().post()
            .then().statusCode(HttpStatus.SC_OK)
            .extract()
            .`as`(MemberResponse::class.java)

        Assertions.assertEquals(expected, actual)
    }
}