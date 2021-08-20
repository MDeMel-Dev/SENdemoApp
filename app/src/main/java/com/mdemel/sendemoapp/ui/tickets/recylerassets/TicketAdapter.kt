package com.mdemel.sendemoapp.ui.tickets.recylerassets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mdemel.sendemoapp.R

class TicketAdapter: RecyclerView.Adapter<TicketViewHolder>()  {



    var data =  ArrayList<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }



    override fun getItemCount(): Int {

            return data.size

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)


            return TicketViewHolder(
                layoutInflater.inflate(R.layout.ticket_view, parent, false)
            )



    }


    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {


            (holder as TicketViewHolder).bind(data[position])

    }



}