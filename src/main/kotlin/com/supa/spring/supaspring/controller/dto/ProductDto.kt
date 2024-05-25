package com.supa.spring.supaspring.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDto(
    @JsonProperty("id")
    var id: String,
    @JsonProperty("name")
    var name: String,
    @JsonProperty("price")
    var price: Long,
    @JsonProperty("image", required = false)
    var image: String,
)
