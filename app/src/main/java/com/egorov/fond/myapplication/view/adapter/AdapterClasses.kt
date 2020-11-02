package com.egorov.fond.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorov.fond.myapplication.R
import com.egorov.fond.myapplication.entity.Class
import kotlinx.android.synthetic.main.card_classes_rv.view.*

class AdapterClasses(
        private var data: MutableList<Class>
): RecyclerView.Adapter<AdapterClasses.ViewHolder>() {


    fun update(data: List<Class>){
        this.data.clear()
        this.data.addAll(data)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.card_classes_rv, parent, false) as View)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(data[position])

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        fun bind(item: Class) = with(itemView){
            rv_card_classes_time.text = item.startAt
            rv_card_classes_teacher.text = item.teacher
            rv_card_classes_title.text = item.title

            if (item.skypeReference.isEmpty()) rv_card_view_skype.visibility = View.GONE
            else rv_card_view_skype.visibility = View.VISIBLE


            if (item.attention) {
                classes_part_1.setBackgroundResource(R.drawable.gradient_attention)
                classes_part_2.setBackgroundResource(R.drawable.gradient_attention)
            }
            else {
                classes_part_1.setBackgroundResource(R.color.ligth_gray)
                classes_part_2.setBackgroundResource(R.color.ligth_gray)
            }

            /// Загрузка иконок и изображения пропустим. Реализация через glide
        }
    }
}