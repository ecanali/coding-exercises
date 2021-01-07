/* Criar uma função para calcular o valor a ser pago de anuidade de uma associação. 
A função recebe como parâmetro um inteiro que representa o mês (1 - janeiro, 
2 - fevereiro...) que foi paga e o valor da anuidade. A anuidade deve ser paga no 
mês de janeiro. Por mês, é cobrado 5% de juros (sob o regime de juros compostos). 
O retorno deve ser o valor a ser pago para o respectivo mês escolhido. */

function valorAtualizadoAnuidade (mesPag, valorAnuidade) {
    if (mesPag > 0 && mesPag < 13) {
        mesesAtraso = mesPag - 1;
        return (valorAnuidade * ((1 + 0.05) ** mesesAtraso)).toFixed(2);
    } else
        return 'Mês inválido.';
}

console.log(valorAtualizadoAnuidade(4, 100));
console.log(valorAtualizadoAnuidade(8, 100));
console.log(valorAtualizadoAnuidade(13, 100));
console.log(valorAtualizadoAnuidade(12, 100));