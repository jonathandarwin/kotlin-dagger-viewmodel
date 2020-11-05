package com.jonathandarwin.dagger.dto

data class UserResponse (
    val data : List<UserItemResponse>
)

data class UserItemResponse(
    val email : String,
    val first_name : String,
    val last_name : String
)