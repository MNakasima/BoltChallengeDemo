package com.boltChallenge.demo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("demo")
class AppController{

    @GetMapping
    fun list():List<Input>{
        return listOf(Input("}{"),
                Input("{}"))
    }

    @PostMapping
    fun add(@RequestBody input: Input):Input{
        return input
    }

}