package space.sekirin.rendez_vous

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel: ViewModel() {

    private val parentJob = Job()

    private var valuts: MutableList<Valute>? = mutableListOf()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository: ValuteRepository = ValuteRepository(ApiFactory.apiService)

    val valuteLiveData = MutableLiveData<List<Valute>>()

    fun setList(position: Int){

        valuts?.add(0, valuts!![position])
        valuts?.removeAt(position + 1)

        valuteLiveData.value = valuts
    }

    fun fetchValute(){
        scope.launch {
            val valutes = repository.getValuts()
            valuts = valutes
            for (i in 0 until valutes!!.size-1){
                if(valutes[i].charCode.equals("USD")){
                    valutes.add(0, valutes[i])
                    valutes.removeAt(i + 1)
                }
            }
            valuteLiveData.postValue(valutes)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}