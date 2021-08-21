package com.mdemel.sendemoapp.repository

import com.mdemel.sendemoapp.data.DeriveJson
import com.mdemel.sendemoapp.data.Ticket
import android.content.Context
import java.io.IOException

class TicketRepository(val context: Context) {

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getTickets(): List<Ticket>
    {
        //val foos = DeriveJson("{\"memberships\":[{\"id\":1,\"firstName\":\"Allie\",\"lastName\":\"Grater\",\"section\":\"SA3\",\"seat\":\"16\",\"row\":\"RT\",\"membership\":\"Adult Premium Membership\",\"season\":\"Season 20202021\"},{\"id\":2,\"firstName\":\"Olive\",\"lastName\":\"Dactyl\",\"section\":\"SGA3\",\"seat\":\"187\",\"row\":\"GA\",\"membership\":\"Member Companion\",\"season\":\"Season 20202021\"},{\"id\":3,\"firstName\":\"Maureen\",\"lastName\":\"Bugg\",\"section\":\"SG34\",\"seat\":\"89\",\"row\":\"AC\",\"membership\":\"Adult Premium Membership\",\"season\":\"Season 20202021\"}]}")
        val foos = DeriveJson(getJsonDataFromAsset(context , "memberships.json"))
        return foos.data
    }


}