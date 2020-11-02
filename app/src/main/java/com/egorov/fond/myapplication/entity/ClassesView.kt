package com.egorov.fond.myapplication.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClassesView(
        val haveError:Boolean = false,
        val isLoading: Boolean = true,

        val listClass: List<Class> = mutableListOf()
) : Parcelable