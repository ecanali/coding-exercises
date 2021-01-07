/* Crie um programa para informar quais e quantas notas são necessárias para 
entregar o mínimo de cédulas para um determinado valor informado pelo usuário 
considerando notas de R$ 100, R$ 50, R$ 10 e R$ 5 e R$ 1. Seu programa deve 
mostrar apenas as notas utilizadas. Por exemplo, ao solicitar R$18, o programa 
deve informar apenas a seguinte informação (note que não foram exibidas informações 
sobre as demais cédulas): 1 nota(s) de R$ 10. 1 nota(s) de R$ 5. 3 nota(s) de R$ 1. */

function minimoNotas (valor) {
    let notas100 = 0; notas50 = 0; notas10 = 0; notas5 = 0; notas1 = 0;
    let valorRestante = valor;
    while (valorRestante != 0) {
        if (valorRestante >= 100) {
            notas100++;
            valorRestante -= 100;
        } else if (valorRestante >= 50) {
            notas50++;
            valorRestante -= 50;
        } else if (valorRestante >= 10) {
            notas10++;
            valorRestante -= 10;
        } else if (valorRestante >= 5) {
            notas5++;
            valorRestante -= 5;
        } else if (valorRestante >= 1) {
            notas1++;
            valorRestante -= 1;
        }
    }
    return notasUtilizadas (notas100, notas50, notas10, notas5, notas1);
    // console.log(notas100, notas50, notas10, notas5, notas1);
    // console.log(valorRestante);
}

function notasUtilizadas (notas100, notas50, notas10, notas5, notas1) {
    let resultado = '';
    if (notas100 > 0) {
        resultado += `${notas100} nota(s) de R$100. `;
    }
    if (notas50 > 0) {
        resultado += `${notas50} nota(s) de R$50. `;
    }
    if (notas10 > 0) {
        resultado += `${notas10} nota(s) de R$10. `;
    }
    if (notas5 > 0) {
        resultado += `${notas5} nota(s) de R$5. `;
    }
    if (notas1 > 0) {
        resultado += `${notas1} nota(s) de R$1. `;
    }
    return resultado;
}

console.log(minimoNotas(566));
console.log(minimoNotas(153));
console.log(minimoNotas(18));