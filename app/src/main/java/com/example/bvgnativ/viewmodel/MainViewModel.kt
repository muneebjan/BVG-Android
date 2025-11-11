package com.example.bvgnativ.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bvgnativ.data.model.Departure
import com.example.bvgnativ.data.model.Stop
import com.example.bvgnativ.data.repository.BvgRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = BvgRepository()

    private val _stops = MutableStateFlow<List<Stop>>(emptyList())
    val stops: StateFlow<List<Stop>> = _stops

    private val _departures = MutableStateFlow<List<Departure>>(emptyList())
    val departures: StateFlow<List<Departure>> = _departures

    fun searchStops(query: String) {
        viewModelScope.launch {
            try {
                _stops.value = repository.getLocations(query)
            } catch (e: Exception) {
                e.printStackTrace()
                _stops.value = emptyList() // prevent null crash
            }
        }
    }

    fun getDepartures(stopId: String) {
        viewModelScope.launch {
            try {
                val list = repository.getDepartures(stopId)
                _departures.value = list
                Log.i("Departures", "Fetched ${list.size} departures") // DEBUG
            } catch (e: Exception) {
                Log.e("Departures", "Error fetching departures", e)
                _departures.value = emptyList()
            }
        }
    }

}
