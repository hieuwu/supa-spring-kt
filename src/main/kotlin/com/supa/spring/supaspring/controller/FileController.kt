package com.supa.spring.supaspring.controller

import com.supa.spring.supaspring.controller.dto.BucketItemDto
import com.supa.spring.supaspring.service.FileService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/files")
class FileController(val fileService: FileService) {

    @GetMapping("/{bucketId}")
    fun getFiles(
        @PathVariable bucketId: String
    ): ResponseEntity<List<BucketItemDto>> {
        val result = fileService.getFilesInBucket(bucketId)
        return ResponseEntity<List<BucketItemDto>>(result, HttpStatusCode.valueOf(200))
    }

    @PutMapping
    fun moveFile(
        @RequestBody from: String,
        @RequestBody to: String
    ): ResponseEntity<Unit> {
        fileService.moveFile(from, to)
        return ResponseEntity(Unit, HttpStatusCode.valueOf(200))
    }

    @PostMapping("/{bucketId}")
    fun uploadFile(
        @PathVariable bucketId: String,
        @RequestBody file: MultipartFile
    ): ResponseEntity<Unit> {
        fileService.uploadFile(bucketId, file)
        return ResponseEntity(Unit, HttpStatusCode.valueOf(200))
    }

    @PostMapping("/{path}")
    fun replaceFile(
        @PathVariable path: String,
        @RequestBody file: MultipartFile
    ): ResponseEntity<Unit> {
        fileService.replaceFileAtPath(path, file)
        return ResponseEntity(Unit, HttpStatusCode.valueOf(200))
    }
}