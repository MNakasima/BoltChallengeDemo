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
    fun add(@RequestBody input:List<Input>):List<Input>{

        inputRepository.deleteAll()
        var opCount:Int
        var inputs = arrayListOf<Input>()

        for(i in 0 until input.size){
            opCount = 0

            if(input[i].str.length % 2 == 0){
                for(j in 0 until input[i].str.length step 2){

                    if( input[i].str.get(j).equals('{') && input[i].str.get(j+1).equals('{') ) {
                        opCount+= 1
                    }
                    if( input[i].str.get(j).equals('}') && input[i].str.get(j+1).equals('}') ) {
                        opCount+= 1
                    }
                    if( input[i].str.get(j).equals('}') && input[i].str.get(j+1).equals('{') ) {
                        opCount+= 2
                    }

                }
            }else{
                input[i].changeStr("não pode ser estável, número Ímpar de entrada")
                inputRepository.save(input[i])
                inputs.add(input[i])
            }
            input[i].changeStr(opCount.toString())
            inputRepository.save(input[i])
            inputs.add(input[i])
        }

        return inputs

    }

}