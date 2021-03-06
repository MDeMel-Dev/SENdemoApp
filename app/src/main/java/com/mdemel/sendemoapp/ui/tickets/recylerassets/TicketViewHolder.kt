package com.mdemel.sendemoapp.ui.tickets.recylerassets

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mdemel.sendemoapp.R
import com.mdemel.sendemoapp.data.Ticket
import com.mdemel.sendemoapp.util.Util

class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var lastPosition = -1
    private val util = Util()

    var name: TextView = itemView.findViewById(R.id.tk_name)
    var membership: TextView = itemView.findViewById(R.id.tk_membership)
    var season: TextView = itemView.findViewById(R.id.tk_season)
    var sec: TextView = itemView.findViewById(R.id.tk_sec)
    var row: TextView = itemView.findViewById(R.id.tk_row)
    var seat: TextView = itemView.findViewById(R.id.tk_seat)
    var qrimage: ImageView = itemView.findViewById(R.id.imageView)


    fun bind(ticket: Ticket, zoomClickListener: (View) -> Unit) {

        name.text = (ticket.firstname + " " + ticket.lastname)
        membership.text = ticket.membership
        season.text = ticket.season
        sec.text = ticket.section
        row.text = ticket.row
        seat.text = ticket.seat

        // NEW ITEM ENTRANCE ANIMATION
        setAnimation(itemView, position);

        // SET THE ZOOM FUNCTION LISTNER
        qrimage.setOnClickListener { zoomClickListener(itemView) }
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            val animation: Animation = AnimationUtils.loadAnimation(viewToAnimate.context,android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

}