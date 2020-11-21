package com.example.librarymanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class AdminBookPage : AppCompatActivity() {
    private lateinit var Add:Button
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var notebookref: CollectionReference = db.collection("books")
    private lateinit var adapter: NodeAdapter1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_book_page)
        var recyclerView = findViewById(R.id.books) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        var user = ArrayList<Data>()

        db.collection("books").get().addOnSuccessListener { documents ->
            for (document in documents) {
                val a = document.data
                val k = a.toString().substring(10,a.toString().length-1)

                Log.d("info", "get failed with =" + document.data.toString())
                user.add(Data(k))
            }
            adapter = NodeAdapter1(user)
            recyclerView.adapter = adapter
        }.addOnFailureListener { exception ->
            Log.d("info", "get failed with ", exception)

        }

        Add=findViewById(R.id.addbooks)

        Add.setOnClickListener {
            startActivity(Intent(this,Additionofbooksbyadmin::class.java))
        }
    }
}