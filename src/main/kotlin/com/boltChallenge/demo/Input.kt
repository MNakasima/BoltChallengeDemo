package com.boltChallenge.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Input(@Id
            @GeneratedValue
            val id: Long = 0,
            var str:String = ""){

    fun changeStr (str:String){
        this.str = str
    }

}