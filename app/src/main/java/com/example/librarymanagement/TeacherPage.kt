package com.example.librarymanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
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
       // val buttomNevigationView=findViewById<BottomNavigationItemView>(R.id.buttomnevigationView_teacher)
        val navController=findNavController(R.id.fragment2)
        val appBarConfiguration=
            AppBarConfiguration(setOf(R.id.teacherfirst_fragment,R.id.teachersecond_fragment,R.id.teacherthird_fragment,R.id.teacherfourth_fragment))
        setupActionBarWithNavController(navController,appBarConfiguration)
         homeFragmen= teacherfirst_fragment()
         issuBook= teachersecond_fragment()
         Registerd= teacherthird_fragment()
         fine=teacherfourth_fragment()



        //buttomNevigationView.setupWithNavController(navController)
        BottomNavigationView.OnNavigationItemReselectedListener {
            item ->

            when(item.itemId){
                R.id.teacherfirst_fragment ->{
                    fragment=homeFragmen
                }
            }
        }
    }
}