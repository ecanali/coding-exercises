/* 10) ​Crie uma função que verifica se um número inteiro passado como 
parêmetro é divisível por 3 e retorne true ou false. */

// Versão longa
function isDivisivelPor3 (inteiro){
    if (inteiro % 3 == 0) {
        return true;
    } else {
        return false;
    }
}

// Versão curta
const isDivisivelPor3_v2 = inteiro => inteiro % 3 == 0;

console.log(isDivisivelPor3(3));
console.log(isDivisivelPor3(2));
console.log(isDivisivelPor3(150));
console.log(isDivisivelPor3_v2(3));
console.log(isDivisivelPor3_v2(2));
console.log(isDivisivelPor3_v2(150));