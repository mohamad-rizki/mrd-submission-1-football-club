package com.dafian.android.submissionfootballclub.ui.schedule

import com.dafian.android.submissionfootballclub.base.BaseView
import com.dafian.android.submissionfootballclub.data.entity.Event

interface ScheduleView : BaseView {

    fun showMatchScheduleAll(scheduleList: List<Event>)

    fun showMatchScheduleEmpty()
}