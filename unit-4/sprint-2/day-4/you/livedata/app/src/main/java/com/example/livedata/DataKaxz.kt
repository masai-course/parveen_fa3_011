package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataKaxz {


    var frag1ct=0
    var frag2ct=0

    private val frag1live=MutableLiveData<String>()
    private val frag2live=MutableLiveData<String>()

    fun frag1get(){
        frag1ct++
        frag1live.value="frag1 count $frag1ct"
    }
    fun frag2get(){
        frag2ct++
        frag2live.value="frag2 count $frag2ct"
    }




    fun fraf1data():LiveData<String>{
        return frag1live
    }

    fun fraf2data():LiveData<String>{
        return frag2live
    }
}