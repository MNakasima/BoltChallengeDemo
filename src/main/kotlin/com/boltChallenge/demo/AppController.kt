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
        return inputRepository.findAll().toList() //retorna todos os inputs e seus respectivos resultados na base de dados
    }

    @PostMapping
    fun add(@RequestBody input:List<Input>):List<String>{

        var opCount:Int
        var entradas = arrayListOf<Input>()
        var resultados:Input = Input(0,"","")
        var resultadosDB = arrayListOf<String>()

        /* Guarda apenas o atributo 'entrada' na variavel resultadosDB */
        for(i in list()){
            resultadosDB.add(i.entrada)
        }

        /*Pega cada valor passado pelo POST request*/
        for(i in 0 until input.size) {
            opCount = 0

            /*Verifica se o valor passado pelo POST request ja existe no banco,
            se sim, apenas adiciona o resultado ja computado na lista final a ser exibida na saida desse metodo*/
            if(resultadosDB.contains(input[i].entrada)){

                entradas.add(list().get(resultadosDB.indexOf(input[i].entrada)))

            }else{

                /*Verifica se o tamanho da entrada é par*/
                if (input[i].entrada.length % 2 == 0) {

                    /*Percorrer cada String de cada requisicao POST, incremental por 2 pois a verificacao foi feita em pares*/
                    for (j in 0 until input[i].entrada.length step 2) {

                        /*sequencia { {, e necessario 1 operacao para ficar estavel. { { -> { } */
                        if (input[i].entrada.get(j).equals('{') && input[i].entrada.get(j + 1).equals('{')) {
                            opCount += 1
                        }
                        /*sequencia } }, e necessario 1 operacao para ficar estavel. } } -> { } */
                        if (input[i].entrada.get(j).equals('}') && input[i].entrada.get(j + 1).equals('}')) {
                            opCount += 1
                        }
                        /*sequencia } {, e necessario 2 operacoes para ficar estavel. } { -> } } -> { } */
                        if (input[i].entrada.get(j).equals('}') && input[i].entrada.get(j + 1).equals('{')) {
                            opCount += 2
                        }

                    }

                    input[i].setEntradas(input[i].entrada) //Seta o atributo 'entrada' igual a entrada passado por POST
                    input[i].setResultados(opCount.toString()) //Seta o atributo 'resultado' igual o numero de operacoes feitas para se tornar um operacao estavel
                    inputRepository.save(input[i]) //salva no db local
                    entradas.add(input[i]) // guarda os resultados
                } else {
                    input[i].setEntradas(input[i].entrada) //Seta o atributo 'entrada' igual a entrada passado por POST
                    input[i].setResultados("não pode ser estável") //Seta o atributo 'resultado' igual o numero de operacoes feitas para se tornar um operacao estavel
                    inputRepository.save(input[i]) //salva no db local
                    entradas.add(input[i]) // guarda os resultados
                }
            }

        }

        /*Exibe a saida apenas com o numero de operacoes minima necessaria para a entrada ser estavel
        (respectivamente com os valores passado por POST)*/
        return resultados.getResultados(entradas)

    }

}