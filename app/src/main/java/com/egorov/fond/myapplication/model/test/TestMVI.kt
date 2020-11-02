package com.egorov.fond.myapplication.model.test

import com.egorov.fond.myapplication.entity.Class
import com.egorov.fond.myapplication.entity.ExamTime
import com.egorov.fond.myapplication.entity.Homework
import com.egorov.fond.myapplication.entity.User
import com.egorov.fond.myapplication.view.viewmodel.IModel
import io.reactivex.rxjava3.core.Single


class TestMVI: IModel() {
    override fun getCurrentClass(): Single<Class> = Single.just(
        Class(
            id = "1",
            title = "History",
            text = "",
            startAt = "8:00 - 8:45",
            teacher = "Mrs Thomas",
            countClass = 6
    ))

    override fun getListClasses(): Single<List<Class>> = Single.just(
        mutableListOf(
            Class(
                id = "1",
                title = "History",
                text = "",
                startAt = "8:00 - 8:45",
                teacher = "Mrs Thomas",
                countClass = 6,
                skypeReference = "skype"
            ),
            Class(
                id = "2",
                title = "Literature",
                text = "",
                startAt = "9:00 - 9:45",
                teacher = "Mrs Barros",
                countClass = 6
            ),
            Class(
                id = "3",
                title = "Physical Education",
                text = "",
                startAt = "10:00 - 11:35",
                teacher = "Mrs Barros",
                countClass = 6,
                attention = true
            )
        )
    )

    override fun getTimeExams(): Single<ExamTime> = Single.just(
        ExamTime(
            day1 = "0",
            day2 =  "9",
            hour1 = "2",
            hour2 = "3",
            minute1 = "5",
            minute2 = "9"
    ))

    override fun getListHomework(): Single<List<Homework>> = Single.just(mutableListOf<Homework>(
        Homework(id = "1", title = "Literature", time = "2 days left", text = "Read scenes 11-12 of the Master and Margarita"),
        Homework(id = "2", title = "Physics", time = "5 days left", text = "Learn Newton's low")
    ))

    override fun getUser(): Single<User> = Single.just(User(id = "1", name = "Mike"))
}