package com.dafian.android.submissionfootballclub.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    @SerializedName("idLeague") val idLeague: String,
    @SerializedName("strLeague") val strLeague: String,
    @SerializedName("strSport") val strSport: String,
    @SerializedName("strLeagueAlternate") val strLeagueAlternate: String
) : Parcelable