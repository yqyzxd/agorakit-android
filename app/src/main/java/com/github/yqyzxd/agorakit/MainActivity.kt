package com.github.yqyzxd.agorakit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wind.agorakit.Agora

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Agora.getInstance().create(this)
    }
}