package com.yuno.clearsale.example.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yuno.antifraud.clearsale.onCreateYunoClearSale
import com.yuno.antifraud.clearsale.onResumeYunoClearSale
import com.yuno.antifraud.clearsale.onStopYunoClearSale
import com.yuno.clearsale.example.R

class MainActivity : AppCompatActivity() {
    private var clearSaleSessionId : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_show_fragment)
            .setOnClickListener {
                startActivity(
                    Intent(this, FragmentHostActivity::class.java)
                )
            }
        onCreateYunoClearSale("CLEAR_SALE_APP_KEY")
    }

    override fun onResume() {
        super.onResume()
        clearSaleSessionId = onResumeYunoClearSale()
    }

    override fun onStop() {
        super.onStop()
        onStopYunoClearSale()
    }
}