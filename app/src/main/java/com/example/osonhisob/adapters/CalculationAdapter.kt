package com.example.osonhisob.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.osonhisob.R
import com.example.osonhisob.database.CalculationData
import com.example.osonhisob.utils.convertLongToTime
import kotlinx.android.synthetic.main.calculation_item.view.*

class CalculationAdapter (var data: ArrayList<CalculationData>) :
    RecyclerView.Adapter<CalculationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.calculation_item, parent, false
        )
    )
    private var listener: ((Int) -> Unit)? = null

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.apply {

//                status_id1.setOnClickListener {
//                    listener?.invoke(adapterPosition)
//                }
            }
        }


        fun bind() {
            val d = data[adapterPosition]
            itemView.apply {
                result_text.text="Хисоб : "+d.resultText
                calculation_text.text="Техт : "+d.calculationText
                date_text.text="Санаси : "+ convertLongToTime(d.savedTime)
            }
        }
    }

    fun setOnStatusListener(f: ((Int) -> Unit)?) {
        listener = f
    }

}