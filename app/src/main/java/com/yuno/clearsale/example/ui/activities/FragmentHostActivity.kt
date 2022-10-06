package com.yuno.clearsale.example.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yuno.clearsale.example.R
import com.yuno.clearsale.example.ui.fragments.MainFragment

class FragmentHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_host)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_container, MainFragment())
            .commit()
    }
}