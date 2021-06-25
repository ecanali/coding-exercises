public class Socio {
    private String nome;
    private int idade;
    
    public Socio(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String toString() {
        return "[Nome] " + nome + "\n[Idade] " + idade;
    }
    
    /*
    public static void main(String[] args) {
        Socio socio1 = new Socio("Roberto", 42);
        
        System.out.println(socio1);
    }
    */
}