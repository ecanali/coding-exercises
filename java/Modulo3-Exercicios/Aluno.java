public class Aluno {
    private String nome;
    private int matricula;
    private double notaGrauA;
    private double notaGrauB;
    
    public Aluno(String nome, int matricula, double notaGrauA, double notaGrauB) {
        this.nome = nome;
        this.matricula = matricula;
        this.notaGrauA = notaGrauA;
        this.notaGrauB = notaGrauB;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getMatricula() {
        return matricula;
    }
    
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public double getNotaGrauA() {
        return notaGrauA;
    }
    
    public void setNotaGrauA(double notaGrauA) {
        this.notaGrauA = notaGrauA;
    }
    
    public double getNotaGrauB() {
        return notaGrauB;
    }
    
    public void setNotaGrauB(double notaGrauB) {
        this.notaGrauB = notaGrauB;
    }
    
    public double calculaMediaFinal() {
        return (notaGrauA * 0.33) + (notaGrauB * 0.67);
    }
    
    public void imprimeInfo() {
        System.out.println("Nome: " + nome + " - Matrícula: " + matricula);
        System.out.println("Nota do Grau A: " + notaGrauA + " - Nota do Grau B: " + notaGrauB);
        System.out.println("Média final: " + String.format("%.2f", calculaMediaFinal()));
    }
}