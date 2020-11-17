package edu.ucsb.cs.cs184.kyle.kwongmmmedley.ui.fireworks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.ucsb.cs.cs184.kyle.kwongmmmedley.R

class FireworksFragment : Fragment() {

    private lateinit var fireworksViewModel: FireworksViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        fireworksViewModel =
                ViewModelProvider(this).get(FireworksViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_fireworks, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        fab.isInvisible = true
    }
}