public class PrincipalAluno {
    public static void main(String[] args) {
       Aluno aluno1 = new Aluno("Brandamente Brasil", 1585248, 5, 9);
       Aluno aluno2 = new Aluno("Radigunda Cercená", 2254879, 8, 2);
       Aluno aluno3 = new Aluno("Vitimado José Araújo", 8599, 7, 1);

       aluno1.imprimeInfo();
       aluno2.imprimeInfo();
       aluno3.imprimeInfo();
       
       aluno2.setNotaGrauA(9);
       System.out.println("A nova média final de Radigunda é: " + String.format("%.2f", aluno2.calculaMediaFinal()));
       System.out.println("A matrícula de Vitimado é: " + aluno3.getMatricula());
       aluno1.setMatricula(1585228);
       System.out.println("A nova matrícula de Brandamente é: " + aluno1.getMatricula());
    }
}
