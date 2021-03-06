package com.dafian.android.submissionfootballclub.adapter

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.data.entity.Event
import com.dafian.android.submissionfootballclub.util.formatDate
import kotlinx.android.synthetic.main.row_event.view.*

class EventAdapter(
    private val eventList: List<Event>
) : RecyclerView.Adapter<EventAdapter.EventHolder>() {

    class EventHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(event: Event) {
            itemView.tv_event_date.formatDate(event.dateEvent)
            itemView.tv_event_home_score.text = event.intHomeScore
            itemView.tv_event_home_name.text = event.strHomeTeam
            itemView.tv_event_away_score.text = event.intAwayScore
            itemView.tv_event_away_name.text = event.strAwayTeam
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("event_id", event.idEvent)
                it.findNavController().navigate(R.id.detailScheduleFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder =
        EventHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_event, parent, false))

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bindItem(eventList[position])
    }
}