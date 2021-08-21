package com.mdemel.sendemoapp.ui.scheduele

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdemel.sendemoapp.data.Ticket
import com.mdemel.sendemoapp.repository.TicketRepository

class TicketsViewModel : ViewModel() {

    private val _tickets = MutableLiveData<List<Ticket>>().apply {
        value = null
    }
    val text: LiveData<List<Ticket>> = _tickets

    private val repository = TicketRepository()

    fun getData(context: Context): List<Ticket>
    {
        return repository.getTickets(context)
    }

    init {
        _tickets = getData()
    }
}