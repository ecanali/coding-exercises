/* Construa uma função que receba como parâmetros as alturas e as taxas de 
crescimento anuais de duas crianças e calcule se existe uma criança menor, 
caso exista se a criança menor ultrapassará a maior e em quantos anos isso 
acontecerá. Utilize centímetros para as unidades de medida. */

// Se a Criança Maior tem Taxa Maior também == Menor nunca Passará a Maior.
// Se a Menor tem taxa Maior, preciso saber quanto cresce a Maior e Menor
// no mesmo período de 12 meses, pra saber em que mês a Menor passa a Maior.
// Posso fazer um Loop que testa se a menor já está maior a cada mês segundo o
// multiplicador da taxa de crescimento dela.

function calcularCrescimento (altura1, taxaCres1, altura2, taxaCres2) {
    let criancaMaior = 0;
    let taxaCresMaior = 0;
    let criancaMenor = 0;
    let taxaCresMenor = 0;
    let contadorMeses = 0;
    
    if (altura1 < altura2) {
        criancaMaior = altura2;
        taxaCresMaior = taxaCres2;
        criancaMenor = altura1;
        taxaCresMenor = taxaCres1;
    } else if (altura2 < altura1) {
        criancaMaior = altura1;
        taxaCresMaior = taxaCres1;
        criancaMenor = altura2;
        taxaCresMenor = taxaCres2;
    } else {
        console.log("As duas crianças já tem o mesmo tamanho.");
        return false;
    }
    
    if (taxaCresMaior > taxaCresMenor) {
    console.log("A criança maior cresce mais rápido que a menor, ela não vai conseguir passar a maior.");
    return false;
    }

    while (criancaMenor < criancaMaior) {
        criancaMenor += taxaCresMenor;
        criancaMaior += taxaCresMaior;
        contadorMeses++;
    }
    return console.log(contadorMeses);
}

calcularCrescimento(150, 1, 160, 2);
calcularCrescimento(160, 1, 160, 2);
calcularCrescimento(150, 3, 160, 1);
calcularCrescimento(150, 2, 130, 4);