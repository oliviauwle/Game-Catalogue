package com.example.gamecatalogue.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gamecatalogue.databinding.ActivityMainBinding
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.gamecatalogue.R
import com.example.gamecatalogue.presentation.fragment.LatestFragment
import com.example.gamecatalogue.presentation.fragment.PopularFragment

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
                        R.id.menu_popular_games -> {
                            PopularFragment.newInstance()
                        }
                        R.id.menu_latest_games -> {
                            LatestFragment.newInstance()
                        }
                        else -> throw IllegalStateException("Menu id unknown")
                    }
                    supportFragmentManager.beginTransaction().replace(R.id.mainContainer, fragment)
                        .commit()
                    true
                }
                selectedItemId = R.id.menu_popular_games
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

}