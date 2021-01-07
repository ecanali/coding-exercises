/* Crie um programa que exibe se um dia é dia útil, fim de semana ou dia inválido
 dado o número referente ao dia. Considere que domingo é o dia 1 e sábado é o dia 7. */

function infoDia(dia) {
    switch (dia) {
        case 1:
            return "Fim de Semana";
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
            return "Dia útil";
        case 7:
            return "Fim de Semana";
        default:
            return "Dia inválido";
    }
}

console.log(infoDia('dia'));
console.log(infoDia(1));
console.log(infoDia(2));
console.log(infoDia(3));
console.log(infoDia(4));
console.log(infoDia(5));
console.log(infoDia(6));
console.log(infoDia(7));