package com.dafian.android.submissionfootballclub.ui.schedule

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.adapter.EventAdapter
import com.dafian.android.submissionfootballclub.base.BaseFragment
import com.dafian.android.submissionfootballclub.data.entity.Event
import com.dafian.android.submissionfootballclub.data.entity.League
import com.dafian.android.submissionfootballclub.ui.schedule.detail.DetailScheduleActivity
import com.dafian.android.submissionfootballclub.util.ScheduleType
import org.jetbrains.anko.AnkoContext
import timber.log.Timber

class ScheduleFragment : BaseFragment(), ScheduleView {

    private lateinit var type: String
    private lateinit var league: League
    private lateinit var presenter: SchedulePresenter

    private val eventList = mutableListOf<Event>()
    private val adapter = EventAdapter(context!!, eventList) {
        startActivity(Intent(activity, DetailScheduleActivity::class.java))
    }

    fun newInstance(type: String): ScheduleFragment {
        val fragment = ScheduleFragment()
        val bundle = Bundle()
        bundle.putString("type", type)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = arguments?.getString("type") ?: "PAST"
        league = arguments!!.getParcelable("league")
        presenter = SchedulePresenter(this, manager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = ScheduleUI().createView(AnkoContext.create(context!!, this, false))
        loadingData()
        return view
    }

    override fun showMatchScheduleAll(scheduleList: List<Event>) {

        Timber.d("List Schedule Size ${scheduleList.size}")

        this.eventList.addAll(scheduleList)
        adapter.notifyDataSetChanged()
    }

    override fun showMatchScheduleEmpty() {

        Timber.d("List Schedule Empty")
    }

    override fun showError(throwable: Throwable) {

        Timber.d("List Schedule Error ${throwable.localizedMessage}")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun loadingData() {

        presenter.getMatchSchedule(
            if (type == ScheduleType.PAST.toString()) {
                ScheduleType.PAST
            } else {
                ScheduleType.NEXT
            }
        , league.idLeague)
    }
}