package com.supa.spring.supaspring.auth.domain

interface AuthService {
    fun signUp(email: String, password: String)
    fun signIn(email: String, password: String)
}