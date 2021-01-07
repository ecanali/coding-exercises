/* Crie três vetores, chamados vetorInteiro, vetorString e vetorDouble. 
Cada um destes vetores deverá conter quatro valores, sendo o primeiro com 
valores inteiros, o segundo com strings e o terceiro com valores decimais. 
Declarados os vetores, utilize a função de união concat() de duas maneiras 
diferentes para unir os vetores, e mostre o resultado no console. Todos os 
elementos do vetor resultado deverão aparecer no console. */

let vetorInteiro = [9, 22, -15, 0];
let vetorString = ['Ola', 'Oi', 'Hello', 'Hi'];
let vetorDouble = [9.2, 22.85, -15.04, 0.1];

vetorResultado1 = vetorInteiro.concat(vetorString);
vetorResultado2 = vetorString.concat(vetorDouble).concat(vetorInteiro);

console.log(vetorResultado1);
console.log(vetorResultado2);