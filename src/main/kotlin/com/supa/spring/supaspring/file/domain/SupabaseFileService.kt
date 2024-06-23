package com.supa.spring.supaspring.file.domain

import com.supa.spring.supaspring.file.application.BucketItemDto
import com.supa.spring.supaspring.file.infrastructure.SupabaseFileRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class SupabaseFileService(val supabaseFileRepository: SupabaseFileRepository) : FileService {
    override fun getFilesInBucket(bucketId: String): List<BucketItemDto> {
        return supabaseFileRepository.getFilesInBucket(bucketId)
    }

    override fun moveFile(from: String, to: String) {
        supabaseFileRepository.moveFile(from, to)
    }

    override fun uploadFile(bucketId: String, file: MultipartFile) {
        supabaseFileRepository.uploadFile(bucketId, file)

    }

    override fun replaceFileAtPath(path: String, file: MultipartFile) {
        supabaseFileRepository.replaceFileAtPath(path, file)
    }
}