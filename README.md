# supa-spring-kt

 [![In-progress](https://img.shields.io/badge/In-progress-%23FFac45.svg?&style=for-the-badge&logo=java&logoColor=white&color=yellow)](https://github.com/)

Spring Boot backend with RESTful APIs, session management via Supabase

## ⭐️ About

## ⚙️ Setup
1. Get started with Spring Boot project with [Spring Initializr](https://start.spring.io/), select Kotlin and Java 17 (JVM)

2. Add dependencies to `build.gradle`
```kotlin
val ktor_version = "2.3.10"
implementation("io.ktor:ktor-client-core:$ktor_version")
implementation("io.ktor:ktor-client-java:$ktor_version")
implementation("io.ktor:ktor-client-cio:$ktor_version")

val supabaseVersion = "2.4.0"
implementation(platform("io.github.jan-tennert.supabase:bom:$supabaseVersion"))
implementation("io.github.jan-tennert.supabase:gotrue-kt")
implementation("io.github.jan-tennert.supabase:postgrest-kt")
implementation("io.github.jan-tennert.supabase:storage-kt")
implementation("io.github.jan-tennert.supabase:serializer-jackson:$supabaseVersion")
```

3. Create `SupabaseConfiguration` class to provide Supabase client instance:
```kotlin
@Configuration
class SupabaseConfiguration {
    @Bean
    fun supabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "SUPABASE_URL",
            supabaseKey = "SUPABASE_KEY"
        ) {
            install(Auth)
            install(Postgrest)
            defaultSerializer = JacksonSerializer()
        }
    }
}
```
4. Use Supabase Client
```kotlin
@Repository
class ProductRepository(supabase: SupabaseClient) {
    ...
}
```

## 📒 Swagger API & Supabase schema
### API Docs
<img width="720" alt="Screenshot 2024-06-04 at 22 13 20" src="https://github.com/hieuwu/supa-spring-kt/assets/43868345/9adb1934-a467-46d5-b5cf-9d70eff76ce3">

### Schema
<img width="320" alt="Screenshot 2024-06-04 at 23 16 08" src="https://github.com/hieuwu/supa-spring-kt/assets/43868345/bdfbdd05-705d-4dc1-ac2d-0ba3e845d7af">

## 👨‍💻 Run
`./gradlew run`

**Service status:** `http://localhost:8080/actuator/health`

**Swagger API:** `http://localhost:8080/swagger-ui/index.html`
