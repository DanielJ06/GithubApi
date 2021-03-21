package com.danieljrodrigues.github.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danieljrodrigues.github.data.Repository
import com.danieljrodrigues.github.models.Event
import com.danieljrodrigues.github.utils.NetworkResult
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class MainViewModel(
    private val repository: Repository,
) : ViewModel() {

    var eventsResponse: MutableLiveData<NetworkResult<Event>> = MutableLiveData()

    fun getEvents() = viewModelScope.launch {
        getEventsSafeCall("danielj06")
    }

    private suspend fun getEventsSafeCall(username: String) {
        eventsResponse.value = NetworkResult.Loading()
        try {
            val response = repository.getEvents(username)
            eventsResponse.value = handleEventsResponse(response)

            val event = eventsResponse.value!!.data
        } catch (e: Exception) {
            eventsResponse.value = NetworkResult.Error("Events not found.")
        }
    }

    private fun handleEventsResponse(response: Response<Event>): NetworkResult<Event>? {
        when {
            response.message().toString().contains("timeout") -> {
                return NetworkResult.Error("Timeout")
            }
            response.body()!!.toString().isNullOrEmpty() -> {
                return NetworkResult.Error("Events not found")
            }
            response.isSuccessful -> {
                val events = response.body()
                return NetworkResult.Success(events!!)
            }
            else -> {
                return NetworkResult.Error(response.message())
            }
        }

    }

}