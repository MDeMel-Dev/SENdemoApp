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

class TicketsFragment : Fragment() {

    private lateinit var ticketsViewModel: TicketsViewModel
    private var _binding: FragmentTicketsBinding? = null

    private val binding get() = _binding!!

    private lateinit var ticketRecyclerView: RecyclerView
    private val adapter = TicketAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ticketsViewModel =
            ViewModelProvider(this.requireActivity()).get(TicketsViewModel::class.java)

        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.ticketRecycler.adapter = adapter
//        adapter.data = (ticketsViewModel.getData() as? ArrayList<Ticket>)!!
//        adapter.notifyDataSetChanged()

//        val textView: TextView = binding.textNotifications
//        ticketsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        binding.button.setOnClickListener(){
            var data = ticketsViewModel.getData(this.requireActivity().applicationContext) as ArrayList<Ticket>
            Toast.makeText(this.requireContext(), "${data[0].firstname}", Toast.LENGTH_SHORT).show()
            adapter.data = data
            binding.ticketRecycler.adapter = adapter
        }
        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}