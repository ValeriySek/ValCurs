package space.sekirin.rendez_vous

class ValuteRepository(private val api: ApiService): BaseRepository() {

    suspend fun getValuts() : MutableList<Valute>?{
        val valuteResponse = safeApiCall(
            call = {api.getValute().await()},
            errorMessage = "eroor error"
        )

        return valuteResponse?.valutes?.toMutableList()
    }
}