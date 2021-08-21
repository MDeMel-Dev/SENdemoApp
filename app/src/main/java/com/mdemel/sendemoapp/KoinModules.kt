package com.mdemel.sendemoapp

import com.mdemel.sendemoapp.repository.TicketRepository
import com.mdemel.sendemoapp.ui.scheduele.TicketsViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {

    // SINGLE INSTANCE OF THE TICKET-REPOSITORY
    single<TicketRepository> { TicketRepository(get()) }

    viewModel { TicketsViewModel(get()) }
}
