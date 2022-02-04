package com.simsekselim.flowvslivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val liveData = MutableLiveData("Hello World")

    val stateFlow = MutableStateFlow("Hello World")

    val sharedFlow = MutableSharedFlow<String>()

    fun triggerLiveData(){
        liveData.value = "LiveData"
    }

    fun triggerStateFlow(){
        stateFlow.value = "StateFlow"
    }

    fun triggerFlow() : Flow<String>{
        return flow {
            repeat(5){
                emit("Item $it")
                delay(1000L)
            }
        }
    }
    fun triggerSharedFlow(){
        viewModelScope.launch {
            sharedFlow.emit("SharedFlow")
        }
    }

}