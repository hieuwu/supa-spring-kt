package com.supa.spring.supaspring.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDto(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("price")
    val price: Long,
)
