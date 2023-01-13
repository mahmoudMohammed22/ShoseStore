package com.example.shoestore.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.ShoeViewModel
import com.example.shoestore.databinding.FragmentLoginBinding


class login : Fragment() {

    // to make access about layout
    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Go to the welcome screen
        binding.loginButton.setOnClickListener {
            val action = loginDirections.actionLoginToWelcome2()
            findNavController().navigate(action)
        }
        // Go to the welcome screen
        binding.loginRegister.setOnClickListener {
            val action = loginDirections.actionLoginToWelcome2()
            findNavController().navigate(action)
        }


    }





}