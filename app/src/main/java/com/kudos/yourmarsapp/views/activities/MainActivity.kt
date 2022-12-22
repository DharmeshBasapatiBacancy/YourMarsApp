package com.kudos.yourmarsapp.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kudos.yourmarsapp.databinding.ActivityMainBinding
import com.kudos.yourmarsapp.viewmodels.MarsViewModel
import com.kudos.yourmarsapp.views.adapters.MarsPhotosAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val marsViewModel: MarsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        binding.marsViewModel = marsViewModel

        binding.marsRecyclerView.adapter = MarsPhotosAdapter {}
    }
}