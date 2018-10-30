package com.dafian.android.submissionfootballclub.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballClub(val name: String?, val description: String?, val image: Int?) : Parcelable