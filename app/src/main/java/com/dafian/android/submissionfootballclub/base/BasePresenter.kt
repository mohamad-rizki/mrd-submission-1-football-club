package com.dafian.android.submissionfootballclub.base

interface BasePresenter {

    fun attachView(view : BaseView)

    fun detachView()
}