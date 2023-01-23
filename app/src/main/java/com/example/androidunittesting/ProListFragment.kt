package com.example.androidunittesting

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.androidunittesting.room.Option
import com.example.androidunittesting.room.Pro
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProListFragment : Fragment() {
    private val viewModel: OptionViewModel by navGraphViewModels(R.id.nav_graph) {
        OptionViewModelFactory((activity?.application as OptionApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pro_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack()
        }

        val adapter = ProListAdapter(arrayListOf())
        view.findViewById<RecyclerView>(R.id.prosRecyclerView).adapter = adapter

        viewModel.selectedOption?.observe(viewLifecycleOwner) {
            adapter.updateData(it.pros)
        }

        view.findViewById<FloatingActionButton>(R.id.proListFab).setOnClickListener {
            showNewProDialog()
        }
    }

    private fun showNewProDialog() {
        val builder = AlertDialog.Builder(context).setPositiveButton("Add", null)
        val form = layoutInflater.inflate(R.layout.new_pro_dialog, null, false)
        builder.setView(form)

        builder.setTitle("New Pro")

        val nameText = form.findViewById<EditText>(R.id.newProDescription)
        val spinner = form.findViewById<Spinner>(R.id.newProRatingSpinner)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, Pro.Rating.values())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

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