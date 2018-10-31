package com.dafian.android.submissionfootballclub.data

import com.dafian.android.submissionfootballclub.data.api.SportService
import com.dafian.android.submissionfootballclub.data.entity.Event
import com.dafian.android.submissionfootballclub.data.entity.League
import com.dafian.android.submissionfootballclub.data.entity.Team
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable

class DataManager(private val service: SportService) {

    fun findLeagueAll(): Flowable<List<League>> {
        return service.findLeagueAll()
            .flatMap {
                Observable.just(it.leagueList)
                    .toFlowable(BackpressureStrategy.LATEST)
            }
    }

    fun findPastMatchAllByLeague(leagueId: String): Flowable<List<Event>> {
        return service.findPastMatchAllByLeague(leagueId)
            .flatMap {
                Observable.just(it.eventList)
                    .toFlowable(BackpressureStrategy.LATEST)
            }
    }

    fun findNextMatchAllByLeague(leagueId: String): Flowable<List<Event>> {
        return service.findNextMatchAllByLeague(leagueId)
            .flatMap {
                Observable.just(it.eventList)
                    .toFlowable(BackpressureStrategy.LATEST)
            }
    }

    fun lookUpMatchByEvent(eventId: String): Flowable<Event> {
        return service.lookUpMatchByEvent(eventId)
            .flatMap {
                Observable.just(it.eventList)
                    .toFlowable(BackpressureStrategy.LATEST)
            }
            .flatMap {
                Observable.just(it[0])
                    .toFlowable(BackpressureStrategy.LATEST)
            }
    }

    fun searchTeamById(teamId: String): Flowable<Team> {
        return service.searchTeamById(teamId)
            .flatMap {
                Observable.just(it.teamList)
                    .toFlowable(BackpressureStrategy.LATEST)
            }
            .flatMap {
                Observable.just(it[0])
                    .toFlowable(BackpressureStrategy.LATEST)
            }
    }
}