package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.fireworks

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Double.parseDouble
import kotlin.math.absoluteValue

class FireworksViewModel : ViewModel() {

    lateinit var anim_threadX: AnimationThread
    lateinit var anim_threadY: AnimationThread
    lateinit var anim_thread: AnimationThread
    lateinit var updateArray: Array<IntArray>

    private val _text = MutableLiveData<String>().apply {
        value = "This is fireworks Fragment"
    }

    val _x1 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y1 = MutableLiveData<Float>().apply {
        value = 0f
    }
    val _x2 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y2 = MutableLiveData<Float>().apply {
        value = 0f
    }
    val _x3 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y3 = MutableLiveData<Float>().apply {
        value = 0f
    }
    val _x4 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y4 = MutableLiveData<Float>().apply {
        value = 0f
    }
    val _x5 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y5 = MutableLiveData<Float>().apply {
        value = 0f
    }
    val _x6 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y6 = MutableLiveData<Float>().apply {
        value = 0f
    }
    val _x7 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y7 = MutableLiveData<Float>().apply {
        value = 0f
    }
    val _x8 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y8 = MutableLiveData<Float>().apply {
        value = 0f
    }
    val _x9 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y9 = MutableLiveData<Float>().apply {
        value = 0f
    }
    val _x10 = MutableLiveData<Float>().apply{
        value = 0f
    }
    val _y10 = MutableLiveData<Float>().apply {
        value = 0f
    }

    fun moveParticle(callBack: () -> Unit){
        val randX = (0..9).random()
        val randY = (0..9).random()
        val randFPS = (30..120).random()

         updateArray = Array(10){ IntArray(2) }

        for (i in 0 until 10){
            updateArray[i][0] = (-10..10).random()
            updateArray[i][1] = (-10..10).random()
            if (updateArray[i][0].absoluteValue < 4){
                if ((0..1).random() % 2 == 0)
                    updateArray[i][0] == 6
                else
                    updateArray[i][0] == -6
            }
            if (updateArray[i][1].absoluteValue < 4){
                if ((0..1).random() % 2 == 0)
                    updateArray[i][1] == 6
                else
                    updateArray[i][1] == -6
            }
        }

        if (::anim_threadX.isInitialized && ::anim_threadY.isInitialized){
            anim_threadX.stop()
            anim_threadY.stop()
        }

        if (::anim_thread.isInitialized){
            anim_thread.stop()
        }

        anim_thread = AnimationThread({this.update(callBack)}, 60)

        anim_thread.start()

    }

    fun update(callBack: () -> Unit){

        _x1.value = _x1.value?.plus(updateArray[0][0])
        _y1.value = _y1.value?.plus(updateArray[0][1])
        _x2.value = _x2.value?.plus(updateArray[1][0])
        _y2.value = _y2.value?.plus(updateArray[1][1])
        _x3.value = _x3.value?.plus(updateArray[2][0])
        _y3.value = _y3.value?.plus(updateArray[2][1])
        _x4.value = _x4.value?.plus(updateArray[3][0])
        _y4.value = _y4.value?.plus(updateArray[3][1])
        _x5.value = _x5.value?.plus(updateArray[4][0])
        _y5.value = _y5.value?.plus(updateArray[4][1])
        _x6.value = _x6.value?.plus(updateArray[5][0])
        _y6.value = _y6.value?.plus(updateArray[5][1])
        _x7.value = _x7.value?.plus(updateArray[6][0])
        _y7.value = _y7.value?.plus(updateArray[6][1])
        _x8.value = _x8.value?.plus(updateArray[7][0])
        _y8.value = _y8.value?.plus(updateArray[7][1])
        _x9.value = _x9.value?.plus(updateArray[8][0])
        _y9.value = _y9.value?.plus(updateArray[8][1])
        _x10.value = _x10.value?.plus(updateArray[9][0])
        _y10.value = _y10.value?.plus(updateArray[9][1])

        callBack.invoke()
    }

    fun getText(): MutableLiveData<String> {return _text}

    val text: LiveData<String> = _text
    val x1: LiveData<Float> = _x1
    val y1: LiveData<Float> = _y1
    val x2: LiveData<Float> = _x2
    val y2: LiveData<Float> = _y2
    val x3: LiveData<Float> = _x3
    val y3: LiveData<Float> = _y3
    val x4: LiveData<Float> = _x4
    val y4: LiveData<Float> = _y4
    val x5: LiveData<Float> = _x5
    val y5: LiveData<Float> = _y5
    val x6: LiveData<Float> = _x6
    val y6: LiveData<Float> = _y6
    val x7: LiveData<Float> = _x7
    val y7: LiveData<Float> = _y7
    val x8: LiveData<Float> = _x8
    val y8: LiveData<Float> = _y8
    val x9: LiveData<Float> = _x9
    val y9: LiveData<Float> = _y9
    val x10: LiveData<Float> = _x10
    val y10: LiveData<Float> = _y10
}