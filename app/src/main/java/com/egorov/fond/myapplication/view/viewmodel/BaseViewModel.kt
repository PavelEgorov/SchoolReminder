package com.egorov.fond.myapplication.view.viewmodel

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable


/// Класс для работы с Intent
abstract class BaseViewModel<T> {
    abstract val model: IModel

    abstract fun update(view: IView<T>)
}