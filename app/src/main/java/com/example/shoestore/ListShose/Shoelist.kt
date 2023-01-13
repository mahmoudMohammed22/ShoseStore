package com.example.shoestore.ListShose

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.ShoeViewModel
import com.example.shoestore.databinding.FragmentShoelistBinding
import com.example.shoestore.databinding.ListItemBinding
import com.example.shoestore.model.Shoe


class Shoelist : Fragment() {

    private lateinit var binding:FragmentShoelistBinding


    private val viewModel : ShoeViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoelist,container,false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.shoeviewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // go to screen item
        binding.addItem.setOnClickListener{
            val action = ShoelistDirections.actionShoeListToAddItem()
            findNavController().navigate(action)
        }
// to make data display
        viewModel.showList.observe(this.viewLifecycleOwner){
            for (i in it){
                addItem(i)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeList_to_login2)
        return true
    }

    fun addItem(item : Shoe){
        // to acsess about List_item
        val bindView = ListItemBinding.inflate(LayoutInflater.from(requireContext()))
        //to make item layout = new item from data
        bindView.item = item
        // to make app observable
        bindView.lifecycleOwner = viewLifecycleOwner
        // to putting image in layout
        bindView.image1.setImageResource(item.image)
        //to display list item layout in this fragment
        binding.linear1.addView(bindView.root)

    }




}

