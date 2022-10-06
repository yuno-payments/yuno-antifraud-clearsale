package com.yuno.clearsale.example.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.yuno.antifraud.clearsale.onCreateYunoClearSale
import com.yuno.antifraud.clearsale.onResumeYunoClearSale
import com.yuno.antifraud.clearsale.onStopYunoClearSale
import com.yuno.clearsale.example.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_show_fragment)
            .setOnClickListener {
                startActivity(
                    Intent(this, FragmentHostActivity::class.java)
                )
            }
        onCreateYunoClearSale()
    }

    override fun onResume() {
        super.onResume()
        onResumeYunoClearSale(true)
    }

    override fun onStop() {
        super.onStop()
        onStopYunoClearSale()
    }
}