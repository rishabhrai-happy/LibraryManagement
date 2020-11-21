package com.example.librarymanagement

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class student_books : AppCompatActivity() {
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var notebookref: CollectionReference = db.collection("books")
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_books)

        var recyclerView = findViewById(R.id.list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        var user = ArrayList<Data>()

        db.collection("books").get().addOnSuccessListener { documents ->
            for (document in documents) {
                val a = document.data
                 val k = a.toString().substring(10,a.toString().length-1)
                Log.d("info", "get failed with =" + document.data.toString())
                user.add(Data(k))
            }
            adapter = NoteAdapter(user)
            recyclerView.adapter = adapter
        }.addOnFailureListener { exception ->
            Log.d("info", "get failed with ", exception)

        }


    }
}