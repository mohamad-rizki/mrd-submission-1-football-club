package com.dafian.android.submissionfootballclub.ui.league

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.adapter.LeagueAdapter
import com.dafian.android.submissionfootballclub.base.BaseFragment
import com.dafian.android.submissionfootballclub.data.entity.League
import com.dafian.android.submissionfootballclub.util.start
import com.dafian.android.submissionfootballclub.util.stop
import org.jetbrains.anko.AnkoContext
import timber.log.Timber

class LeagueFragment : BaseFragment(), LeagueView {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView

    private lateinit var presenter: LeaguePresenter

    private val leagueList = mutableListOf<League>()
    private val adapter = LeagueAdapter(leagueList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LeaguePresenter(this, manager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LeagueUI().createView(AnkoContext.create(context!!, this, false))

        swipeRefreshLayout = view.findViewById(LeagueUI.idSwipeRefreshLayout)
        recyclerView = view.findViewById(LeagueUI.idRecyclerView)
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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