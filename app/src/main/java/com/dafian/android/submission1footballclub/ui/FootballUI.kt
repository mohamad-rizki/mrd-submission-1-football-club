package com.dafian.android.submission1footballclub.ui

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class FootballUI : AnkoComponent<ViewGroup> {

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
                layoutParams = LinearLayout.LayoutParams(dip(50), dip(50))
            }

            textView {
                id = idName
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
            }
        }
    }
}