package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Pindah = findViewById<Button>(R.id.next)
        val Pindah1 = findViewById<Button>(R.id.previous)
        showFragmentOne()

        Pindah.setOnClickListener({
            if (isFragmentOneLoaded)
                showFragmentTwo()
            else
                showFragmentOne()
        })
        Pindah1.setOnClickListener({
            if (isFragmentOneLoaded)
                showFragmentThree()
            else
                showFragmentOne()
        })
    }

    fun showFragmentOne (){
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true

    }

    fun showFragmentTwo (){
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false

    }

    fun showFragmentThree (){
        val transaction = manager.beginTransaction()
        val fragment = FragmentThree()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false

    }
}
