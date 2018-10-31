package com.dafian.android.submissionfootballclub.util

import android.widget.ImageView
import com.dafian.android.submissionfootballclub.GlideApp
import io.reactivex.disposables.CompositeDisposable

fun ImageView.loadUrl(url: String) {
    GlideApp.with(context)
        .load(url)
        .into(this)
}

fun CompositeDisposable?.safeDispose() {
    this?.clear()
}