package com.dafian.android.submissionfootballclub.ui.schedule.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.R
import com.dafian.android.submissionfootballclub.base.BaseFragment
import com.dafian.android.submissionfootballclub.data.entity.Event
import com.dafian.android.submissionfootballclub.data.entity.Team
import com.dafian.android.submissionfootballclub.util.TeamType
import com.dafian.android.submissionfootballclub.util.loadUrl
import kotlinx.android.synthetic.main.fragment_schedule_detail.*
import timber.log.Timber

class DetailScheduleFragment : BaseFragment(), DetailScheduleView {

    private lateinit var eventId: String
    private lateinit var presenter: DetailSchedulePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventId = arguments?.getString("event_id") ?: "1445"
        presenter = DetailSchedulePresenter(this, manager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingData()
    }

    override fun showDetailTeam(team: Team, teamType: TeamType) {

        if (teamType == TeamType.HOME) {
            iv_event_home_logo.loadUrl(team.strTeamBadge)
        } else if (teamType == TeamType.AWAY) {
            iv_event_away_logo.loadUrl(team.strTeamBadge)
        }
    }

    override fun showDetailSchedule(event: Event) {

        Timber.d("Detail Schedule Data $event")

        tv_event_date.text = event.dateEvent
        tv_event_home_score.text = event.intHomeScore
        tv_event_away_score.text = event.intAwayScore
        tv_event_home_name.text = event.strHomeTeam
        tv_event_away_name.text = event.strAwayTeam

        tv_event_home_goals.text = event.strHomeGoalDetails
        tv_event_away_goals.text = event.strAwayGoalDetails
        tv_event_home_shoots.text = event.intHomeShots
        tv_event_away_shoots.text = event.intAwayShots
        tv_event_home_goal_keeper.text = event.strHomeLineupGoalkeeper
        tv_event_away_goal_keeper.text = event.strAwayLineupGoalkeeper
        tv_event_home_defense.text = event.strHomeLineupDefense
        tv_event_away_defense.text = event.strAwayLineupDefense
        tv_event_home_midfield.text = event.strHomeLineupMidfield
        tv_event_away_midfield.text = event.strAwayLineupMidfield
        tv_event_home_forward.text = event.strHomeLineupForward
        tv_event_away_forward.text = event.strAwayLineupForward
        tv_event_home_substitute.text = event.strHomeLineupSubstitutes
        tv_event_away_substitute.text = event.strAwayLineupSubstitutes

        presenter.getDetailTeam(event.idHomeTeam, TeamType.HOME)
        presenter.getDetailTeam(event.idAwayTeam, TeamType.AWAY)
    }

    override fun showError(throwable: Throwable) {

        Timber.d("Detail Schedule Error ${throwable.localizedMessage}")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun loadingData() {

        presenter.getDetailSchedule(eventId)
    }
}