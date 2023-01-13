package com.example.shoestore.onBordind

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.Adapter.MypagenAdapter
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentBordindInstructionsBinding
import com.google.android.material.tabs.TabLayoutMediator


class BordindInstructions : Fragment() {


    private lateinit var binding:FragmentBordindInstructionsBinding

    //List of fragments to be displayed in onBording
    val fragments = listOf(Instructions() , Instructionstwo())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater
            ,R.layout.fragment_bordind_instructions,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // to make viewpager In the form of a circuit
        intitViewPager()
        // Connect the fragment with adater
        initTapLayout()

        // go to show item screen
        binding.loginRegister.setOnClickListener {
            val action = BordindInstructionsDirections.actionBordindInstructionsToShoeList()
            findNavController().navigate(action)
        }
    }

    private fun initTapLayout() {
        TabLayoutMediator(binding.taoLayout,binding.viewPager){tap,postion->
        }.attach()
    }

    private fun intitViewPager() {
        val Adapter = MypagenAdapter(this,fragments)
        binding.viewPager.adapter = Adapter

    }


}