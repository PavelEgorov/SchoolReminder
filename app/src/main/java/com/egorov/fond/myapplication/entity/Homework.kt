package com.egorov.fond.myapplication.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Homework(
    val id: String = "",
    val title: String = "",
    val image: String = "",
    val icons: String = "",
    val time: String = "",
    val text: String = ""
) : Parcelable