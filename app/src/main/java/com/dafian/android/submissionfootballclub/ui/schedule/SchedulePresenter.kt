package com.dafian.android.submissionfootballclub.ui.schedule

import com.dafian.android.submissionfootballclub.base.BasePresenter
import com.dafian.android.submissionfootballclub.data.DataManager
import com.dafian.android.submissionfootballclub.util.ScheduleType
import com.dafian.android.submissionfootballclub.util.safeDispose
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SchedulePresenter(
    private val view: ScheduleView, private val manager: DataManager,
    private val androidScheduler: Scheduler = AndroidSchedulers.mainThread(),
    private val processScheduler: Scheduler = Schedulers.io()
) : BasePresenter {

    private val disposable = CompositeDisposable()

    fun getMatchSchedule(type: ScheduleType, leagueId: String) {
        if (type == ScheduleType.NEXT) {
            disposable.addAll(getNextSchedule(leagueId))
        } else if (type == ScheduleType.PAST) {
            disposable.addAll(getPastSchedule(leagueId))
        }
    }

    private fun getNextSchedule(leagueId: String): Disposable {
        return manager.findNextMatchAllByLeague(leagueId)
            .observeOn(androidScheduler)
            .subscribeOn(processScheduler)
            .subscribe({
                if (it.isEmpty()) {
                    view.showMatchScheduleEmpty()
                } else {
                    view.showMatchScheduleAll(it)
                }
            }, {
                view.showError(it)
            })
    }

    private fun getPastSchedule(leagueId: String): Disposable {
        return manager.findPastMatchAllByLeague(leagueId)
            .observeOn(androidScheduler)
            .subscribeOn(processScheduler)
            .subscribe({
                if (it.isEmpty()) {
                    view.showMatchScheduleEmpty()
                } else {
                    view.showMatchScheduleAll(it)
                }
            }, {
                view.showError(it)
            })
    }

    override fun onDestroy() {
        disposable.safeDispose()
    }
}