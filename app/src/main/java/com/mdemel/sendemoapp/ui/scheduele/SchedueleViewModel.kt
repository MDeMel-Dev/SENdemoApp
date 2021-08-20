package com.mdemel.sendemoapp.ui.scheduele

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SchedueleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is scheduele Fragment"
    }
    val text: LiveData<String> = _text
}