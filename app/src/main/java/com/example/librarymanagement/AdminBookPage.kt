package com.example.librarymanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AdminBookPage : AppCompatActivity() {
    private lateinit var Add:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_book_page)
        Add=findViewById(R.id.addbooks)

        Add.setOnClickListener {
            startActivity(Intent(this,Additionofbooksbyadmin::class.java))
        }
    }
}