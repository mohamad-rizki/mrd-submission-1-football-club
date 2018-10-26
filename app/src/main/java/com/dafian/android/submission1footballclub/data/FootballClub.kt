package com.dafian.android.submission1footballclub.data

import android.os.Parcel
import android.os.Parcelable

data class FootballClub(val name: String?, val description: String?, val image: Int?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeValue(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FootballClub> {
        override fun createFromParcel(parcel: Parcel): FootballClub {
            return FootballClub(parcel)
        }

        override fun newArray(size: Int): Array<FootballClub?> {
            return arrayOfNulls(size)
        }
    }
}