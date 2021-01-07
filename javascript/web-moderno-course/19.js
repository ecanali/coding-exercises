/* Implemente uma função que receba como parâmetros o código do item pedido, a 
quantidade e calcule o valor a ser pago por aquele lanche. Considere que a cada 
execução somente será calculado um item. Use o comando switch. Crie um caso 
default para produto não existente. */

function custoLanche (cod, quant) {
    switch (cod) {
        case 100:
            console.log(3 * quant);
            break;
        case 200:
            console.log(4 * quant);
            break;
        case 300:
            console.log(5.50 * quant);
            break;
        case 400:
            console.log(2.50 * quant);
            break;
        case 500:
            console.log(3.50 * quant);
            break;
        case 600:
            console.log(2.80 * quant);
            break;
        default:
            console.log('Produto não existente.');
    }
}

custoLanche(100, 2);
custoLanche(200, 2);
custoLanche(300, 2);
custoLanche(400, 2);
custoLanche(500, 2);
custoLanche(600, 2);
custoLanche(700, 2);