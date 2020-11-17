package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.speechtotext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpeechToTextViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    fun setText(s: String) {
        _text.value = s
    }

    fun getText(): String? {
        return _text.value
    }
}