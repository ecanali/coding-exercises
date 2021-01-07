/* 04) ​Crie uma função que irá receber dois valores, o dividendo e o divisor.
* A função deverá imprimir o resultado e o resto da divisão destes dois valores.*/

function divisao(dividendo, divisor) {
    let resultado = dividendo / divisor
    let resto = dividendo % divisor
    return console.log(`Resultado é ${(resultado).toFixed(2)} e o resto é ${resto}.`)
}

divisao(10, 3)
divisao(50, 5)
divisao(347, 5)
divisao(11, 4)