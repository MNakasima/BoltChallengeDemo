package com.boltChallenge.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Input(@Id
            @GeneratedValue
            val id: Long = 0,
            val str:String = ""){

}