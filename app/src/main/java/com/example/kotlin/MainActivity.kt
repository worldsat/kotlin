package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var te: String = ""
    var str: Int = 0
    var num: Int = 1;
  lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (str == num) {
            print("123" + str + "23")
        }
        when (num) {
            3 -> {
                print("333")
            }
            in 1..4 -> {        //range between
                print("333")
            }
            else -> {
                print("333")
            }
        }


        for (x in 0 until 10 step 3) {

        }

        val names: List<Int> = listOf(3, 2, 3)
        val family = listOf("1", "2", 3)
        val family2 = arrayOf("1", "2", 3)
        val family3 = arrayOf<Int>(1, 2, 3)

        for (bo in names) {
            println(bo)
        }


        mohsen@ for (bo in names) {
            jamali@ for (bo in names) {
                println(bo)
                continue@mohsen   //jump & resume
                break@mohsen
            }
        }

        testi(1, "test")
    }

    fun testi(i: Int, nnn: String): Int {
        print(i)
        return 2
    }

    var meysam = mohsen().sum(str = "2", num1 = 1)


    class mohsen {
        var kian = ""

        fun sum(num1: Int, str: String) {
            print("test")
        }
    }

    //constractor
    var clazz=Test()
    var clazz2=Test(1)
    var clazz3=Test("",1)    //secendery constractor


}