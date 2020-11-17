package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.imagescaling

import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.ucsb.cs.cs184.kyle.kwongmmmedley.R
import kotlin.math.roundToInt
import kotlin.properties.Delegates

class ImageScalingFragment : Fragment(), View.OnTouchListener {

    var scaleGestureDetector: ScaleGestureDetector? = null
    lateinit var imageScalingView: ImageView
    var scale = 1f
    val matrix: android.graphics.Matrix = android.graphics.Matrix()
    var width by Delegates.notNull<Int>()
    var height by Delegates.notNull<Int>()

    companion object {
        fun newInstance() = ImageScalingFragment()
    }

    private lateinit var viewModel: ImageScalingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_imagescaling, container, false)
        scaleGestureDetector = ScaleGestureDetector(context, MyOnScaleGestureListener())
        view.setOnTouchListener(this)
        imageScalingView = view.findViewById(R.id.imageScalingView)

        return view
    }


    inner class MyOnScaleGestureListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val scaleFactor = detector.scaleFactor
            val myTextView = view?.findViewById<TextView>(R.id.imageScalingTextView)
            val layout = view?.findViewById<ConstraintLayout>(R.id.imageScalingConstraintLayout)
            width = layout?.width!!
            height = layout.height
            viewModel.setScale(scale * scaleFactor)

            imageScalingView.layoutParams.height = (height * scale).roundToInt()
            imageScalingView.layoutParams.width = (width * scale).roundToInt()

            if (scaleFactor > 1) {
                if (myTextView != null) {
                    myTextView.text = ""
                }
            } else {
                if (myTextView != null) {
                    myTextView.text = ""
                }
            }



            return true
        }

        override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {}
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val layout = view?.findViewById<ConstraintLayout>(R.id.imageScalingConstraintLayout)
        width = layout?.width!!
        height = layout.height

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            height += getNavigationBarHeight() + 65
//            if (scale < 1f)
//                scale += 0.15f
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            width -= getNavigationBarHeight() + 60
//            if (scale <= 1f)
//                scale -= 0.15f
        }

        imageScalingView.layoutParams.height = (width * scale).roundToInt()
        imageScalingView.layoutParams.width = (height * scale).roundToInt()

        Log.d("PRINT", "$scale")
    }

    private fun getNavigationBarHeight(): Int {
        val bar = requireActivity().findViewById<AppBarLayout>(R.id.appbarlayout)
        return bar.height
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var imageView: ImageView = requireActivity().findViewById(R.id.imageScalingView)

        Glide.with(this)
            .load("https://picsum.photos/400/600")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(imageView);

        viewModel = ViewModelProvider(this).get(ImageScalingViewModel::class.java)
        // TODO: Use the ViewModel

        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        fab.setImageDrawable(resources.getDrawable(R.drawable.ic_menu_gallery))
        fab.isVisible = true
        fab.setOnClickListener {
            loadImage()
        }

        viewModel.scale.observe(viewLifecycleOwner, Observer {
            scale = it
        })

    }

    private fun loadImage(){
        var imageView: ImageView = requireActivity().findViewById(R.id.imageScalingView)
        Glide.with(this)
                .load("https://picsum.photos/400/600")
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        scaleGestureDetector?.onTouchEvent(event)
        return true
    }

}