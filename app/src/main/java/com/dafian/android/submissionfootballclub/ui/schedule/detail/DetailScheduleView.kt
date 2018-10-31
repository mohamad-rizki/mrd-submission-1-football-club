package com.dafian.android.submissionfootballclub.ui.schedule.detail

import com.dafian.android.submissionfootballclub.base.BaseView
import com.dafian.android.submissionfootballclub.data.entity.Event

interface DetailScheduleView : BaseView {

    fun showDetailSchedule(event: Event)
}