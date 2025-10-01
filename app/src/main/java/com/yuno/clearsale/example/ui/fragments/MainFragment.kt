package com.yuno.clearsale.example.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yuno.antifraud.clearsale.onCreateYunoClearSale
import com.yuno.antifraud.clearsale.onResumeYunoClearSale
import com.yuno.antifraud.clearsale.onStopYunoClearSale
import com.yuno.clearsale.example.R

class MainFragment : Fragment() {
    private var clearSaleSessionId : String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.context?.onCreateYunoClearSale("CLEAR_SALE_APP_KEY")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
        clearSaleSessionId = this.context?.onResumeYunoClearSale()
    }

    override fun onStop() {
        super.onStop()
        this.context?.onStopYunoClearSale()
    }
}