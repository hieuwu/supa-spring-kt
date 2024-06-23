# supa-spring-kt

 [![In-progress](https://img.shields.io/badge/In-progress-%23FFac45.svg?&style=for-the-badge&logo=java&logoColor=white&color=yellow)](https://github.com/)

Spring Boot backend with RESTful APIs, session management via Supabase
<img width="720" alt="Screenshot 2024-06-05 at 00 07 52" src="https://github.com/hieuwu/supa-spring-kt/assets/43868345/8c60932e-dcf2-4994-bae9-85cb60079958">

## ⭐️ About
This project demonstrate how to integrate Supabase to a RESTful service built with Spring Boot. This backend plays as a middleware to handle requests from multiple clients via RESTful API then interact with Supabase. The common use case is using this service to public APIs to multiple clients so that each client does not have to interact with Supabase via specific SDK.

> [!TIP]
> If you want to see the more about Supabase Kotlin Multiplatform samples, check out the [supabase-kt](https://github.com/supabase-community/supabase-kt) repository.

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

## 📒 API docs & Supabase schema
### API Docs
<img width="750" alt="Screenshot 2024-06-23 at 19 29 54" src="https://github.com/hieuwu/supa-spring-kt/assets/43868345/8086c8bf-65e7-4390-a685-24d8a92777fb">

### Schema
<img width="320" alt="Screenshot 2024-06-04 at 23 16 08" src="https://github.com/hieuwu/supa-spring-kt/assets/43868345/bdfbdd05-705d-4dc1-ac2d-0ba3e845d7af">

## 👨‍💻 Run
`./gradlew run`

**Service status:** `http://localhost:8080/actuator/health`

**Swagger API:** `http://localhost:8080/swagger-ui/index.html`

### With Docker
1. Run below command to build the image
```bash
 ./gradlew build && java -jar build/libs/gs-spring-boot-docker-0.1.0.jar
```

```bash
docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker .
```
2. Run the image
```bash
docker-compose up
```

