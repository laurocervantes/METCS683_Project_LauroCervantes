package com.example.android.buconnect

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.android.roomwordssample.R
import com.example.android.buconnect.ui.HomeActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        button = findViewById(R.id.btn_signup2)

        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        Log.d("Main Activity", "Running onCreate")
    }
}