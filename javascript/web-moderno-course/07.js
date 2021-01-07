/* Elabore uma função cujo objetivo é resolver a fórmula de Bhaskara. 
* Para isso, sua função deve receber três parâmetros, “ax2”, “bx” e “c”, 
* de tal modo que na equação: 3x2 - 5x + 12 os valores seriam 
* respectivamente: 3, -5, 12. Como retorno deve ser passado um vetor
* que tem 2 valores um para cada possível resultado, mesmo que os resultados
* sejam iguais. Caso o delta seja negativo, retorne, ao invés do vetor,
* um string com a frase: “Delta é negativo”. */

function resolverFormulaBhaskara(ax2, bx, c) {
    let delta = bx ** 2 - 4 * (ax2 * c)
    let x_linha = (-bx + Math.sqrt(delta)) / 2 * ax2
    let x_2linhas = (-bx - Math.sqrt(delta)) / 2 * ax2
    let resultados = [x_linha, x_2linhas]

    if (delta < 0) {
        console.log(resultados = 'Delta é negativo.')
    } else {
        console.log(resultados)
    }
}

resolverFormulaBhaskara(1, 12, -13)
resolverFormulaBhaskara(1, 3, 2)
resolverFormulaBhaskara(3, 1, 2)