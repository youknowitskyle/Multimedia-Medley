package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.texttospeech

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextToSpeechViewModel : ViewModel() {
    // TODO: Implement the ViewModel

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