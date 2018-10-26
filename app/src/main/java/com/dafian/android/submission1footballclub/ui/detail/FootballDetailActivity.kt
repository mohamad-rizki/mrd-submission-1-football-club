package com.dafian.android.submission1footballclub.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.dafian.android.submission1footballclub.GlideApp
import com.dafian.android.submission1footballclub.data.FootballClub
import org.jetbrains.anko.imageView
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class FootballDetailActivity : AppCompatActivity() {

    private lateinit var ivLogo: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvNote: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            lparams(width = matchParent, height = matchParent)
            gravity = Gravity.CENTER_HORIZONTAL
            ivLogo = imageView()
            tvName = textView()
            tvNote = textView()
        }

        val intent = intent
        val item = intent.getParcelableExtra<FootballClub>("club")

        tvName.text = item.name
        tvNote.text = item.description
        item.image?.let { GlideApp.with(this).load(it).into(ivLogo) }
    }
}