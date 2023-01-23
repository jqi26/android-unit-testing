package com.example.androidunittesting

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidunittesting.room.Pro

class ProListAdapter(private var pros: List<Pro>) :
    RecyclerView.Adapter<ProListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val score: TextView

        init {
            name = view.findViewById(R.id.optionItemName)
            score = view.findViewById(R.id.optionItemScore)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.option_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text = pros[position].description
        viewHolder.score.text = pros[position].rating.num.toString()
    }

    override fun getItemCount() = pros.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(pros: List<Pro>) {
        this.pros = pros
        notifyDataSetChanged()
    }
}