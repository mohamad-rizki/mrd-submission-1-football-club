package com.dafian.android.submissionfootballclub.ui.schedule.detail

import com.dafian.android.submissionfootballclub.base.BaseView
import com.dafian.android.submissionfootballclub.data.entity.Event
import com.dafian.android.submissionfootballclub.data.entity.Team
import com.dafian.android.submissionfootballclub.util.TeamType

interface DetailScheduleView : BaseView {

    fun showDetailSchedule(event: Event)

    fun showDetailTeam(team: Team, teamType: TeamType)
}