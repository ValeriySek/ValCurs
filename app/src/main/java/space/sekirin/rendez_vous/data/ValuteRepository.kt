package space.sekirin.rendez_vous.data

import space.sekirin.rendez_vous.data.models.Valute
import space.sekirin.rendez_vous.network.ApiService

class ValuteRepository(private val api: ApiService): BaseRepository() {

    suspend fun getValuts() : MutableList<Valute>?{
        val valuteResponse = safeApiCall(
            call = {api.getValute().await()},
            errorMessage = "eroor error"
        )

        return valuteResponse?.valutes?.toMutableList()
    }
}