package com.example.librarymanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.nio.charset.MalformedInputException

class MainActivity : AppCompatActivity() {

    private lateinit var Auth:FirebaseAuth
    private lateinit var username:EditText
    private lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login_btn: Button=findViewById(R.id.login_btn)
        username=findViewById(R.id.username_et)
        password=findViewById(R.id.paasword_et)

        Auth=FirebaseAuth.getInstance()


        login_btn.setOnClickListener{
              doLogin()


        }

     val signUp_text:TextView=findViewById(R.id.textView123)
        signUp_text.setOnClickListener {
            val intent1=Intent(this,SignupForStudent::class.java)
            startActivity(intent1)
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
                val user:FirebaseUser?=Auth.currentUser
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
            startActivity(Intent(this,StudentPage::class.java))
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
