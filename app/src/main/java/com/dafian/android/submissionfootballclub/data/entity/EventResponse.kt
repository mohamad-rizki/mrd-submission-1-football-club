package com.dafian.android.submissionfootballclub.data.entity

import com.google.gson.annotations.SerializedName

data class EventResponse(@SerializedName("events") val eventList: List<Event>)