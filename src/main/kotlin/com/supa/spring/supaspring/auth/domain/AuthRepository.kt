package com.supa.spring.supaspring.auth.domain

interface AuthRepository {
    fun signIn(email: String, password: String)
    fun signUp(email: String, password: String)
}