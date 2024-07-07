package com.supa.spring.supaspring.auth.domain

import org.springframework.stereotype.Service

@Service
class SupabaseAuthService constructor(val authRepository: AuthRepository) : AuthService {
    override fun signUp(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun signIn(email: String, password: String) {
        TODO("Not yet implemented")
    }
}