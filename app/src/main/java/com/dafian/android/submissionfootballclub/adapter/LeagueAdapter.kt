package com.dafian.android.submissionfootballclub.adapter

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.data.entity.League
import kotlinx.android.synthetic.main.row_league.view.*

class LeagueAdapter(
    private val leagueList: List<League>
) : RecyclerView.Adapter<LeagueAdapter.LeagueHolder>() {

    class LeagueHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(league: League) {
            itemView.tv_league_name.text = league.strLeague
            itemView.tv_league_sport.text = league.strSport
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("league_id", league.idLeague)
                it.findNavController().navigate(R.id.scheduleTabFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueHolder =
        LeagueHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_league, parent, false))

    override fun getItemCount(): Int = leagueList.size

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.bindItem(leagueList[position])
    }
}