package com.example.shoestore.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
// use adapter to connect fragment with viewPager
class MypagenAdapter(container : Fragment ,  private val fragment: List<Fragment>) : FragmentStateAdapter(container) {
    override fun getItemCount() = fragment.size

    override fun createFragment(position: Int) = fragment[position]
}