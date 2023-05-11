package com.example.kotlinkontrol

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RandomViewModel : ViewModel() {
    private val _state = MutableStateFlow(RandomState(0))
    val state = _state.asStateFlow()

    fun genRandom() {
        _state.update { RandomState((1..100).random()) }

    }
}

data class RandomState(val num: Int) {

}