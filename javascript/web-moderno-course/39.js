/* Crie uma função que receba dois vetores de igual tamanho e troque seus 
elementos de modo que o primeiro elemento do vetorA passe a ser o primeiro 
elemento do vetorB e vice versa e assim sucessivamente. Faça a troca sem 
utilizar uma variável auxiliar. */

function trocarVetores (vetorA, vetorB) {
    if (vetorA.length == vetorB.length) {
        for (let i = 0; i < vetorA.length; i++) {
        vetorA[i] = vetorA[i] + vetorB[i];
        vetorB[i] = vetorA[i] - vetorB[i];
        vetorA[i] = vetorA[i] - vetorB[i];
        }
    } else
        return false;    
    console.log(`Vetor A trocado: ${vetorA}`);
    console.log(`Vetor B trocado: ${vetorB}`);
}

vetorA = [1, 2, 3, 4, 5];
vetorB = [6, 7, 8, 9, 10];
trocarVetores(vetorA, vetorB);