package com.egorov.fond.myapplication.view.viewmodel

import com.egorov.fond.myapplication.entity.Class
import com.egorov.fond.myapplication.entity.ExamTime
import com.egorov.fond.myapplication.entity.Homework
import io.reactivex.rxjava3.core.Single

// Класс для работы с Model.
abstract class IModel {
    abstract fun getCurrentClass(): Single<Class>
    abstract fun getListClasses(): Single<List<Class>>

    abstract fun getTimeExams(): Single<ExamTime>

    abstract fun getListHomework(): Single<List<Homework>>
}