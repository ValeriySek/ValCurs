package space.sekirin.rendez_vous.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object ApiFactory {

    private val client = OkHttpClient().newBuilder()
        .addInterceptor(ResponseInterceptor())
        .build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://www.cbr-xml-daily.ru/")
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val apiService: ApiService = retrofit()
        .create(
        ApiService::class.java)
}