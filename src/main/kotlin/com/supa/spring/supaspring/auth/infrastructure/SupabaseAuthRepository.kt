package com.supa.spring.supaspring.auth.infrastructure

import com.supa.spring.supaspring.auth.domain.AuthRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.exceptions.HttpRequestException
import io.github.jan.supabase.exceptions.RestException
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.ktor.client.plugins.*
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Repository

@Repository
class SupabaseAuthRepository(
    supabase: SupabaseClient
) : AuthRepository {
    val auth: Auth = supabase.auth

    override fun signIn(email: String, password: String) {
        exceptionWrapper {
            auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
        }
    }

    override fun signUp(email: String, password: String) {
        exceptionWrapper {
            auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
        }
    }

    private fun exceptionWrapper(action: suspend () -> Unit) {
        try {
            runBlocking {
                action
            }
        } catch (e: RestException) {
            // no-op
        } catch (e: HttpRequestTimeoutException) {
            // no-op
        } catch (e: HttpRequestException) {
            // no-op
        }
    }
}