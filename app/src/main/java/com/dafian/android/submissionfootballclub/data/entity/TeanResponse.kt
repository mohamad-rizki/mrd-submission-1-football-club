package com.dafian.android.submissionfootballclub.data.entity

import com.google.gson.annotations.SerializedName

data class TeanResponse(@SerializedName("teams") val teamList: List<Team>)