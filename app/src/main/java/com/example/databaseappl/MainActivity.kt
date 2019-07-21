package com.example.databaseappl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager: FragmentManager = supportFragmentManager
        if(savedInstanceState != null) {
            return
        }
        fragmentManager.beginTransaction().add(R.id.fragment_container, MainFragment()).commit()
    }
}
