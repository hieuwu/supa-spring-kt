package com.supa.spring.supaspring.controller

import com.supa.spring.supaspring.controller.dto.BucketDto
import com.supa.spring.supaspring.service.BucketService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/buckets")
class BucketController(
    private val bucketService: BucketService,
) {

    @GetMapping
    fun getBuckets(): ResponseEntity<List<BucketDto>> {
        val result = bucketService.getBuckets()
        return ResponseEntity<List<BucketDto>>(result, HttpStatusCode.valueOf(200))
    }

    @GetMapping("/{bucketId}")
    fun getBucketDetails(@PathVariable bucketId: String) {
        bucketService.getBucketDetails(bucketId)
    }

    @PostMapping("/{bucketId}")
    fun createBucket(@PathVariable bucketId: String) {
        bucketService.createBucket(bucketId)
    }

    @PutMapping("/{bucketName}")
    fun updateBucket(@PathVariable bucketId: String) {
        bucketService.updateBucket(bucketId)
    }

    @DeleteMapping("/{bucketName}")
    fun deleteBucket(@PathVariable bucketId: String) {
        bucketService.deleteBucket(bucketId)
    }

}