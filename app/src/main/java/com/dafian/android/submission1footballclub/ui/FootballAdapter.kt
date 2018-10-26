package com.dafian.android.submission1footballclub.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dafian.android.submission1footballclub.GlideApp
import com.dafian.android.submission1footballclub.data.FootballClub
import org.jetbrains.anko.AnkoContext

class FootballAdapter(
    private val context: Context, private val list: List<FootballClub>,
    private val listener: (FootballClub) -> Unit
) : RecyclerView.Adapter<FootballAdapter.FootballHolder>() {

    class FootballHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var ivLogo: ImageView = itemView.findViewById(FootballUI.idLogo)
        private var tvName: TextView = itemView.findViewById(FootballUI.idName)

        fun bindItem(item: FootballClub, listener: (FootballClub) -> Unit) {
            tvName.text = item.name
            item.image?.let { GlideApp.with(itemView.context).load(it).into(ivLogo) }
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballHolder {
        return FootballHolder(FootballUI().createView(AnkoContext.create(context, parent)))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FootballHolder, position: Int) {
        holder.bindItem(list[position], listener)
    }
}