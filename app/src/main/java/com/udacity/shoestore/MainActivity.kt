package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import timber.log.Timber
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        navController = this.findNavController(R.id.nav_host_fragment)
        setSupportActionBar(binding.myToolbar)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginFragment,
                R.id.welcomeFragment,
                R.id.instructionsFragment
            )
        )
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        setupWithNavController(binding.myToolbar, navController, appBarConfiguration)
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
