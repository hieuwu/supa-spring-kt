package com.supa.spring.supaspring.file.domain

import com.supa.spring.supaspring.file.application.BucketItemDto

interface FileRepository {
    fun getFilesInBucket(bucketId: String): List<BucketItemDto>
}