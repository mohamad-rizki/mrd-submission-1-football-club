package com.dafian.android.submissionfootballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.data.entity.Event

class EventAdapter(
    private val context: Context, private val eventList: List<Event>, private val listener: (Event) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventHolder>() {

    class EventHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(event: Event, listener: (Event) -> Unit) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder =
        EventHolder(LayoutInflater.from(context).inflate(R.layout.row_event, parent, false))

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: EventHolder, position: Int) {

    }
}