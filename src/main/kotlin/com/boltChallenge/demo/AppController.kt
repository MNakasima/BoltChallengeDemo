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
    fun add(@RequestBody input:Input): Input {

        inputRepository.deleteAll()
        return inputRepository.save(input)

    }

}