package com.egorov.fond.myapplication.view.viewmodel

import androidx.fragment.app.Fragment

/// Класс для работы с View
abstract class IView <T>: Fragment(){
    abstract fun render(responce: T)
}