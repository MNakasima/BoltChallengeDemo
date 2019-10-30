package com.boltChallenge.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Input(@Id
            @GeneratedValue
            val id: Long = 0,
            var str:String = "",
            var result:String = ""){

    fun changeStr (str:String){
        this.str = str
    }

    fun changeResult (result:String){
        this.result = result
    }

    fun returnStrs(inputs:List<Input>):List<String>{

        var strs = arrayListOf<String>()

        for(input in inputs){
            strs.add(input.str)
        }

        return strs

    }

}