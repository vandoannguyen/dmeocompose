package com.example.democompose.ui.splash_screen

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import com.example.democompose.utils.EventLiveData
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject() constructor() : ViewModel() {
    fun clickToMain() {
        goStartScreenEvent.postValue(null)
    }

    private val goStartScreenEvent = EventLiveData<Void?>()

    init {
        Handler(Looper.getMainLooper()).postDelayed({
            goStartScreenEvent.postValue(null)
        }, 2000)
    }

    fun getGoStartScreenEvent(): EventLiveData<Void?> {
        return goStartScreenEvent
    }
}
