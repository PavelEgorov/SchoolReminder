package com.egorov.fond.myapplication.intent

import com.egorov.fond.myapplication.entity.ClassesView
import com.egorov.fond.myapplication.view.viewmodel.BaseViewModel
import com.egorov.fond.myapplication.view.viewmodel.IModel
import com.egorov.fond.myapplication.view.viewmodel.IView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class ClassesViewModel(
        override val model: IModel,
        val mainThread: Scheduler
) : BaseViewModel<ClassesView>() {

    override fun update(view: IView<ClassesView>) {
        model.getListClasses()
                .observeOn(mainThread)
                .doOnSubscribe { view.render(ClassesView(isLoading = true)) }
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    view.render(ClassesView(isLoading = false, haveError = false, listClass = it))
                },{
                    view.render(ClassesView(haveError = true))
                })
    }
}