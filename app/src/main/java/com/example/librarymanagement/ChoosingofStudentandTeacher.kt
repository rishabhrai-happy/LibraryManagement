package com.example.librarymanagement

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_choosingof_studentand_teacher.*

class ChoosingofStudentandTeacher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosingof_studentand_teacher)
        val studentLogin:ImageView=findViewById(R.id.studentlogin)
        //val teacherLogin:ImageView=findViewById(R.id.textforteacherlogin)
        studentLogin.setOnClickListener{

            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        teacherlogin.setOnClickListener{
            val intent=Intent(this,TeacherLogin::class.java)
            startActivity(intent)
        }
}
}