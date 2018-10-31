package com.dafian.android.submissionfootballclub.util

import android.support.v4.widget.SwipeRefreshLayout
import android.widget.ImageView
import com.dafian.android.submissionfootballclub.GlideApp
import io.reactivex.disposables.CompositeDisposable

fun ImageView.loadUrl(url: String) {
    GlideApp.with(context)
        .load(url)
        .into(this)
}

fun SwipeRefreshLayout.start() {
    this.isRefreshing = true
}

fun SwipeRefreshLayout.stop() {
    this.isRefreshing = false
}

fun CompositeDisposable?.safeDispose() {
    this?.clear()
}