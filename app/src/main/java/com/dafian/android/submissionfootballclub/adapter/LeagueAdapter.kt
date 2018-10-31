package com.dafian.android.submissionfootballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.data.entity.League

class LeagueAdapter(
    private val context: Context, private val leagueList: List<League>, private val listener : (League) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.LeagueHolder>() {

    class LeagueHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(league: League, listener: (League) -> Unit) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueHolder =
        LeagueHolder(LayoutInflater.from(context).inflate(R.layout.row_league, parent, false))

    override fun getItemCount(): Int = leagueList.size

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {

    }
}