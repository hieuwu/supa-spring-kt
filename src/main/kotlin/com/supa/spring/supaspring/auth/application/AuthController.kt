package com.supa.spring.supaspring.auth.application

import com.supa.spring.supaspring.auth.domain.AuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {
    @PostMapping("/signup")
    fun signUp(
        @RequestBody authRequestDto: AuthRequestDto
    ): ResponseEntity<Unit> {
        authService.signUp(authRequestDto.email, authRequestDto.password)
        return ResponseEntity<Unit>(HttpStatus.OK)
    }

    @PostMapping("/signin")
    fun signIn(
        @RequestBody authRequestDto: AuthRequestDto
    ): ResponseEntity<Unit> {
        authService.signIn(authRequestDto.email, authRequestDto.password)
        return ResponseEntity<Unit>(HttpStatus.OK)
    }
}