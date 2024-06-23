package com.supa.spring.supaspring

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.serializer.JacksonSerializer
import io.github.jan.supabase.storage.Storage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SupabaseConfiguration {
    @Bean
    fun supabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://tyjxzodfrahibdkhgquy.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR5anh6b2RmcmFoaWJka2hncXV5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODUxMTM2MDcsImV4cCI6MjAwMDY4OTYwN30.rXN-_rGEHKjOlo75xoDYOPkshrno9rK7h1H-CXFb2_g"
        ) {
            install(Auth)
            install(Postgrest)
            install(Storage)
            defaultSerializer = JacksonSerializer()
        }
    }
}