package com.example.intentnavigation

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intentnavigation.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val activity2Intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("name","Hugo")
        intent.putExtra("age", 35)

        val activityResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: androidx.activity.result.ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK){
                    val intent = result.data

                    if(intent?.hasExtra("result") == true){
                        Snackbar.make(binding.root, intent.getStringExtra("result")?: "",
                            Snackbar.LENGTH_SHORT).show()
                    }
                }
        }

        binding.startActivityButton.setOnClickListener {
           activityResult.launch(activity2Intent)
        }
    }
}