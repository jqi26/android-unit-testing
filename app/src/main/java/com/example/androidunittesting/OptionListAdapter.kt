package com.example.androidunittesting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OptionListAdapter(private val options: List<Option>) :
    RecyclerView.Adapter<OptionListAdapter.ViewHolder>() {

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
        viewHolder.name.text = options[position].name
        viewHolder.score.text = options[position].totalScore().toString()
    }

    override fun getItemCount() = options.size
}
