package com.example.librarymanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class TeacherPage : AppCompatActivity() {
    lateinit var homeFragmen: teacherfirst_fragment
    lateinit var issuBook: teachersecond_fragment
    lateinit var Registerd: teacherthird_fragment
    lateinit var fine: teacherfourth_fragment
    lateinit var fragment:Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_page)
        val bottomNevagition:BottomNavigationView=findViewById(R.id.buttomnevigationView_teacher)
        val navController=findNavController(R.id.fragment2)
        val appbarConfigaretion= AppBarConfiguration(setOf(R.id.teacherfirst_fragment,R.id.teachersecond_fragment,R.id.teacherthird_fragment,R.id.teacherfourth_fragment))
        setupActionBarWithNavController(navController,appbarConfigaretion)
        bottomNevagition.setupWithNavController(navController)





    }
}