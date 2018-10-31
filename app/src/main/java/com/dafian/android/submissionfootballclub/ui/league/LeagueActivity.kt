package com.dafian.android.submissionfootballclub.ui.league

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import com.dafian.android.submissionfootballclub.adapter.LeagueAdapter
import com.dafian.android.submissionfootballclub.base.BaseActivity
import com.dafian.android.submissionfootballclub.data.entity.League
import com.dafian.android.submissionfootballclub.ui.schedule.ScheduleTabActivity
import com.dafian.android.submissionfootballclub.util.start
import com.dafian.android.submissionfootballclub.util.stop
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity
import timber.log.Timber

class LeagueActivity : BaseActivity(), LeagueView {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView

    private lateinit var presenter: LeaguePresenter

    private val leagueList = mutableListOf<League>()
    private val adapter = LeagueAdapter(this, leagueList) {
        startActivity<ScheduleTabActivity>("league" to it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LeagueUI().setContentView(this)

        swipeRefreshLayout = findViewById(LeagueUI.idSwipeRefreshLayout)
        recyclerView = findViewById(LeagueUI.idRecyclerView)

        presenter = LeaguePresenter(this, manager)

        initEvent()
        loadingData()
    }

    override fun showLeagueAll(leagueList: List<League>) {

        Timber.d("List League Size ${leagueList.size}")

        this.leagueList.addAll(leagueList)
        adapter.notifyDataSetChanged()

        swipeRefreshLayout.stop()
    }

    override fun showLeagueEmpty() {

        Timber.d("List League Empty")

        swipeRefreshLayout.stop()
    }

    override fun showError(throwable: Throwable) {

        Timber.d("List League Error ${throwable.localizedMessage}")

        swipeRefreshLayout.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun initEvent() {

        swipeRefreshLayout.setOnRefreshListener {
            leagueList.clear()
            loadingData()
        }
    }

    private fun loadingData() {

        swipeRefreshLayout.start()
        presenter.getDataLeagueAll()
    }
}