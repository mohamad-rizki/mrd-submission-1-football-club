package com.dafian.android.submissionfootballclub.ui

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class FootballRowUI : AnkoComponent<ViewGroup> {

    companion object {
        const val idLogo = 1
        const val idName = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            padding = dip(16)
            orientation = LinearLayout.HORIZONTAL

            imageView {
                id = idLogo
            }.lparams(dip(50), dip(50))

            textView {
                id = idName
            }.lparams {
                margin = dip(8)
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                gravity = Gravity.CENTER_VERTICAL
            }
        }
    }
}