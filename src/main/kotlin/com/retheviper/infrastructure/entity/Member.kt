package com.retheviper.infrastructure.entity

import java.time.LocalDateTime

data class Member(

    var id: Int?,

    val userId: String,

    val name: String,

    val password: String,

    val createdBy: String,

    val createdDate: LocalDateTime,

    val lastModifiedBy: String,

    val lastModifiedDate: LocalDateTime,

    val accountNonExpired: Boolean,

    val accountNonLocked: Boolean,

    val credentialsNonExpired: Boolean,

    val enabled: Boolean,

    val deleted: Boolean,

    val memberInformationId: Int?
)
