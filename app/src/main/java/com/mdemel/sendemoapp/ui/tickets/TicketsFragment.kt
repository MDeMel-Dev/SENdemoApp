package com.mdemel.sendemoapp.ui.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.mdemel.sendemoapp.data.Ticket
import com.mdemel.sendemoapp.databinding.FragmentTicketsBinding
import com.mdemel.sendemoapp.ui.scheduele.TicketsViewModel
import com.mdemel.sendemoapp.ui.tickets.recylerassets.TicketAdapter
import com.mdemel.sendemoapp.util.Util
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class TicketsFragment : Fragment() {

    private val ticketsViewModel: TicketsViewModel by viewModel()
    private val util = Util()
    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding!!

    private val setZoomListener: (View) -> Unit = { item ->
        util.setZoomListener(item)
    }
    private val adapter = TicketAdapter(setZoomListener)




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.ticketRecycler.adapter = adapter

        ticketsViewModel.tickets.observe(viewLifecycleOwner, Observer {
            adapter.data = it as ArrayList<Ticket>
            binding.ticketRecycler.adapter = adapter
        })

        binding.button.setOnClickListener(){
           util.animate(binding.button.drawable)
            lifecycleScope.launch {
                delay(1100L)
                ticketsViewModel.refreshData()
            }

        }
        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



