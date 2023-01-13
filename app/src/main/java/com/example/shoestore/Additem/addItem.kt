package com.example.shoestore.Additem

import android.os.Bundle
import android.util.Log
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.ListShose.ShoelistDirections
import com.example.shoestore.R
import com.example.shoestore.ShoeViewModel
import com.example.shoestore.databinding.FragmentAddItemBinding
import com.example.shoestore.databinding.FragmentShoelistBinding
import com.example.shoestore.databinding.ListItemBinding
import com.example.shoestore.model.Shoe

class addItem : Fragment() {

    private lateinit var binding: FragmentAddItemBinding

// to access about shoeViewModel
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_item,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // to connect viewModel with layout
        binding.viewmodel = viewModel

// click save button to save data
        binding.saveButton.setOnClickListener{
            if(entryVaild()) {

                //data from viewModel
                viewModel.listView()
                // to make data in viewModel is empty
                viewModel.resterData()
                //go to show item screen
                val action = addItemDirections.actionAddItemToShoeList()
                findNavController().navigate(action)
                Log.d("data", "Button save clicked ")
            }
        }

        //go to show item screen without data
        binding.cancelButton.setOnClickListener {
            // to make data in viewModel is empty
            viewModel.resterData()
            val action = addItemDirections.actionAddItemToShoeList()
            findNavController().navigate(action)
        }
    }


    //
    fun entryVaild():Boolean{
        return viewModel.isvaildEntry(
            binding.editShoeName.text.toString(),binding.editCompanyname.text.toString(),
            binding.editShoeSize.text.toString(),binding.editDescription.text.toString()
        )
    }












}