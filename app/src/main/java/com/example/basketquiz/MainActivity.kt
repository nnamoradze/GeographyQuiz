package com.example.basketquiz
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()



        val controller = findNavController(R.id.navHomeFragment)

        navView = findViewById(R.id.bottomNavMenu)


        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.loginFragment,
                R.id.easyQuestionsFragment2,
                R.id.profileFragment2,
            )
        )

        setupActionBarWithNavController(controller,appBarConfig)
        navView.setupWithNavController(controller)

        hideNavBar()
    }


    fun hideNavBar(){
        navView.visibility = View.GONE
    }

    fun showNavBar(){
        navView.visibility = View.VISIBLE
    }

}

