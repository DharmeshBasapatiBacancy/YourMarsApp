package com.kudos.yourmarsapp.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kudos.yourmarsapp.databinding.ActivityAmphibiansBinding
import com.kudos.yourmarsapp.viewmodels.AmphibiansViewModel
import com.kudos.yourmarsapp.views.adapters.AmphibiansAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AmphibiansActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAmphibiansBinding

    private val _amphibiansViewModel: AmphibiansViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAmphibiansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            lifecycleOwner = this@AmphibiansActivity
            amphibiansViewModel = _amphibiansViewModel
            amphibiansRecyclerView.adapter = AmphibiansAdapter {
                startActivity(
                    Intent(this@AmphibiansActivity, AmphibiansDetailActivity::class.java)
                        .putExtra("SELECTED_ITEM", it)
                )
            }
        }
    }
}