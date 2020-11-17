package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.fireworks

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.ucsb.cs.cs184.kyle.kwongmmmedley.R
import kotlin.properties.Delegates

/**
 * TODO: document your custom view class.
 */
class FireworksView : View {

    private lateinit var fireworksViewModel: FireworksViewModel
    var paint: Paint = Paint()
    var touchX by Delegates.notNull<Float>()
    var touchY by Delegates.notNull<Float>()
    var draw = false
    var x1 by Delegates.notNull<Float>()
    var y1 by Delegates.notNull<Float>()
    var x2 by Delegates.notNull<Float>()
    var y2 by Delegates.notNull<Float>()
    var x3 by Delegates.notNull<Float>()
    var y3 by Delegates.notNull<Float>()
    var x4 by Delegates.notNull<Float>()
    var y4 by Delegates.notNull<Float>()
    var x5 by Delegates.notNull<Float>()
    var y5 by Delegates.notNull<Float>()
    var x6 by Delegates.notNull<Float>()
    var y6 by Delegates.notNull<Float>()
    var x7 by Delegates.notNull<Float>()
    var y7 by Delegates.notNull<Float>()
    var x8 by Delegates.notNull<Float>()
    var y8 by Delegates.notNull<Float>()
    var x9 by Delegates.notNull<Float>()
    var y9 by Delegates.notNull<Float>()
    var x10 by Delegates.notNull<Float>()
    var y10 by Delegates.notNull<Float>()

    constructor(context: Context) : super(context) {
        init(context,null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context, attrs, defStyle)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {

        paint.color = Color.RED

        fireworksViewModel =
            ViewModelProvider(context as FragmentActivity).get(FireworksViewModel::class.java)

        fireworksViewModel.x1.observe(context, {
            x1 = it
        })
        fireworksViewModel.y1.observe(context, {
            y1 = it
        })
        fireworksViewModel.x2.observe(context, {
            x2 = it
        })
        fireworksViewModel.y2.observe(context, {
            y2 = it
        })
        fireworksViewModel.x3.observe(context, {
            x3 = it
        })
        fireworksViewModel.y3.observe(context, {
            y3 = it
        })
        fireworksViewModel.x4.observe(context, {
            x4 = it
        })
        fireworksViewModel.y4.observe(context, {
            y4 = it
        })
        fireworksViewModel.x5.observe(context, {
            x5 = it
        })
        fireworksViewModel.y5.observe(context, {
            y5 = it
        })
        fireworksViewModel.x6.observe(context, {
            x6 = it
        })
        fireworksViewModel.y6.observe(context, {
            y6 = it
        })
        fireworksViewModel.x7.observe(context, {
            x7 = it
        })
        fireworksViewModel.y7.observe(context, {
            y7 = it
        })
        fireworksViewModel.x8.observe(context, {
            x8 = it
        })
        fireworksViewModel.y8.observe(context, {
            y8 = it
        })
        fireworksViewModel.x9.observe(context, {
            x9 = it
        })
        fireworksViewModel.y9.observe(context, {
            y9 = it
        })
        fireworksViewModel.x10.observe(context, {
            x10 = it
        })
        fireworksViewModel.y10.observe(context, {
            y10 = it
        })

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN){
            fireworksViewModel._x1.value = event.x
            fireworksViewModel._y1.value = event.y
            fireworksViewModel._x2.value = event.x
            fireworksViewModel._y2.value = event.y
            fireworksViewModel._x3.value = event.x
            fireworksViewModel._y3.value = event.y
            fireworksViewModel._x4.value = event.x
            fireworksViewModel._y4.value = event.y
            fireworksViewModel._x5.value = event.x
            fireworksViewModel._y5.value = event.y
            fireworksViewModel._x6.value = event.x
            fireworksViewModel._y6.value = event.y
            fireworksViewModel._x7.value = event.x
            fireworksViewModel._y7.value = event.y
            fireworksViewModel._x8.value = event.x
            fireworksViewModel._y8.value = event.y
            fireworksViewModel._x9.value = event.x
            fireworksViewModel._y9.value = event.y
            fireworksViewModel._x10.value = event.x
            fireworksViewModel._y10.value = event.y

            draw = true

            fireworksViewModel.moveParticle(::invalidate)
        }

        invalidate()
        return super.onTouchEvent(event)


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (draw) {
            canvas.drawCircle(x1, y1, 15f, paint)
            canvas.drawCircle(x2, y2, 15f, paint)
            canvas.drawCircle(x3, y3, 15f, paint)
            canvas.drawCircle(x4, y4, 15f, paint)
            canvas.drawCircle(x5, y5, 15f, paint)
            canvas.drawCircle(x6, y6, 15f, paint)
            canvas.drawCircle(x7, y7, 15f, paint)
            canvas.drawCircle(x8, y8, 15f, paint)
            canvas.drawCircle(x9, y9, 15f, paint)
            canvas.drawCircle(x10, y10, 15f, paint)
        }
    }
}