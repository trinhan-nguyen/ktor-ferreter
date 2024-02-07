package com.ferreter.client.models

import kotlinx.serialization.Serializable

@Serializable
data class ErrorMessage(
    val errorMessage: String,
)
