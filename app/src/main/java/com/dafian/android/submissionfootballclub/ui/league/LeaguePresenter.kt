package com.dafian.android.submissionfootballclub.ui.league

import com.dafian.android.submissionfootballclub.base.BasePresenter
import com.dafian.android.submissionfootballclub.data.DataManager
import com.dafian.android.submissionfootballclub.util.safeDispose
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LeaguePresenter(
    private val view: LeagueView, private val manager: DataManager,
    private val androidScheduler: Scheduler = AndroidSchedulers.mainThread(),
    private val processScheduler: Scheduler = Schedulers.io()
) : BasePresenter {

    private val disposable = CompositeDisposable()

    fun getDataLeagueAll() {
        disposable.add(manager.findLeagueAll()
            .observeOn(androidScheduler)
            .subscribeOn(processScheduler)
            .subscribe({
                if (it.isEmpty()) {
                    view.showLeagueEmpty()
                } else {
                    view.showLeagueAll(it)
                }
            }, {
                view.showError(it)
            })
        )
    }

    override fun onDestroy() {
        disposable.safeDispose()
    }
}