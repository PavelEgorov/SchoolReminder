package com.egorov.fond.myapplication.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExamTime (
    val day1: String = "0",
    val day2: String = "0",
    val hour1: String = "0",
    val hour2: String = "0",
    val minute1: String = "0",
    val minute2: String = "0"
) : Parcelable