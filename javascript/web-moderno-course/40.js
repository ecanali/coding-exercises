/* ​Faça uma função que receba como parâmetro um vetor de notas e mostre os 
conceitos de cada uma de modo que de 0,0 a 4,9 seja atribuído o conceito D, 
de 5,0 a 6,9 seja atribuído o conceito C, de 7,0 a 8,9 o conceito B e de 9,0 
a 10,0 o conceito A. */

function conceitoNotas (vetorNotas) {
    for (let i = 0; i < vetorNotas.length; i++) {
        if (vetorNotas[i] >= 0 && vetorNotas[i] <= 4.9) {
            console.log(`Nota: ${vetorNotas[i]} | Conceito: D`);
        } else if (vetorNotas[i] >= 5.0 && vetorNotas[i] <= 6.9) {
            console.log(`Nota: ${vetorNotas[i]} | Conceito: C`);
        } else if (vetorNotas[i] >= 7.0 && vetorNotas[i] <= 8.9) {
            console.log(`Nota: ${vetorNotas[i]} | Conceito: B`);
        } else if (vetorNotas[i] >= 9.0 && vetorNotas[i] <= 10.0) {
            console.log(`Nota: ${vetorNotas[i]} | Conceito: A`);
        } else
            console.log(`Nota: ${vetorNotas[i]} é inválida`);
    }
}

conceitoNotas([7.3, 3.9, 6, 9.2, 6.7]);
conceitoNotas([10, 13, 9, 8.2, 2.5, 7.7, 6.8]);