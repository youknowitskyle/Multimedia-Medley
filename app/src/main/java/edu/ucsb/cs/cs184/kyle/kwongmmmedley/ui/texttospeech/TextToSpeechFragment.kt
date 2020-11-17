package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.texttospeech

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.ucsb.cs.cs184.kyle.kwongmmmedley.R
import java.util.*

class TextToSpeechFragment : Fragment() {

    lateinit var textToSpeech: TextToSpeech

    companion object {
        fun newInstance() = TextToSpeechFragment()
    }

    private lateinit var viewModel: TextToSpeechViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_text_to_speech, container, false)
        viewModel = ViewModelProvider(this).get(TextToSpeechViewModel::class.java)
        val textView: TextView = view.findViewById(R.id.textToSpeechView)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel


        val textView: TextView = requireActivity().findViewById(R.id.textToSpeechView)
        textView.text = viewModel.getText()
        textView.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setText(textView.text.toString())
            }
        })

         textToSpeech = TextToSpeech(context) { status ->
             if (status != TextToSpeech.ERROR)
                 textToSpeech.language = Locale.ENGLISH
         }

        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        fab.setImageDrawable(resources.getDrawable(R.drawable.ic_hearing_24px))
        fab.isVisible = true
        fab.setOnClickListener {
            textToSpeech.speak(viewModel.getText(), TextToSpeech.QUEUE_FLUSH, null)
        }
    }

    override fun onResume() {
        super.onResume()
        val textView: TextView = requireActivity().findViewById(R.id.textToSpeechView)
        textView.text = viewModel.getText()
    }

}