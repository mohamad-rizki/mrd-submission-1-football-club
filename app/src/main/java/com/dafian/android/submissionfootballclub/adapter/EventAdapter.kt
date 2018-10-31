package com.dafian.android.submissionfootballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.data.entity.Event
import kotlinx.android.synthetic.main.row_event.view.*

class EventAdapter(
    private val eventList: List<Event>, private val listener: (Event) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventHolder>() {

    class EventHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(event: Event, listener: (Event) -> Unit) {
            itemView.tv_event_date.text = event.dateEvent
            itemView.tv_event_home_score.text = event.intHomeScore
            itemView.tv_event_home_name.text = event.strHomeTeam
            itemView.tv_event_away_score.text = event.intAwayScore
            itemView.tv_event_away_name.text = event.strAwayTeam
            itemView.setOnClickListener {
                listener(event)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder =
        EventHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_event, parent, false))

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bindItem(eventList[position], listener)
    }
}