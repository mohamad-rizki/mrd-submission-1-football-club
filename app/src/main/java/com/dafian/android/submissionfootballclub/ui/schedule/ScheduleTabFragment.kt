package com.dafian.android.submissionfootballclub.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.adapter.ScheduleTabAdapter
import com.dafian.android.submissionfootballclub.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_schedule_tab.*

class ScheduleTabFragment : BaseFragment() {

    private lateinit var leagueId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leagueId = arguments?.getString("league_id") ?: "1445"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val scheduleTabAdapter = ScheduleTabAdapter(childFragmentManager)
        scheduleTabAdapter.addFragment(ScheduleFragment().newInstance("PAST", leagueId), "PAST")
        scheduleTabAdapter.addFragment(ScheduleFragment().newInstance("NEXT", leagueId), "NEXT")
        pager_schedule.adapter = scheduleTabAdapter
        tabs.setupWithViewPager(pager_schedule)
    }
}