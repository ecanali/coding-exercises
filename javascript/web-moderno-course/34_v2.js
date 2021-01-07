/* Construa uma função que receberá duas Strings de tamanhos variados e que 
retornará True ou False caso todos os caracteres (independentemente de ser 
maiúsculo ou minúsculo) estejam contidos em ambas palavras. */

// PROBLEMA: mesmo faltando 1 caracter em 1 dos parâmetros ele retorna True.
// Testar: elemento1 da string1 contém na string2? elemento2... elemento3...

/*for (let i = 0; i < charString1.length; i++) {
    (if charString1[i].includes(charString2)) {
        contido = true;
    } else
        return contido = false;
} */


function isContido (string1, string2) {
    var contido = true;
    var charString1 = '';
    var charString2 = '';

    for (let a = 0; a < string1.length; a++) {
        charString1 = [string1.charAt(a).toLowerCase()];
        for (let char2 in string2) {
            charString2 = string2.toLowerCase();
            for (let i = 0; i < charString1.length; i++) {
                if (charString1[i].includes(charString2))
                    contido = true;
                else
                    return contido = false;
                for (let j = 0; j < charString2.length; j++) {
                    if (charString2[j].includes(charString1))
                        contido = true;
                    else
                        return contido = false;
                }
            }
        }
    }
}
console.log(isContido('abc', 'abc'));
console.log(charString1);
console.log(charString2);
console.log(isContido('abcEFhg', 'cBaDeFGh'));