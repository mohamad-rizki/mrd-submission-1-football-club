package com.dafian.android.submissionfootballclub.ui.schedule.detail

import com.dafian.android.submissionfootballclub.base.BasePresenter
import com.dafian.android.submissionfootballclub.data.DataManager
import com.dafian.android.submissionfootballclub.util.safeDispose
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailSchedulePresenter(
    private val view: DetailScheduleView, private val manager: DataManager,
    private val androidScheduler: Scheduler = AndroidSchedulers.mainThread(),
    private val processScheduler: Scheduler = Schedulers.io()
) : BasePresenter {

    private val disposable = CompositeDisposable()

    fun getDetailSchedule(eventId: String) {
        disposable.add(manager.lookUpMatchByEvent(eventId)
            .observeOn(androidScheduler)
            .subscribeOn(processScheduler)
            .subscribe({
                view.showDetailSchedule(it)
            }, {
                view.showError(it)
            }))
    }

    override fun onDestroy() {
        disposable.safeDispose()
    }
}