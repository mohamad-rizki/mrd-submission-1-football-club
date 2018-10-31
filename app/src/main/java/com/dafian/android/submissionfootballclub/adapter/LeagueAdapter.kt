package com.dafian.android.submissionfootballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.data.entity.League
import kotlinx.android.synthetic.main.row_league.view.*

class LeagueAdapter(
    private val leagueList: List<League>, private val listener : (League) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.LeagueHolder>() {

    class LeagueHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(league: League, listener: (League) -> Unit) {
            itemView.tv_league_name.text = league.strLeague
            itemView.tv_league_sport.text = league.strSport
            itemView.setOnClickListener {
                listener(league)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueHolder =
        LeagueHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_league, parent, false))

    override fun getItemCount(): Int = leagueList.size

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.bindItem(leagueList[position], listener)
    }
}