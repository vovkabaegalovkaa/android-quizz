package com.example.victorina

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var username: EditText? = null
    var confirm: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = DBAdapter(this)
        username = findViewById(R.id.userName)
        confirm = findViewById(R.id.confirm_button)
        confirm?.setOnClickListener(View.OnClickListener { view: View? ->
            if (TextUtils.isEmpty(username?.getText().toString())) Toast.makeText(
                this,
                "Enter your name!",
                Toast.LENGTH_SHORT
            ).show() else {
                db.addOne(username?.getText().toString())
                val intent = Intent(this, Quiz::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}