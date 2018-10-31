package com.dafian.android.submissionfootballclub.ui.schedule

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.adapter.EventAdapter
import com.dafian.android.submissionfootballclub.base.BaseFragment
import com.dafian.android.submissionfootballclub.data.entity.Event
import com.dafian.android.submissionfootballclub.ui.schedule.detail.DetailScheduleActivity
import com.dafian.android.submissionfootballclub.util.ScheduleType
import com.dafian.android.submissionfootballclub.util.start
import com.dafian.android.submissionfootballclub.util.stop
import org.jetbrains.anko.AnkoContext
import timber.log.Timber

class ScheduleFragment : BaseFragment(), ScheduleView {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView

    private lateinit var type: String
    private lateinit var leagueId: String
    private lateinit var presenter: SchedulePresenter

    private val eventList = mutableListOf<Event>()
    private val adapter = EventAdapter(eventList) {
        startActivity(Intent(activity, DetailScheduleActivity::class.java))
    }

    fun newInstance(type: String, leagueId: String): ScheduleFragment {
        val fragment = ScheduleFragment()
        val bundle = Bundle()
        bundle.putString("type", type)
        bundle.putString("leagueId", leagueId)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = arguments?.getString("type") ?: "PAST"
        leagueId = arguments?.getString("leagueId") ?: "1445"
        presenter = SchedulePresenter(this, manager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = ScheduleUI().createView(AnkoContext.create(context!!, this, false))

        swipeRefreshLayout = view.findViewById(ScheduleUI.idSwipeRefreshLayout)
        recyclerView = view.findViewById(ScheduleUI.idRecyclerView)
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEvent()
        loadingData()
    }

    override fun showMatchScheduleAll(scheduleList: List<Event>) {

        Timber.d("List Schedule Size ${scheduleList.size}")

        this.eventList.addAll(scheduleList)
        adapter.notifyDataSetChanged()

        swipeRefreshLayout.stop()
    }

    override fun showMatchScheduleEmpty() {

        Timber.d("List Schedule Empty")

        swipeRefreshLayout.stop()
    }

    override fun showError(throwable: Throwable) {

        Timber.d("List Schedule Error ${throwable.localizedMessage}")

        swipeRefreshLayout.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun initEvent() {

        swipeRefreshLayout.setOnRefreshListener {
            eventList.clear()
            loadingData()
        }
    }

    private fun loadingData() {

        swipeRefreshLayout.start()
        presenter.getMatchSchedule(
            if (type == ScheduleType.PAST.toString()) {
                ScheduleType.PAST
            } else {
                ScheduleType.NEXT
            }
        , leagueId)
    }
}