/* 01) Crie uma função que dado dois valores 
* (passados como parâmetros) 
* mostre no console a soma, subtração,
* multiplicação e divisão desses valores. */

// Declaração de função normal
function operacoes(a, b) {
    console.log(a + b, a - b, a * b, a / b)
}

operacoes(5, 5)

// Declaração de função com firula na impressão
function operacoes2(c, d) {
    console.log(`Soma é ${c + d}.`, `Sub é ${c - d}.`, `Mult é ${c * d}.`, `Div é ${c / d}.`)
}

operacoes2(7, 7)

// Declaração de função anônima abstraindo o máximo
const operacoes3 = (e, f) => console.log(e + f, e - f, e * f, e / f)

operacoes3(10, 10)