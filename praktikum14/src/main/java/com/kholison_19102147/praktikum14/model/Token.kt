package com.kholison_19102147.praktikum14.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Token(
    var token: String? = null
): Parcelable