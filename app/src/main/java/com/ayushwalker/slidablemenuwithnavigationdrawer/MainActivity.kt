package com.ayushwalker.slidablemenuwithnavigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        navView = findViewById(R.id.navView)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open, R.string.close) // read notes of step 8,9.
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState() // this is necessary as it defines that it is ready to be used.

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // by doing that we completed making the navigation bar , but the menu items will not responds on clicking

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> Toast.makeText(this@MainActivity, "Clicked Item 1", Toast.LENGTH_SHORT).show()
                R.id.miItem2 -> Toast.makeText(this@MainActivity, "Clicked Item 2", Toast.LENGTH_SHORT).show()
                R.id.miItem3 -> Toast.makeText(this@MainActivity, "Clicked Item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

//    override the onOptionsItemSelected() function to implement the item click listener callback to open and close the navigation drawer
//    when the icon is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }


}

/*
STEPS/NOTES:
1. First Add google Dependencies line to build(:app) file, ie ( implementation 'com.google.android.material:material:1.9.0-alpha01' )
2. Start by Creating A layout
3. For navigation drawer, we need to use Drawer Layout, ( androidx.drawerlayout.widget.DrawerLayout )
4. Now add a Constraint Layout under the Drawable Layout as a Fragment
5. Add Navigation view just below the Constraint Layout.
6. fitsSystemWindow means that the navigation drawer will leave space for systemWindows such as status bar.
7. Now create a Header Layout and a Menu bar, for HeaderLayout, we create a new layout file named nav_header.xml, and for menu,
    we create a nav_drawer_menu.xml file
8. we need a toggle for the Slidable Menu bar, and we use lateinit as we are assuring that we will going to initialize it later on  for sure.
    This drawable shows a Hamburger icon when drawer is closed and an arrow when drawer is open. It animates between these two states as the drawer opens.
9. Initialize the toggle variable with ActionBarDrawerToggle class instance as it will create a button for toggling.
10. After that, add that toggle button to the drawerLayout using addDrawerListener function. also need to syncState the toggle, as it states that
    the toggle button is ready to use.
11. override the onOptionsItemSelected() function to implement the item click listener callback to open and close the navigation drawer
    when the icon is clicked.
12. now add supportActionBar?.setDisplayHomeAsUpEnabled(true) as it will to make the Navigation drawer icon always appear on the action bar
13. By doing above steps, Slidable navigation bar is completed, but the menu items will not react on clicking,
14. To do so, add setNavigationItemSelectedListener which acts as the item listener for the items in the menu bar.
*/