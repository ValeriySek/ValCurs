package space.sekirin.rendez_vous

import okhttp3.Interceptor
import okhttp3.Response

class ResponseInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val modified = chain.request().newBuilder()
            .removeHeader("Content-Type")
            .addHeader("Content-Type", "charset=utf-8")


        return chain.proceed(modified.build())
    }
}