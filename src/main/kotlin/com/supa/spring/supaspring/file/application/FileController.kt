package com.supa.spring.supaspring.file.application

import com.supa.spring.supaspring.file.domain.SupabaseFileService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/files")
class FileController(val supabaseFileService: SupabaseFileService) {

    @GetMapping("/{bucketId}")
    fun getFiles(
        @PathVariable bucketId: String
    ): ResponseEntity<List<BucketItemDto>> {
        val result = supabaseFileService.getFilesInBucket(bucketId)
        return ResponseEntity<List<BucketItemDto>>(result, HttpStatusCode.valueOf(200))
    }

    @PutMapping
    fun moveFile(
        @RequestBody from: String,
        @RequestBody to: String
    ): ResponseEntity<Unit> {
        supabaseFileService.moveFile(from, to)
        return ResponseEntity(Unit, HttpStatusCode.valueOf(200))
    }

    @PostMapping("/{bucketId}")
    fun uploadFile(
        @PathVariable bucketId: String,
        @RequestBody file: MultipartFile
    ): ResponseEntity<Unit> {
        supabaseFileService.uploadFile(bucketId, file)
        return ResponseEntity(Unit, HttpStatusCode.valueOf(200))
    }

    @PostMapping("/{path}")
    fun replaceFile(
        @PathVariable path: String,
        @RequestBody file: MultipartFile
    ): ResponseEntity<Unit> {
        supabaseFileService.replaceFileAtPath(path, file)
        return ResponseEntity(Unit, HttpStatusCode.valueOf(200))
    }
}