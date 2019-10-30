# BoltChallengeDemo
Bolt Challenge

Dada uma sequência de caracteres que somente contém abre chaves, "{", fecha chaves, "}". Sua tarefa é achar o número mínimo de operações necessárias para que essa sequência seja estável.

A definição de sequência estável é a seguinte:

A sequência vazia é estável;
Se S é estável, então {S} também estável;
Se S e T são estáveis, então a concatenação ST também é estável.
A) Escreva um serviço REST em Java ou em Kotlin com o Spring Boot que receba como entrada uma lista dessas strings através de POST request e retorne o número de operações necessárias para a sequência .

Exemplo: 

Entrada: 
{
['}{', '{}{}', '{{{}']
}

Saída:{ [2, 0, 1] }

B) Incremente seu serviço REST com um banco de dados que salve as respostas conhecidas. Na consulta também deverá primeiro consultar o banco de dados antes de processar a solução do problema
