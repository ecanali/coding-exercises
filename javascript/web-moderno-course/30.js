/* Escreva um algoritmo que percorre um vetor de inteiros e defina o maior e 
menor valor dentro do vetor. */

function maiorEMenor (vetor) {
    vetor = [10, 5, 7, 3, 1, 3, 11, 20, 6, 9];
    let maior = vetor[0];
    let menor = vetor[0];
    for (let i = 0; i < vetor.length; i++) {
        if (vetor[i] < menor)
            menor = vetor[i];
        else if (vetor[i] > maior)
            maior = vetor[i];
    }
    console.log(`Maior: ${maior} | Menor: ${menor}`)
}

maiorEMenor();