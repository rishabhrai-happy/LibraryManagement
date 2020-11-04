package com.example.librarymanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class StudentPage : AppCompatActivity() {

    private lateinit var Signout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_page2)

        Signout=findViewById(R.id.Signout)

        Signout.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            startActivity(Intent(this,MainActivity::class.java))
            Toast.makeText(baseContext,"Logout succesfulll", Toast.LENGTH_SHORT).show()
        }
    }
}