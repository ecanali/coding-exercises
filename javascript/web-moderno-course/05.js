/* Desenvolva uma função JavaScript para que ela receba um valor 
* como 0.30000000000000004 e retorne R$0,30 (observe a vírgula e o ponto). */

function somaDecimal(valor1, valor2) {
    const soma = valor1 + valor2
    return console.log(`R$${soma.toFixed(2).replace('.', ',')}.`)
}

somaDecimal(0.1, 0.2)

// Função de uma linha com Arrow
const somaDecimal2 = (valor1, valor2) => console.log(`R$${(valor1 + valor2).toFixed(2).replace('.', ',')}.`)

somaDecimal2(0.1, 0.2)