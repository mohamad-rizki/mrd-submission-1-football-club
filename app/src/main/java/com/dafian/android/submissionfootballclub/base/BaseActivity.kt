package com.dafian.android.submissionfootballclub.base

import android.support.v7.app.AppCompatActivity
import com.dafian.android.submissionfootballclub.data.DataManager
import com.dafian.android.submissionfootballclub.data.api.SportService
import com.dafian.android.submissionfootballclub.data.api.SportServiceFactory

abstract class BaseActivity : AppCompatActivity() {

    val service: SportService
        get() = SportServiceFactory().create(this)

    val manager: DataManager
        get() = DataManager(service)
}