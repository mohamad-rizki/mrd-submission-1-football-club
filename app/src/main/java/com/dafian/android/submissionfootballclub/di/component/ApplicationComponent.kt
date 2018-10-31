package com.dafian.android.submissionfootballclub.di.component

import com.dafian.android.submissionfootballclub.di.module.NetworkModule
import com.dafian.android.submissionfootballclub.di.module.PresenterModule
import com.dafian.android.submissionfootballclub.ui.StartUpActivity
import com.dafian.android.submissionfootballclub.ui.league.LeagueActivity
import com.dafian.android.submissionfootballclub.ui.schedule.ScheduleTabActivity
import com.dafian.android.submissionfootballclub.ui.schedule.detail.DetailScheduleActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, PresenterModule::class])
interface ApplicationComponent {

    fun inject(startUpActivity: StartUpActivity)

    fun inject(leagueActivity: LeagueActivity)

    fun inject(scheduleTabActivity: ScheduleTabActivity)

    fun inject(detailScheduleActivity: DetailScheduleActivity)
}