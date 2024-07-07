package com.supa.spring.supaspring.auth.application

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController {
    @PostMapping("/signup")
    fun signUp(
        @RequestBody  signUpRequest: SignUpRequest
    ) {

    }

    @PostMapping("/signin")
    fun signIn() {

    }
}