package com.mdemel.sendemoapp.ui.scheduele

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdemel.sendemoapp.data.Ticket
import com.mdemel.sendemoapp.repository.TicketRepository
import org.koin.java.KoinJavaComponent.inject

class TicketsViewModel(val repo : TicketRepository) : ViewModel() {

    private val _tickets = MutableLiveData<List<Ticket>>().apply {
        value = null
    }
    val tickets: LiveData<List<Ticket>> = _tickets

    fun getData(): List<Ticket>
    {
        return repo.getTickets()
    }

    fun refreshData()
    {
        _tickets.value = getData()
    }

    init {
        _tickets.value = getData()
    }
}