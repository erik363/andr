package com.example.android.navigation.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentAdatbBinding

class AdatbFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentAdatbBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_adatb, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = NamesDataB.getInstance(application).adatbDAO

        val viewModelFactory = AdatbViewModelFactory(dataSource, application)

        val adatbViewModel =
                ViewModelProviders.of(
                        this, viewModelFactory).get(AdatbViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.adatbViewModel = adatbViewModel


        return binding.root
    }

}