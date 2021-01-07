// Todo aluno recebe nota de 0 - 100
// Nota <40 = reprovação ( === 40 aprova)
// --> Regras arredondamento:
// "Se" diferença entre Nota e próximo multiplo de 5 for <3, ou seja, 2 ou 1 =
// arredonda nota para próximo múltiplo de 5
// <38 ñ arredonda = reprova (arredondamento inicia em 38)
// 84 arredonda p/ 85

function classificadorNotas (notaAluno) {
    let notaArredondada = arredondadorNota(notaAluno);
    if (notaArredondada >= 40) {
        console.log(`Parabéns! Você foi aprovado com a nota ${notaArredondada}.`);
    } else {
        console.log(`Que pena! Você foi reprovado com a nota ${notaArredondada}.`);
    }
}

function arredondadorNota (notaAluno) {
    if (notaAluno % 5 > 2) {
        return notaAluno + (5 - (notaAluno % 5));
    } else {
        return notaAluno;
    }
}

classificadorNotas(100);
classificadorNotas(30);
classificadorNotas(38);
classificadorNotas(88);
classificadorNotas(61);