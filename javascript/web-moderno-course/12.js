/* Faça um algoritmo que calcule o fatorial de um número. */

function fatorial (numero) {
    return (numero != 1) ? numero * fatorial(numero - 1) : 1;
}

console.log(fatorial(5))
console.log(fatorial(10))