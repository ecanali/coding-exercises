/* 02)​ Os triângulos podem ser classificados em 3 tipos quanto ao tamanho de 
* seus lados: Equilátero: Os três lados são iguais. Isósceles: Dois lados iguais.
* Escaleno: Todos os lados são diferentes. Crie uma função que recebe os 
* comprimentos dos três lados de um triângulo e retorne sua classificação quanto
* ao tamanho de seus lados. (Neste exemplo deve-se abstrair as condições 
* matemáticas de existência de um triângulo). */

// Equilátero = 3 lados iguais
// Isósceles = 2 lados iguais + 1 diferente
// Escaleno = 3 lados diferentes

function classificacaoTriangulo (lado1, lado2, lado3) {
    let tipoTriangulo = null
    if (lado1 === lado2 && lado2 === lado3) {
        tipoTriangulo = 'Equilátero'
    } else if (lado1 === lado2 || lado1 !== lado3 || lado2 === lado3) {
        tipoTriangulo = 'Isósceles'
    } else {
        tipoTriangulo = 'Escaleno'
    }
    return console.log(`Este é um triângulo ${tipoTriangulo}.`)
}

classificacaoTriangulo(5, 5, 5)
classificacaoTriangulo(5, 4, 5)
classificacaoTriangulo(3, 4, 5)