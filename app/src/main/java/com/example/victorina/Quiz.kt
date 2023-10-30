package com.example.victorina

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.atomic.AtomicInteger

class Quiz : AppCompatActivity() {
    var quastion: TextView? = null
    var answer1: TextView? = null
    var answer2: TextView? = null
    var count: TextView? = null
    var answer3: TextView? = null
    var next: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val i = AtomicInteger()
        i.set(1)
        quastion = findViewById(R.id.question)
        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        count = findViewById(R.id.cout)
        next = findViewById(R.id.check)
        val answerMap: MutableMap<Int, TextView?> = HashMap()
        answerMap[1] = answer1
        answerMap[2] = answer2
        answerMap[3] = answer3
        val taskMap: MutableMap<Int, Task> = HashMap()
        taskMap[1] = Task("How many years did the Hundred Years' War last?", "113", "116", "100", 2)
        taskMap[2] = Task("How many ice ages have there been on Earth?", "3", "4", "5", 3)
        taskMap[3] = Task(
            "In what year did the storming of the Bastille take place?",
            "1789",
            "1812",
            "1941",
            1
        )
        taskMap[4] = Task("How many years did Napoleon live?", "63", "48", "51", 3)
        taskMap[5] = Task("In what year did the Second World War begin?", "1812", "1939", "1941", 2)
        taskMap[6] =
            Task("In what year did the Ottoman Empire collapse?", "1908", "1918", "1922", 3)
        taskMap[7] =
            Task("How many times did the Polish-Lithuanian Commonwealth split?", "3", "1", "2", 1)
        taskMap[8] =
            Task("In what year was the Republic of Belarus formed?", "1993", "1991", "1354", 2)
        taskMap[9] =
            Task("How many wars were there between France and Great Britain?", "41", "0", "103", 1)
        taskMap[10] = Task("In what year did Colmub discover America?", "1492", "1552", "1494", 1)
        SetValues(i.toInt(), taskMap)
        val choose = AtomicInteger()
        answer1?.setOnClickListener(View.OnClickListener { view: View? ->
            answer1?.setBackgroundResource(R.drawable.textview_border)
            choose.set(1)
            answer2?.setBackgroundResource(R.drawable.default_border)
            answer3?.setBackgroundResource(R.drawable.default_border)
        })
        answer2?.setOnClickListener(View.OnClickListener { view: View? ->
            answer2?.setBackgroundResource(R.drawable.textview_border)
            choose.set(2)
            answer1?.setBackgroundResource(R.drawable.default_border)
            answer3?.setBackgroundResource(R.drawable.default_border)
        })
        answer3?.setOnClickListener(View.OnClickListener { view: View? ->
            answer3?.setBackgroundResource(R.drawable.textview_border)
            choose.set(3)
            answer1?.setBackgroundResource(R.drawable.default_border)
            answer2?.setBackgroundResource(R.drawable.default_border)
        })
        next?.setOnClickListener(View.OnClickListener { view: View? ->
            if (choose.toInt() == 0) {
                Toast.makeText(this, "Make choise", Toast.LENGTH_SHORT).show()
            } else if (taskMap[i.toInt()]!!.correctAnswer == choose.toInt()) {
                answerMap[choose.toInt()]!!.setBackgroundResource(R.drawable.correct_textview_border)
                Toast.makeText(this, "Right!", Toast.LENGTH_SHORT).show()
                if (i.toInt() >= 10) {
                    val inent = Intent(this, End::class.java)
                    startActivity(inent)
                    finish()
                }
                i.getAndIncrement()
                SetValues(i.toInt(), taskMap)
            } else {
                answerMap[choose.toInt()]!!.setBackgroundResource(R.drawable.uncorrect_textview_border)
                Toast.makeText(this, "NO!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun SetValues(i: Int, map: Map<Int, Task>) {
        answer1!!.setBackgroundResource(R.drawable.default_border)
        answer2!!.setBackgroundResource(R.drawable.default_border)
        answer3!!.setBackgroundResource(R.drawable.default_border)
        quastion!!.text = map[i]!!.quastion
        answer1!!.text = map[i]!!.a1
        answer2!!.text = map[i]!!.a2
        answer3!!.text = map[i]!!.a3
        count!!.text = "$i/10"
    }
}