public class Cliente {
    // Atributos
    private String nome;
    private int idade;
    private char sexo;
    private String email;
    private String senha;
    
    // Construtor
    public Cliente(String nome, int idade, char sexo, String email, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
    }
    
    // Métodos de acesso
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
    
    public char getSexo() {
        return sexo;
    }
    
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // Métodos
    public void imprimeInformacoes() {
        System.out.println("Nome: " + nome + " - Idade: " + idade + " - Sexo: " + sexo + " - Email: " + email + " - Senha: ******");
    }
}