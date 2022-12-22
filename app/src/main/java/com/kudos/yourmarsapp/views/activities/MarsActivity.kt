package com.kudos.yourmarsapp.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kudos.yourmarsapp.databinding.ActivityMarsBinding
import com.kudos.yourmarsapp.viewmodels.MarsViewModel
import com.kudos.yourmarsapp.views.adapters.MarsPhotosAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarsBinding

    private val marsViewModel: MarsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        binding.marsViewModel = marsViewModel

        binding.marsRecyclerView.adapter = MarsPhotosAdapter {}
    }
}