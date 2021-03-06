package com.mdemel.sendemoapp.ui.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mdemel.sendemoapp.databinding.FragmentPlayersBinding
import com.mdemel.sendemoapp.ui.scheduele.PlayersViewModel

class PlayersFragment : Fragment() {

    private lateinit var playersViewModel: PlayersViewModel
    private var _binding: FragmentPlayersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        playersViewModel =
            ViewModelProvider(this).get(PlayersViewModel::class.java)

        _binding = FragmentPlayersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        playersViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}