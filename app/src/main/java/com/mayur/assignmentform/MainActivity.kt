package com.mayur.assignmentform

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTrasaction : FragmentTransaction = fragmentManager.beginTransaction()
        val page1 = Page1()
        fragmentTrasaction.add(R.id.frame,page1,"page1_frag")
        fragmentTrasaction.commit()
    }
}