package com.mdemel.sendemoapp.data

import org.json.JSONObject

class DeriveJson(json: String?) : JSONObject(json) {
//    val type: String? = this.optString("type")
    val data = this.optJSONArray("memberships")
        .let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
        .map { Ticket(it.toString()) } // transforms each JSONObject of the array into Foo
}

class Ticket(json: String) : JSONObject(json) {
    val firstname get() = this.optString("firstName")
    val lastname get() = this.optString("lastName")
    val membership: String? get() = this.optString("membership")
    val season get() = this.optString("season")
    val section: String? get() = this.optString("section")
    val row get() = this.optString("row")
    val seat: String? get() = this.optString("seat")
}