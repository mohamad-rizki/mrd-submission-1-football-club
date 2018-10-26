package com.dafian.android.submission1footballclub.ui.detail

import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout

class FootballDetailActivity : AppCompatActivity() {

    class FootballDetailUI : AnkoComponent<FootballDetailActivity> {

        override fun createView(ui: AnkoContext<FootballDetailActivity>) = with(ui) {
            verticalLayout {

            }
        }
    }
}