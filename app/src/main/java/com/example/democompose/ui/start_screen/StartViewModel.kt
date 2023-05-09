package com.example.democompose.ui.start_screen

import androidx.lifecycle.ViewModel
import com.example.democompose.utils.EventLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor() : ViewModel() {
    internal val navigateToHomeEvent = EventLiveData<Void?>()
        get() = field

    fun clickSubScribe() {
        navigateToHomeEvent.postValue(null)
    }

}