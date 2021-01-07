/* Ler um vetor de números inteiros e imprimir quantos são pares e 
quantos são ímpares. */

function paresEImpares () {
    const vetorInteiros = [15, 7, 4, 22, 44, 57, 89, 71, 30, 99];
    let pares = 0; let impares = 0;
    for (let i = 0; i < vetorInteiros.length; i++) {
        if (vetorInteiros[i] % 2 == 0) {
            pares++;
        } else
            impares++;
    }
    console.log(`Quantidade pares: ${pares}.`)
    console.log(`Quantidade ímpares: ${impares}.`)
}

paresEImpares();