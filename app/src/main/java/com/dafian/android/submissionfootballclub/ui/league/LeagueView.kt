package com.dafian.android.submissionfootballclub.ui.league

import com.dafian.android.submissionfootballclub.base.BaseView
import com.dafian.android.submissionfootballclub.data.entity.League

interface LeagueView : BaseView {

    fun showLeagueAll(leagueList: List<League>)

    fun showLeagueEmpty()
}