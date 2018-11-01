package com.dafian.android.submissionfootballclub.ui.schedule.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.base.BaseFragment
import com.dafian.android.submissionfootballclub.data.entity.Event

class DetailScheduleFragment : BaseFragment(), DetailScheduleView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule_detail, container, false)
    }

    override fun showDetailSchedule(event: Event) {

    }

    override fun showError(throwable: Throwable) {

    }
}