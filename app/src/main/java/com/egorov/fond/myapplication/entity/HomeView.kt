package com.egorov.fond.myapplication.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeView(
        val haveError:Boolean = false,
        val isLoading: Boolean = true,

        val timeDay1: String = "0",
        val timeDay2: String = "0",
        val timeHour1: String = "0",
        val timeHour2: String = "0",
        val timeMinute1: String = "0",
        val timeMinute2: String = "0",
        val countClasses: String = "0 classes today",
        val classTitle: String = "",
        val classText: String = "",
        val classImage: String = "",
        val classId: String = "",

        val userId: String = "",
        val name: String = "",

        val listHomework: List<Homework> = mutableListOf()
) : Parcelable