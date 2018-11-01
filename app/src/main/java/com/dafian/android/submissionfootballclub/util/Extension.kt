package com.dafian.android.submissionfootballclub.util

import android.support.v4.widget.SwipeRefreshLayout
import android.widget.ImageView
import android.widget.TextView
import com.dafian.android.submissionfootballclub.GlideApp
import io.reactivex.disposables.CompositeDisposable
import java.text.SimpleDateFormat
import java.util.*

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

fun TextView.formatDate(string: String) {
    val formatServer = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formatLocal = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val date = formatServer.parse(string)
    this.text = formatLocal.format(date)
}