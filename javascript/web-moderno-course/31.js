/* ​Escrever um algoritmo que percorre um vetor de inteiros, conta quantos 
números negativos há nesse vetor e imprime a quantidade no console. */

function contarNegativos (vetor) {
    let inteirosNegativos = 0;
    for (let i = 0; i < vetor.length; i++) {
        if (vetor[i] < 0)
            inteirosNegativos++;
    }
    console.log(inteirosNegativos);
}

vetor = [10, 5, -7, 3, -1, 3, -11, -20, 6, 9];
contarNegativos(vetor);