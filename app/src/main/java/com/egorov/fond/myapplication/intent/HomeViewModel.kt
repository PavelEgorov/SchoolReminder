package com.egorov.fond.myapplication.intent

import com.egorov.fond.myapplication.entity.Class
import com.egorov.fond.myapplication.entity.ExamTime
import com.egorov.fond.myapplication.entity.HomeView
import com.egorov.fond.myapplication.entity.Homework
import com.egorov.fond.myapplication.view.viewmodel.BaseViewModel
import com.egorov.fond.myapplication.view.viewmodel.IModel
import com.egorov.fond.myapplication.view.viewmodel.IView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(
    override val model: IModel,
    val mainThread: Scheduler
) : BaseViewModel<HomeView>() {

    private var currentClass: Class? = null
    private var currentExamTime: ExamTime? = null
    private val currentHomework = mutableListOf<Homework>()

    override fun update(view: IView<HomeView>) {
        model.getCurrentClass()
            .observeOn(mainThread)
            .doOnSubscribe {
                view.render(HomeView(isLoading = true))
            }
            .subscribeOn(Schedulers.io())
            .flatMap {
                currentClass = it

                model.getTimeExams()
            }
            .flatMap {
                currentExamTime = it

                model.getListHomework()
            }
            .subscribe({
                view.render(
                    HomeView(
                        classId = currentClass?.id ?: "",
                        classTitle = currentClass?.title ?: "",
                        classText = currentClass?.text ?: "",
                        classImage = currentClass?.image ?: "",
                        countClasses = "${currentClass?.countClass ?: 0}  classes today",

                        haveError = false,
                        isLoading = false,

                        timeDay1 = currentExamTime?.day1 ?: "0",
                        timeDay2 = currentExamTime?.day2 ?: "0",
                        timeHour1 = currentExamTime?.hour1 ?: "0",
                        timeHour2 = currentExamTime?.hour2 ?: "0",
                        timeMinute1 = currentExamTime?.minute1 ?: "0",
                        timeMinute2 = currentExamTime?.minute2 ?: "0",

                        listHomework = it
                    )
                )
            },
                {
                    view.render(HomeView(haveError = true))
                }
            )
    }
}