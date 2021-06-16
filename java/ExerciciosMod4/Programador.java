public class Programador extends Pessoa {
    private String linguagemPreferida;
    
    public Programador() {
        super();
    }
    
    public Programador(String nome, int idade, String linguagemPreferida) {
        super(nome, idade);
        this.linguagemPreferida = linguagemPreferida;
    }
    
    public String getLinguagemPreferida() {
        return linguagemPreferida;
    }
    
    public void setLinguagemPreferida(String linguagemPreferida) {
        this.linguagemPreferida = linguagemPreferida;
    }
    
    public void imprimeDados() {
        System.out.println("[Nome] " + super.getNome() + "\n[Idade] " + super.getIdade() + "\n[Linguagem preferida] " + linguagemPreferida);
    }
}