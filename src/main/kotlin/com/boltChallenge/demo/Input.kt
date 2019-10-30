package com.boltChallenge.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Input(@Id
            @GeneratedValue
            val id: Long = 0,
            var entrada:String = "",
            var resultado:String = ""){

    fun setResultados (resultado:String){
        this.resultado = resultado
    }

    fun setEntradas (entrada:String){
        this.entrada = entrada
    }

    fun getResultados(entradas:List<Input>):List<String>{

        var resultados = arrayListOf<String>()

        for(r in entradas){
            resultados.add(r.resultado)
        }

        return resultados
    }

}