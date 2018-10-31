package com.dafian.android.submissionfootballclub.ui.league

import android.os.Bundle
import com.dafian.android.submissionfootballclub.base.BaseActivity
import org.jetbrains.anko.setContentView

class LeagueActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LeagueUI().setContentView(this)
    }
}