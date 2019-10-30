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

    fun changeResultado (resultado:String){
        this.resultado = resultado
    }

    fun changeEntrada (entrada:String){
        this.entrada = entrada
    }

    fun returnResultados(entradas:List<Input>):List<String>{

        var resultados = arrayListOf<String>()

        for(entrada in entradas){
            resultados.add(entrada.resultado)
        }

        return resultados

    }

}