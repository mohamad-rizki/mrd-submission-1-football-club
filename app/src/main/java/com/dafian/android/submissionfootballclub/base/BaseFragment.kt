package com.dafian.android.submissionfootballclub.base

import android.support.v4.app.Fragment
import com.dafian.android.submissionfootballclub.data.DataManager
import com.dafian.android.submissionfootballclub.data.api.SportService
import com.dafian.android.submissionfootballclub.data.api.SportServiceFactory

abstract class BaseFragment : Fragment() {

    val service: SportService
        get() = SportServiceFactory().create(context!!)

    val manager: DataManager
        get() = DataManager(service)
}