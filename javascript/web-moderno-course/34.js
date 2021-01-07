/* Construa uma função que receberá duas Strings de tamanhos variados e que 
retornará True ou False caso todos os caracteres (independentemente de ser 
maiúsculo ou minúsculo) estejam contidos em ambas palavras. */

function isContido (string1, string2) {
    let contido = true;
    for (let char1 in string1) {
        let charString1 = string1.charAt(char1).toLowerCase();
        console.log(charString1);
        for (let char2 in string2) {
            let charString2 = string2.charAt(char2).toLowerCase();
            console.log(charString2);
            if (charString1 == charString2) {
                contido = true;
                break;
            } else {
                contido = false;
            }
        }
        if (!contido) {
            return contido;
        }
    }
    return contido;
}

console.log(isContido('abcEFhg', 'cBaDeFGh'));