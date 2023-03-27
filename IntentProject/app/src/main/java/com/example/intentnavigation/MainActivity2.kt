package com.example.intentnavigation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if(intent?.extras?.isEmpty == false){
            val name = intent.getStringExtra("name")
            val age = intent.getIntExtra("age", 0)

        }

        val result = Intent()
        result.putExtra("result", "Navegação com intents")
        setResult(Activity.RESULT_OK, result)
        finish()
    }
}