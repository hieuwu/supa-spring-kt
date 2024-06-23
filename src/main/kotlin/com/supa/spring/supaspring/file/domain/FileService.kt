package com.supa.spring.supaspring.file.domain

import com.supa.spring.supaspring.file.application.BucketItemDto
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun getFilesInBucket(bucketId: String): List<BucketItemDto>
    fun moveFile(from: String, to: String)
    fun uploadFile(bucketId: String, file: MultipartFile)
    fun replaceFileAtPath(path: String, file: MultipartFile)
}