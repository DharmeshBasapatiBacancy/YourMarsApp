package com.kudos.yourmarsapp.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kudos.yourmarsapp.databinding.ActivityHomeBinding
import com.kudos.yourmarsapp.utils.Constants.BASE_URL

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            seeMarsPhotosButton.setOnClickListener {
                BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
                startActivity(Intent(this@HomeActivity, MarsActivity::class.java))
            }

            checkOutAmphibiansButton.setOnClickListener {
                BASE_URL = "https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/"
                startActivity(Intent(this@HomeActivity, AmphibiansActivity::class.java))
            }
        }
    }
}