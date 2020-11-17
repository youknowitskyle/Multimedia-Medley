package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.speechtotext

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.speech.RecognizerIntent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.ucsb.cs.cs184.kyle.kwongmmmedley.R
import java.util.*
import kotlin.collections.ArrayList

class SpeechToTextFragment : Fragment() {

    companion object {
        fun newInstance() = SpeechToTextFragment()
    }

    private lateinit var viewModel: SpeechToTextViewModel
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speech_to_text, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpeechToTextViewModel::class.java)
        // TODO: Use the ViewModel

        textView = requireActivity().findViewById(R.id.speechToTextView)

        viewModel.text.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            textView.text = it
        })

        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        fab.setImageDrawable(resources.getDrawable(R.drawable.ic_mic_none_24px))
        fab.isVisible = true
        fab.setOnClickListener {
            speechToText()
        }
    }

    private fun speechToText(){
        val intent: Intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now")

        try {
            startActivityForResult(intent, 100)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Your device is not supported", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            100 -> {
                if (resultCode == RESULT_OK && null != data){
                    var result: ArrayList<String> = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
                    viewModel.setText(result[0])
                }
            }
        }
    }

}