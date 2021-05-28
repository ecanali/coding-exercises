public class Pessoa {
    // Atributos
    private String nome;
    private int idade;
    private char sexo;
    
    // Método Construtor
    public Pessoa(String n, int i, char s) {
        nome = n;
        idade = i;
        sexo = s;
    }
    
    // Método de Acesso
    public String getNome() {
        return nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public char getSexo() {
        return sexo;
    }
    
    public void setNome(String novoNome) {
        nome = novoNome;
    }
    
    public void setIdade(int novaIdade) {
        idade = novaIdade;
    }
    
    public void setSexo(char novoSexo) {
        sexo = novoSexo;
    }
}