package com.dafian.android.submissionfootballclub.data.entity

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("idEvent") val idEvent: String,
    @SerializedName("strEvent") val strEvent: String,
    @SerializedName("strFilename") val strFilename: String,
    @SerializedName("strSport") val strSport: String,
    @SerializedName("idLeague") val idLeague: String,
    @SerializedName("strLeague") val strLeague: String,
    @SerializedName("strSeason") val strSeason: String,
    @SerializedName("strHomeTeam") val strHomeTeam: String,
    @SerializedName("strAwayTeam") val strAwayTeam: String,
    @SerializedName("intHomeScore") val intHomeScore: String,
    @SerializedName("intRound") val intRound: String,
    @SerializedName("intAwayScore") val intAwayScore: String,
    @SerializedName("intHomeShots") val intHomeShots: String,
    @SerializedName("intAwayShots") val intAwayShots: String,
    @SerializedName("strHomeGoalDetails") val strHomeGoalDetails: String,
    @SerializedName("strAwayGoalDetails") val strAwayGoalDetails: String,
    @SerializedName("strHomeLineupGoalkeeper") val strHomeLineupGoalkeeper: String,
    @SerializedName("strAwayLineupGoalkeeper") val strAwayLineupGoalkeeper: String,
    @SerializedName("strHomeLineupDefense") val strHomeLineupDefense: String,
    @SerializedName("strAwayLineupDefense") val strAwayLineupDefense: String,
    @SerializedName("strHomeLineupMidfield") val strHomeLineupMidfield: String,
    @SerializedName("strAwayLineupMidfield") val strAwayLineupMidfield: String,
    @SerializedName("strHomeLineupForward") val strHomeLineupForward: String,
    @SerializedName("strAwayLineupForward") val strAwayLineupForward: String,
    @SerializedName("strHomeLineupSubstitutes") val strHomeLineupSubstitutes: String,
    @SerializedName("strAwayLineupSubstitutes") val strAwayLineupSubstitutes: String,
    @SerializedName("dateEvent") val dateEvent: String,
    @SerializedName("idHomeTeam") val idHomeTeam: String,
    @SerializedName("idAwayTeam") val idAwayTeam: String
)