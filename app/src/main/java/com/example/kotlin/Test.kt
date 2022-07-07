package com.example.kotlin

import java.util.*

class Test(id: Int = 3) : kian() {


    private var test: String = ""

    init {
        print(jamali)   //extented class fun
    }

    constructor(test: String, id: Int) : this(id) {
        this.test = test
    }


    fun crachNull() {
        val family: String? = null

        print(family?.length)   // without crash
        print(family!!.length) //with crash
    }


    fun treeemap() {
        val citis = TreeMap<String, Int>()

        citis["tehran"] = 1
        citis["esfahan"] = 2
        citis["shiraz"] = 3
        citis["mashad"] = 4

        print(citis["esfahan"])

        for ((key, value) in citis) {
            print(key + " " + value)
        }
    }

    fun exception() {
        try {

        } catch (e: Exception) {

        }
    }
}