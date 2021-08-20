package com.mdemel.sendemoapp.ui.scheduele

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mdemel.sendemoapp.databinding.FragmentSchedueleBinding

class SchedueleFragment : Fragment() {

    private lateinit var schedueleViewModel: SchedueleViewModel
    private var _binding: FragmentSchedueleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        schedueleViewModel =
            ViewModelProvider(this).get(SchedueleViewModel::class.java)

        _binding = FragmentSchedueleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        schedueleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}