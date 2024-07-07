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
        @RequestBody signUpRequestDto: SignUpRequestDto
    ): ResponseEntity<Unit> {
        authService.signUp(signUpRequestDto.email, signUpRequestDto.password)
        return ResponseEntity<Unit>(HttpStatus.OK)
    }

    @PostMapping("/signin")
    fun signIn() {
    }
}