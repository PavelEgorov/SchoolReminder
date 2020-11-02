package com.egorov.fond.myapplication.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Class (
    val id: String = "",
    val title: String = "",
    val text: String = "",
    val startAt: String = "",
    val image: String = "",
    val teacher: String = "",
    val skypeReference: String = "",
    val countClass: Int = 0,
    val attention: Boolean = false
) : Parcelable