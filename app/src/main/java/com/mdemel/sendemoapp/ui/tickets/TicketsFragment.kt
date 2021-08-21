package com.mdemel.sendemoapp.ui.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mdemel.sendemoapp.data.Ticket
import com.mdemel.sendemoapp.databinding.FragmentTicketsBinding
import com.mdemel.sendemoapp.ui.scheduele.TicketsViewModel
import com.mdemel.sendemoapp.ui.tickets.recylerassets.TicketAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TicketsFragment : Fragment() {

    private val ticketsViewModel: TicketsViewModel by viewModel()
    private var _binding: FragmentTicketsBinding? = null

    private val binding get() = _binding!!

    //private lateinit var ticketRecyclerView: RecyclerView
    private val adapter = TicketAdapter()


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
           ticketsViewModel.refreshData()
        }
        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}