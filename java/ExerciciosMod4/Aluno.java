public class Aluno extends Pessoa {
    private double nota;
    
    public Aluno() {
        super();
    }
    
    public Aluno(String nome, int idade, double nota) {
        super(nome, idade);
        this.nota = nota;
    }
    
    public double getNota() {
        return nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public void imprimeDados() {
        System.out.println("[Nome] " + super.getNome() + "\n[Idade] " + super.getIdade() + "\n[Nota] " + nota);
    }
}