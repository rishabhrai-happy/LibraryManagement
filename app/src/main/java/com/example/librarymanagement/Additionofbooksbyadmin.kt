package com.example.librarymanagement

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class Additionofbooksbyadmin : AppCompatActivity() {
    private lateinit var Enterbookname:EditText
    private lateinit var Add:Button
    var db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additionofbooksbyadmin)
        Enterbookname=findViewById(R.id.booknamebyadmin)
        Add=findViewById(R.id.Addbooks)

        Add.setOnClickListener {

            doAddition()

        }

    }

    private fun doAddition() {
        if (Enterbookname.text.toString().isEmpty()) {
            Enterbookname.error = "please enter enterbookname"
            Enterbookname.requestFocus()
          return
        }
        val books: MutableMap<String, Any> = HashMap()
        books["bookname"] = Enterbookname.text.toString()


        db.collection("books")
            .add(books)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(baseContext,"added succsesfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(baseContext,"not added due to some reason please try again", Toast.LENGTH_SHORT).show()
            }
    }
}