package com.supa.spring.supaspring.bucket.application

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.datetime.Instant

data class BucketDto(
    @JsonProperty("created_at")
    val createdAt: Instant,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("owner")
    val owner: String,
    @JsonProperty("updated_at")
    val updatedAt: Instant,
    val public: Boolean,
    @JsonProperty("allowed_mime_types")
    val allowedMimeTypes: List<String>? = null,
    @JsonProperty("file_size_limit")
    val fileSizeLimit: Long? = null
)