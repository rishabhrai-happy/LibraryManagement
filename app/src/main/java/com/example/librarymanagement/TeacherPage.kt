package com.example.librarymanagement

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.sign

class TeacherPage : AppCompatActivity() {
    private lateinit var signout:Button
    private lateinit var teacherhome:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_page)

        signout=findViewById(R.id.signoutteacher)
        teacherhome=findViewById(R.id.teacherhome)
        signout.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            startActivity(Intent(this,TeacherLogin::class.java))
            Toast.makeText(baseContext,"Logout succesfulll", Toast.LENGTH_SHORT).show()
            finish()
        }
        teacherhome.setOnClickListener{
            startActivity(Intent(this,AdminBookPage::class.java))

        }

    }
}