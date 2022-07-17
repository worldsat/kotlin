package com.example.kotlin.Hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.databinding.ActivityMainHiltBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivityHilt : AppCompatActivity() {
    lateinit var bilding: ActivityMainHiltBinding

    @Inject
    @Named(NAMED_USERNAME2)
    lateinit var username:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bilding=ActivityMainHiltBinding.inflate(layoutInflater)
        setContentView(bilding.root)

        bilding.apply {
            textView3.text=username
        }
    }
}