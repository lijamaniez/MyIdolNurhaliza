package com.elsa.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.elsa.myapplication.fragment.HomeFragment
import com.elsa.myapplication.fragment.ProfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        val profileFragment = ProfilFragment()

        makeCurrentFragment (homeFragment)

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomnavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_profil -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}