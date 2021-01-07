/* Escreva um algoritmo que leia o código de um aluno e suas três notas. 
Calcule a média ponderada do aluno, considerando que o peso para a maior nota 
seja 4 e para as duas restantes, 3. Mostre o código do aluno, suas três notas, 
a média calculada e uma mensagem "APROVADO" se a média for maior ou igual a 5 e 
"REPROVADO" se a média for menor que 5. Repita a operação até que o código lido 
seja negativo. */

function notaFinal (codAluno, nota1, nota2, nota3) {
    var notas = [nota1, nota2, nota3];
    notas.sort((a, b) => a < b ? 1 : -1);

    let mediaFinal = (notas[0] * 3 + notas[1] * 3 + notas[2] * 4)/10;
    console.log(`Código do Aluno: ${codAluno}. Notas: ${nota1}, ${nota2} e ${nota3}. Média Ponderada: ${mediaFinal}. Status: ${mediaFinal < 5 ? 'Reprovado' : 'Aprovado'}.`)
}

notaFinal(345, 5, 4.5, 6);
notaFinal(123, 2.8, 6, 3.5);