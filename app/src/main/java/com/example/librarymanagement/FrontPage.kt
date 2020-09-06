package com.example.librarymanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class FrontPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)
        val timer= Timer()
        timer.schedule(object : TimerTask(){
            override fun run() {
                goingTochoicePage()
            }
        },1500)
    }
    fun goingTochoicePage(){
        val intent=Intent(this,ChoosingofStudentandTeacher::class.java)
        startActivity(intent)
    }
}