package com.dafian.android.submissionfootballclub.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.submissionfootballclub.base.BaseFragment
import org.jetbrains.anko.AnkoContext

class ScheduleFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ScheduleUI().createView(AnkoContext.create(context!!, this, false))
    }
}