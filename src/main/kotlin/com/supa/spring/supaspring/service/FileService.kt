package com.supa.spring.supaspring.service

import com.supa.spring.supaspring.controller.dto.BucketItemDto
import com.supa.spring.supaspring.repository.FileRepository
import org.springframework.stereotype.Service
import org.springframework.util.MultiValueMap
import org.springframework.web.multipart.MultipartFile

@Service
class FileService(val fileRepository: FileRepository) {
    fun getFilesInBucket(bucketId: String): List<BucketItemDto> {
        return fileRepository.getFilesInBucket(bucketId)
    }

    fun moveFile(from: String, to: String) {

    }

    fun uploadFile(bucketId: String, file: MultipartFile) {

    }

    fun replaceFileAtPath(path: String, file: MultipartFile) {

    }
}