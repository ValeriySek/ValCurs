package space.sekirin.rendez_vous


import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("daily_utf8.xml")
    fun getValute() : Deferred<Response<ValCurs>>
}