/* Construir um algoritmo que calcule a média aritmética dos valores de 
um vetor de inteiros. */

function mediaVetor (vetor) {
    let soma = 0;
    for (let valor in vetor) {
        soma += vetor[valor];
    }
    return soma / vetor.length;
}

vetor = [1, 2, 3, 4, 5];
console.log(mediaVetor(vetor));