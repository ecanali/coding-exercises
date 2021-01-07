/* 03)​ Crie uma função que recebe dois parâmetros, base e expoente, 
* e retorne a base elevada ao expoente. */


// potenciacao com função usando outra função específica (Math.pow())
function potenciacao1(base, expoente) {
    let potencia = Math.pow(base, expoente)
    return console.log(potencia)
}

potenciacao1(7, 2)

// potenciacao com função em uma linha usando operador "**"
let potenciacao2 = (base, expoente) => console.log(base ** expoente)

potenciacao2(2, 3)