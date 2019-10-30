package com.boltChallenge.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("demo")
class AppController {

    @Autowired
    lateinit var inputRepository: InputRepository

    @GetMapping
    fun list(): List<Input> {
        return inputRepository.findAll().toList()
    }

    @PostMapping
    fun add(@RequestBody input:List<Input>):List<String>{

        //inputRepository.deleteAll()
        var opCount:Int
        var entradas = arrayListOf<Input>()
        var resultados:Input = Input(0,"","")

        var resultadosDB = arrayListOf<String>()
        for(i in list()){
            resultadosDB.add(i.entrada)
        }

        for(i in 0 until input.size) {
            opCount = 0

            if(resultadosDB.contains(input[i].entrada)){

                entradas.add(list().get(resultadosDB.indexOf(input[i].entrada)))

            }else{

                if (input[i].entrada.length % 2 == 0) {
                    for (j in 0 until input[i].entrada.length step 2) {

                        if (input[i].entrada.get(j).equals('{') && input[i].entrada.get(j + 1).equals('{')) {
                            opCount += 1
                        }
                        if (input[i].entrada.get(j).equals('}') && input[i].entrada.get(j + 1).equals('}')) {
                            opCount += 1
                        }
                        if (input[i].entrada.get(j).equals('}') && input[i].entrada.get(j + 1).equals('{')) {
                            opCount += 2
                        }

                    }

                    input[i].setEntradas(input[i].entrada)
                    input[i].setResultados(opCount.toString())
                    inputRepository.save(input[i])
                    entradas.add(input[i])
                } else {
                    input[i].setEntradas(input[i].entrada)
                    input[i].setResultados("não pode ser estável")
                    inputRepository.save(input[i])
                    entradas.add(input[i])
                }
            }

        }

        return resultados.getResultados(entradas)

    }

}