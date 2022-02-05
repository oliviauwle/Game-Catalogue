package com.example.gamecatalogue.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import android.os.Bundle
import com.example.gamecatalogue.databinding.ActivityMainBinding
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputBinding
import androidx.fragment.app.Fragment
import com.example.gamecatalogue.R
import com.example.gamecatalogue.presentation.activity.DetailActivity.Companion.start
import com.example.gamecatalogue.presentation.fragment.LatestFragment
import com.example.gamecatalogue.presentation.fragment.PopularFragment
import com.example.gamecatalogue.presentation.model.Popular
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            bnvMain.apply {
                setOnItemSelectedListener {
                    val fragment: Fragment = when (it.itemId) {
                        R.id.menu_popular -> {
                            PopularFragment.newInstance()
                        }
                        R.id.menu_latest -> {
                            LatestFragment.newInstance()
                        }
                        else -> throw IllegalStateException("Menu id unknown")
                    }
                    supportFragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).commit()
                    true
                }
                selectedItemId = R.id.menu_popular
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_settings -> SettingsActivity.start(this)
            else -> throw IllegalStateException("Menu id unknown")
        }
        return super.onOptionsItemSelected(item)
    }
}
}*/

)

        /*private fun initRecyclerView () {
            with(binding){ this: ActivityMainBinding
                rvSearch.apply{
                LayoutManager = LinearLayoutManager( context: this@MainActivity, LinearLayoutManager.VERTICAL
                    adapter = popularAdapter
                    addItemDecoration(
                        DividerItemDecoration( context: this@MainActivity, DividerItemDecoration. VERTICAL)
                    )
                }

