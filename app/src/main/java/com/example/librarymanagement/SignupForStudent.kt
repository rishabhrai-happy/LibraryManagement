package com.example.librarymanagement

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import java.nio.charset.MalformedInputException
import java.util.regex.Pattern
import kotlin.math.sign


class SignupForStudent : AppCompatActivity() {

    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var signUp : Button
    private lateinit var fAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_for_student)
        username = findViewById(R.id.username_et_signup)
        password = findViewById(R.id.paasword_et_signup)
        signUp = findViewById(R.id.signup_btn)
        fAuth = FirebaseAuth.getInstance();

        if (fAuth!!.currentUser != null) {
            startActivity(Intent(applicationContext, MalformedInputException::class.java))
            finish()
        }
        signUp.setOnClickListener {
           signUpUser()
        }
    }
    private fun signUpUser(){
        if (username.text.toString().isEmpty()) {
            username.error = "please enter username"
            username.requestFocus()
            return
        }
        if (password.text.toString().isEmpty()) {
            password.error = "please enter password"
            password.requestFocus()
            return
        }
        fAuth.createUserWithEmailAndPassword(username.text.toString(),password.text.toString()).addOnCompleteListener(this){task ->
            if(task.isSuccessful){
                Toast.makeText(baseContext,"account created succsesfully",Toast.LENGTH_SHORT).show();
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(baseContext,"Signup Failed.Try again after some time",Toast.LENGTH_SHORT).show();
            }
        }
    }
}