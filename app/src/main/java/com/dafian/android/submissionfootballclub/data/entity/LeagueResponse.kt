package com.dafian.android.submissionfootballclub.data.entity

import com.google.gson.annotations.SerializedName

data class LeagueResponse(@SerializedName("leagues") val leagueList: List<League>)