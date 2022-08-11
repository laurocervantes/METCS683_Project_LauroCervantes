
package com.example.android.buconnect.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.android.roomwordssample.R
import com.example.android.buconnect.SignUpActivity


class HomeActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var buttonSignUp: Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button = findViewById(R.id.button)
        buttonSignUp = findViewById(R.id.button2)

        button.setOnClickListener {
            val intent = Intent(this, HelloWorldHomeActivity::class.java)
            startActivity(intent)
        }

        buttonSignUp.setOnClickListener {
            val intent = Intent (this, SignUpActivity::class.java)
            startActivity(intent)
        }

        Log.d("Main Activity", "Running onCreate")
    }
}