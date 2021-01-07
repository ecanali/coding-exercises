/* Crie duas funções que recebem dois parâmetros, um vetor com apenas valores 
numéricos e um número inteiro. Faça com que a primeira função retorne outro 
vetor que será resultado da multiplicação de cada elemento pelo número passado 
como parâmetro. A segunda função fará o mesmo da primeira se e somente se o valor 
do elemento for maior que 5. */

function calcularMult(vetor2Val, multiplicador) {
    let vetorResultado = [];
    vetor2Val.forEach(elemento => {
        vetorResultado.push(elemento * multiplicador)
    });
    return console.log(vetorResultado), calcularMult2(vetorResultado, multiplicador);

    function calcularMult2(vetorResultado, multiplicador) {
        let vetorResultado2 = [];
        if (vetorResultado[0] > 5 || vetorResultado[1] > 5) {
            vetorResultado.forEach(e => {
                vetorResultado2.push(e * multiplicador)
            });
        } else {
            console.log('Lamento mas nenhum elemento é maior que 5.')
            return false;
        }
        return console.log(vetorResultado2);
    }
}
calcularMult([2, 1], 2);
calcularMult([5, 10], 3);
calcularMult([2, 7], 2);