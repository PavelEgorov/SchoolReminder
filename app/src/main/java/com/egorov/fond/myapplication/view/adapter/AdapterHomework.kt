package com.egorov.fond.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorov.fond.myapplication.R
import com.egorov.fond.myapplication.entity.Homework
import kotlinx.android.synthetic.main.card_homework.view.*

class AdapterHomework(
    private var data: MutableList<Homework>
): RecyclerView.Adapter<AdapterHomework.ViewHolder>() {


    fun update(data: List<Homework>){
        this.data.clear()
        this.data.addAll(data)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.card_homework, parent, false) as View)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        fun bind(item: Homework) = with(itemView){
            card_homework_title.text = item.title
            card_homework_text.text = item.text
            card_homework_time_ready.text = item.time

            /// Загрузка иконок и изображения пропустим. Реализация через glide
        }
    }
}