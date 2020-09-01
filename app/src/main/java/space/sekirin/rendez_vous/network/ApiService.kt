package space.sekirin.rendez_vous.network


import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import space.sekirin.rendez_vous.data.models.ValCurs

interface ApiService {
    @GET("daily_utf8.xml")
    fun getValute() : Deferred<Response<ValCurs>>
}