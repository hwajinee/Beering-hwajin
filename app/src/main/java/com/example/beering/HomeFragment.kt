package com.example.beering
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.beering.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }
    var homeAdapter: HomeAdapter?= null

}