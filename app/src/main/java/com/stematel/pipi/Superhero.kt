package com.stematel.recylerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Superhero(
    val imgsuperhero: Int,
    val namesuperhero: String,
    val descsuperhero: String
) : Parcelable
