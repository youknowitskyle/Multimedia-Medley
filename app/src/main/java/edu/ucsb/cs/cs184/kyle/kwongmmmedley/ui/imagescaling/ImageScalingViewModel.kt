package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.imagescaling

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.fireworks.AnimationThread

class ImageScalingViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var _scale = MutableLiveData<Float>().apply {
        value = 1f
    }

    fun setScale(s: Float){
        _scale.value = s
    }

    val scale: LiveData<Float> = _scale
}