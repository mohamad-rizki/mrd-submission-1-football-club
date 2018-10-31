package com.dafian.android.submissionfootballclub.ui.schedule

import android.os.Bundle
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.adapter.ScheduleTabAdapter
import com.dafian.android.submissionfootballclub.base.BaseActivity
import com.dafian.android.submissionfootballclub.data.entity.League
import kotlinx.android.synthetic.main.activity_schedule_tab.*

class ScheduleTabActivity : BaseActivity() {

    private lateinit var league: League

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_tab)

        league = intent.getParcelableExtra("league")

        setupViewPager()
    }

    private fun setupViewPager() {
        val scheduleTabAdapter = ScheduleTabAdapter(supportFragmentManager)
        scheduleTabAdapter.addFragment(ScheduleFragment().newInstance("PAST"), "PAST")
        scheduleTabAdapter.addFragment(ScheduleFragment().newInstance("NEXT"), "NEXT")
        pager_schedule.adapter = scheduleTabAdapter
        tabs.setupWithViewPager(pager_schedule)
    }
}