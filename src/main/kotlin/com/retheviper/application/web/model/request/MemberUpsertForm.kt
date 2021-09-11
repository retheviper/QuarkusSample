package com.retheviper.application.web.model.request

data class MemberUpsertForm(
    val userId: String,
    val name: String,
    val password: String
)