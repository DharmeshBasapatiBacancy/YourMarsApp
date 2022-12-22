package com.kudos.yourmarsapp.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kudos.yourmarsapp.databinding.ActivityAmphibiansDetailBinding
import com.kudos.yourmarsapp.network.models.AmphibiansApiResponseItem

class AmphibiansDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAmphibiansDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAmphibiansDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            lifecycleOwner = this@AmphibiansDetailActivity
            amphibiansItem =
                intent.extras?.getSerializable("SELECTED_ITEM") as AmphibiansApiResponseItem
        }
    }
}