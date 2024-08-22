package com.example.myapplication.day6

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.onNavDestinationSelected
import com.example.myapplication.R
import com.google.android.material.navigation.NavigationView

class UIActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_uiactivity)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "UI Screen"

        instantiateDrawerLayout()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorites -> Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            R.id.action_contacts -> Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            R.id.action_information -> Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }



    private fun instantiateDrawerLayout() {
        drawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.nav_gallery -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.nav_slideshow -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.nav_about -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.nav_sign_out -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                Toast.makeText(this, "No item selected", Toast.LENGTH_LONG).show()
                return false
            }
        }
    }
}