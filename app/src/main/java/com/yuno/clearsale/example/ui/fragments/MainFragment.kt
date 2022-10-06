package com.yuno.clearsale.example.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.yuno.antifraud.clearsale.onCreateYunoClearSale
import com.yuno.antifraud.clearsale.onResumeYunoClearSale
import com.yuno.antifraud.clearsale.onStopYunoClearSale
import com.yuno.clearsale.example.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.context?.onCreateYunoClearSale()
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
        this.context?.onResumeYunoClearSale(true)
    }

    override fun onStop() {
        super.onStop()
        this.context?.onStopYunoClearSale()
    }
}