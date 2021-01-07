/* 06)​ Elabore duas funções que recebem três parâmetros: capital inicial, 
* taxa de juros e tempo de aplicação. A primeira função retornará o montante da
* aplicação financeira sob o regime de juros simples e a segunda retornará o 
* valor da aplicação sob o regime de juros compostos. */

function emJuroSimples (capitalInicial, taxaJuros, tempoAplicacao) {
    const aplicacao = capitalInicial + (capitalInicial * taxaJuros * tempoAplicacao)
    return console.log(`O montante da aplicação em Juros Simples é ${aplicacao}.`)
}

emJuroSimples(100, 0.1, 12)

function emJuroComposto (capitalInicial, taxaJuros, tempoAplicacao) {
    const aplicacao = capitalInicial * (1 + taxaJuros) ** tempoAplicacao  
    return console.log(`O montante da aplicação em Juros Composto é ${Math.ceil(aplicacao).toFixed(2)}.`)
}

emJuroComposto(100, 0.1, 12)