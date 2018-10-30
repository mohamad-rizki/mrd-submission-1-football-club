package com.dafian.android.submissionfootballclub.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.dafian.android.submissionfootballclub.GlideApp
import com.dafian.android.submissionfootballclub.data.FootballClub
import org.jetbrains.anko.*

class FootballDetailActivity : AppCompatActivity() {

    private lateinit var ivLogo: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvNote: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            lparams(width = matchParent, height = matchParent)
            padding = dip(16)

            ivLogo = imageView {}.lparams(dip(80), dip(80)) {
                gravity = Gravity.CENTER
            }

            tvName = textView {
                gravity = Gravity.CENTER
                textSize = sp(10).toFloat()
            }.lparams(matchParent, wrapContent) {
                topMargin = dip(8)
                bottomMargin = dip(8)
            }

            tvNote = textView {
                gravity = Gravity.CENTER
            }
        }

        val intent = intent
        val item = intent.getParcelableExtra<FootballClub>("club")

        tvName.text = item.name
        tvNote.text = item.description
        item.image?.let { GlideApp.with(this).load(it).into(ivLogo) }
    }
}