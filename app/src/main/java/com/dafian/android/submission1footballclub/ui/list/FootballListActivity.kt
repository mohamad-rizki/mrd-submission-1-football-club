package com.dafian.android.submission1footballclub.ui.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.dafian.android.submission1footballclub.R
import com.dafian.android.submission1footballclub.data.FootballClub
import com.dafian.android.submission1footballclub.ui.FootballAdapter
import com.dafian.android.submission1footballclub.ui.detail.FootballDetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class FootballListActivity : AppCompatActivity() {

    private var items: MutableList<FootballClub> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FootballListUI().setContentView(this)

        initData()

        val rvFootball = findViewById<RecyclerView>(FootballListUI.idFootball)

        rvFootball.adapter = FootballAdapter(this, items) {
            Log.d("Items ", it.name)
            startActivity<FootballDetailActivity>("club" to it)
        }
    }

    class FootballListUI : AnkoComponent<FootballListActivity> {

        companion object {
            const val idFootball = 3
        }

        override fun createView(ui: AnkoContext<FootballListActivity>) = with(ui) {
            verticalLayout {
                lparams(width = matchParent, height = matchParent)

                recyclerView {
                    id = idFootball
                    lparams(width = matchParent, height = matchParent)
                    layoutManager = LinearLayoutManager(context)
                    itemAnimator = DefaultItemAnimator()
                }
            }
        }
    }

    private fun initData() {

        val name = resources.getStringArray(R.array.club_name)
        val note = resources.getStringArray(R.array.club_note)
        val image = resources.obtainTypedArray(R.array.club_image)

        items.clear()

        for (i in name.indices) {
            items.add(FootballClub(name[i], note[i], image.getResourceId(i, 0)))
        }

        image.recycle()
    }
}
