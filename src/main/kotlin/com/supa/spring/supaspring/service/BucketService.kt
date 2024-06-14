package com.supa.spring.supaspring.service

import com.supa.spring.supaspring.controller.dto.BucketDto
import com.supa.spring.supaspring.repository.BucketRepository
import org.springframework.stereotype.Service

@Service
class BucketService(
    val bucketRepository: BucketRepository
) {
    fun getBuckets(): List<BucketDto> {
        return bucketRepository.getBuckets()
    }

    fun getBucketDetails(bucketId: String): BucketDto? {
        return bucketRepository.getBucketDetails(bucketId)
    }

    fun createBucket(bucketId: String) {
        bucketRepository.createBucket(bucketId)
    }

    fun updateBucket(bucketId: String) {
        bucketRepository.updateBucket(bucketId)
    }

    fun deleteBucket(bucketId: String) {
        bucketRepository.deleteBucket(bucketId)
    }

    fun emptyBucket(bucketId: String) {
        bucketRepository.emptyBucket(bucketId)
    }
}