package com.supa.spring.supaspring.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.datetime.Instant
import kotlinx.serialization.json.JsonObject

data class BucketItemDto(
    val name: String,
    val id: String?,
    @JsonProperty("updated_at")
    val updatedAt: Instant?,
    @JsonProperty("created_at")
    val createdAt: Instant?,
    @JsonProperty("last_accessed_at")
    val lastAccessedAt: Instant?,
    val metadata: JsonObject?
)