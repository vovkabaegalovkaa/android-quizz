package com.example.victorina

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class End : AppCompatActivity() {
    var name: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        val db = DBAdapter(this)
        name = findViewById(R.id.textView3)
        name?.setText("Congratulations, " + db.all + "!")
    }
}