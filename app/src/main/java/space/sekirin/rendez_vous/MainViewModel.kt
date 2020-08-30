package space.sekirin.rendez_vous

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel: ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository: ValuteRepository = ValuteRepository(ApiFactory.apiService)

    val valuteLiveData = MutableLiveData<List<Valute>>()

    fun fetchValute(){
        scope.launch {
            val valutes = repository.getValuts()
            valuteLiveData.postValue(valutes)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}