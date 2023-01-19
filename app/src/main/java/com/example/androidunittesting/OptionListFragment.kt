package com.example.androidunittesting

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.androidunittesting.room.Option
import com.google.android.material.floatingactionbutton.FloatingActionButton


class OptionListFragment : Fragment() {
    private val viewModel: OptionViewModel by navGraphViewModels(R.id.nav_graph) {
        OptionViewModelFactory((activity?.application as OptionApplication).repository)
    }

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

        val adapter = OptionListAdapter(arrayListOf())
        recyclerView.adapter = adapter
        viewModel.options.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }

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
                viewModel.addOption(Option(newName.toString()))
                dialog.dismiss()
            }
        }
    }
}