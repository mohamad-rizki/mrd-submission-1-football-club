package com.dafian.android.submissionfootballclub.data.entity

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("idTeam") val idTeam: String,
    @SerializedName("strTeam") val strTeam: String,
    @SerializedName("strAlternate") val strAlternate: String,
    @SerializedName("intFormedYear") val intFormedYear: String,
    @SerializedName("strSport") val strSport: String,
    @SerializedName("idLeague") val idLeague: String,
    @SerializedName("strLeague") val strLeague: String,
    @SerializedName("strManager") val strManager: String,
    @SerializedName("strStadium") val strStadium: String,
    @SerializedName("strKeywords") val strKeywords: String,
    @SerializedName("strStadiumThumb") val strStadiumThumb: String,
    @SerializedName("strStadiumDescription") val strStadiumDescription: String,
    @SerializedName("strStadiumLocation") val strStadiumLocation: String,
    @SerializedName("intStadiumCapacity") val intStadiumCapacity: String,
    @SerializedName("strWebsite") val strWebsite: String,
    @SerializedName("strFacebook") val strFacebook: String,
    @SerializedName("strTwitter") val strTwitter: String,
    @SerializedName("strInstagram") val strInstagram: String,
    @SerializedName("strYoutube") val strYoutube: String,
    @SerializedName("strDescriptionEN") val strDescriptionEN: String,
    @SerializedName("strCountry") val strCountry: String,
    @SerializedName("strTeamBadge") val strTeamBadge: String,
    @SerializedName("strTeamJersey") val strTeamJersey: String,
    @SerializedName("strTeamLogo") val strTeamLogo: String,
    @SerializedName("strTeamBanner") val strTeamBanner: String
)