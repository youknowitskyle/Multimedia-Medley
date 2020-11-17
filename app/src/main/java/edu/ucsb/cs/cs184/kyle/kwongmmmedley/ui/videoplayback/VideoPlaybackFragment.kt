package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.videoplayback

import android.content.res.Configuration
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TableRow
import android.widget.VideoView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.ucsb.cs.cs184.kyle.kwongmmmedley.R

class VideoPlaybackFragment : Fragment() {

    companion object {
        fun newInstance() = VideoPlaybackFragment()
    }

    private lateinit var viewModel: VideoPlaybackViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_video_playback, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideoPlaybackViewModel::class.java)
        // TODO: Use the ViewModel

        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        fab.isInvisible = true

        val videoContainer = requireActivity().findViewById<VideoView>(R.id.videoView)

        val mediaControls = MediaController(context)
        mediaControls.setAnchorView(videoContainer)

        videoContainer.setMediaController(mediaControls)
        videoContainer.setVideoURI(Uri.parse("android.resource://" + (activity?.packageName
            ?: "") + "/" + R.raw.bigbuck))
        videoContainer.start()

        if (activity?.resources?.configuration?.orientation ?: true == Configuration.ORIENTATION_LANDSCAPE){
            videoContainer.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            videoContainer.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
        } else if (activity?.resources?.configuration?.orientation ?: true == Configuration.ORIENTATION_PORTRAIT){
            videoContainer.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            videoContainer.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        val videoContainer = requireActivity().findViewById<VideoView>(R.id.videoView)

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            videoContainer.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            videoContainer.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            videoContainer.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            videoContainer.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
        }
    }

}