package com.example.androidunittesting

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class OptionListFragment : Fragment() {
    private var options = arrayListOf(Option("Test Option 1"), Option("Test Option 2"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.optionListRecyclerView)

        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context, DividerItemDecoration.VERTICAL
        )
        recyclerView.addItemDecoration(dividerItemDecoration)

        recyclerView.adapter = OptionListAdapter(options)

        view.findViewById<FloatingActionButton>(R.id.optionListFab).setOnClickListener {
            showNewOptionDialog()
        }
    }

    private fun showNewOptionDialog() {
        val builder = AlertDialog.Builder(context).setPositiveButton("Add", null)
        val form = layoutInflater.inflate(R.layout.new_option_dialog, null, false)
        builder.setView(form)

        builder.setTitle("New Option")

        val nameText = form.findViewById<EditText>(R.id.newOptionName)

        builder.setNegativeButton("Cancel") { _, _ ->  }

        val dialog = builder.create()
        dialog.show()
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            val newName = nameText.text.trim()
            if (newName.isEmpty()) {
                Toast.makeText(context, "Name cannot be empty.", Toast.LENGTH_SHORT).show()
            } else {
                options.add(Option(newName.toString()))
                dialog.dismiss()
            }
        }
    }
}