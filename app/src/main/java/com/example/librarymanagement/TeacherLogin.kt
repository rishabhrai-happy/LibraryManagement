package com.example.librarymanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class TeacherLogin : AppCompatActivity() {
    private lateinit var Auth: FirebaseAuth
    private lateinit var username: EditText
    private lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_login)
        val login_btn: Button=findViewById(R.id.login_btn)
        username=findViewById(R.id.teacherid)
        password=findViewById(R.id.paasword_et)

        Auth=FirebaseAuth.getInstance()
        login_btn.setOnClickListener{
            doLogin()


        }

    }

    private fun doLogin(){
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

        Auth.signInWithEmailAndPassword(username.text.toString(),password.text.toString()).addOnCompleteListener{
                task ->
            if(task.isSuccessful){
                val user: FirebaseUser?=Auth.currentUser
                updateUI(user)
            }

            else{

                updateUI(null)
            }
        }
    }

    private  fun updateUI(currentuser:FirebaseUser?){
        if(currentuser!=null){
            Toast.makeText(baseContext,"Login sucsessful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,TeacherPage::class.java))
            finish()
        }
        else{
            Toast.makeText(baseContext,"Login Failed", Toast.LENGTH_SHORT).show()
        }

    }public override fun onStart() {
        super.onStart()
        val user:FirebaseUser?=Auth.currentUser
        updateUI(user)

    }
}