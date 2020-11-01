package com.egorov.fond.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.egorov.fond.myapplication.R
import com.egorov.fond.myapplication.entity.HomeView
import com.egorov.fond.myapplication.entity.Homework
import com.egorov.fond.myapplication.view.adapter.AdapterHomework
import com.egorov.fond.myapplication.view.viewmodel.BaseViewModel
import com.egorov.fond.myapplication.view.viewmodel.IView
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject

/// Напрашивается фрагмент, состоящий из нескольких фрагментов, но как реализовать даннй момент я пока не знаю..
/// Для каждого сфрагмента будет очень здорово реализовываться модель mvi
class HomeFragment : IView<HomeView>() {

    private val viewModel: BaseViewModel<HomeView> by inject()

    private lateinit var day1: TextView
    private lateinit var day2: TextView
    private lateinit var hour1: TextView
    private lateinit var hour2: TextView
    private lateinit var minute1: TextView
    private lateinit var minute2: TextView
    private lateinit var classTitle: TextView
    private lateinit var classText: TextView
    private lateinit var classImage: AppCompatImageView
    private lateinit var countClasses: TextView

    private var adapter: AdapterHomework? = null

    companion object{
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
   }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        day1 = view.findViewById(R.id.day_1)
        day2 = view.findViewById(R.id.day_2)
        hour1 = view.findViewById(R.id.hourse_1)
        hour2 = view.findViewById(R.id.hourse_2)
        minute1 = view.findViewById(R.id.minutes_1)
        minute2 = view.findViewById(R.id.minutes_2)

        classImage = view.findViewById(R.id.classes_image)
        classTitle = view.findViewById(R.id.card_time_exam_title)
        classText = view.findViewById(R.id.card_time_exam_information)

        countClasses = view.findViewById(R.id.home_classes_text)

        return view
    }

    override fun onStart() {
        super.onStart()
        viewModel.update(this)
    }

    override fun render(responce: HomeView) {
        day1.text = responce.timeDay1
        day2.text = responce.timeDay2
        hour1.text = responce.timeHour1
        hour2.text = responce.timeHour2
        minute1.text = responce.timeMinute1
        minute2.text = responce.timeMinute2

        classTitle.text = responce.classTitle
        classText.text = responce.classText

        countClasses.text = responce.countClasses

        /// Реализацию Изображения сделаю позже. Предполагаю грузить через глайд

        renderHomework(responce.listHomework.toMutableList())
    }

    private fun renderHomework(homeworkList: MutableList<Homework>) {
        if (adapter == null) {
            initRecyclerView(homeworkList)
        } else
            adapter!!.update(homeworkList)
    }

    private fun initRecyclerView(
        homework: MutableList<Homework>,
    ) {
        adapter = AdapterHomework(
           homework
        )

        home_rv_homework.layoutManager = LinearLayoutManager(context)
        home_rv_homework.adapter = adapter
        home_rv_homework.setHasFixedSize(true)
    }
}