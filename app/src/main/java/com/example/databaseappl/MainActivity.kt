package com.example.databaseappl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager

class MainActivity : AppCompatActivity() {
    val fragmentManager: FragmentManager = supportFragmentManager

//    companion object{
//        val fragmentManager: FragmentManager = getsupportFragmentManager()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null) {
            return
        }
        fragmentManager.beginTransaction().add(R.id.fragment_container, MainFragment()).commit()

    }
}
