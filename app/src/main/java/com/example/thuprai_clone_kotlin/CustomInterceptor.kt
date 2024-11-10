import okhttp3.Interceptor
import okhttp3.Response

// CustomInterceptor.kt
class CustomInterceptor(private val secureStorageService: SecureStorageService) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        // Get token from secure storage
        val token = secureStorageService.getData("auth_token")

        // Build new request with headers
        val newRequest = originalRequest.newBuilder()
            .addHeader("Content-Type", "application/json")
            // Add token if it exists
            .apply {
                token?.let {
                    addHeader("Authorization", "Bearer $it")
                }
            }
            .build()

        return chain.proceed(newRequest)
    }
}