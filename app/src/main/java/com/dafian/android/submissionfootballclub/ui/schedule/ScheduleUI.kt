package com.dafian.android.submissionfootballclub.ui.schedule

import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class ScheduleUI : AnkoComponent<ScheduleFragment> {

    companion object {
        const val idSwipeRefreshLayout = 1
        const val idRecyclerView = 2
    }

    override fun createView(ui: AnkoContext<ScheduleFragment>) = with(ui) {
        verticalLayout {
            lparams(matchParent, matchParent)

            swipeRefreshLayout {
                id = idSwipeRefreshLayout
                setColorSchemeColors(
                    ContextCompat.getColor(context, android.R.color.holo_red_light),
                    ContextCompat.getColor(context, android.R.color.holo_blue_light),
                    ContextCompat.getColor(context, android.R.color.holo_green_light)
                )

                recyclerView {
                    id = idRecyclerView
                    lparams(matchParent, wrapContent)
                    layoutManager = LinearLayoutManager(context)
                    itemAnimator = DefaultItemAnimator()
                    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                }

            }.lparams(matchParent, wrapContent)
        }
    }
}