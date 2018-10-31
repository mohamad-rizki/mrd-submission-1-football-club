package com.dafian.android.submissionfootballclub.ui

import android.os.Bundle
import android.os.Handler
import com.dafian.android.submissionfootballclub.base.BaseActivity
import com.dafian.android.submissionfootballclub.ui.league.LeagueActivity
import org.jetbrains.anko.startActivity

class StartUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = Handler()
        handler.postDelayed({
            startActivity<LeagueActivity>()
        }, 1500)
    }
}