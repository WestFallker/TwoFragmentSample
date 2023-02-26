package com.gra_dus.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gra_dus.contacts.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToMainPage()
    }

    private fun navigateToMainPage() {
        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            val fragment = MainFragment.newInstance()
            replace(R.id.container, fragment, fragment.tag)
            commit()
        }
    }
}