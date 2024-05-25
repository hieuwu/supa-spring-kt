package com.supa.spring.supaspring.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class ProductDto(
    @JsonProperty("id", required = false)
    val id: String = UUID.randomUUID().toString(),
    @JsonProperty("name")
    val name: String,
    @JsonProperty("price")
    val price: Long,
    @JsonProperty("image", required = false)
    val image: String,
)
