public class Pessoa {
    // Atributos
    private String nome;
    private char sexo;
    private int idade;
    private double altura;
    private int quantidadeIrmaos;
    private String endereco;
    
    // Construtor
    public Pessoa(String nome, char sexo, int idade, double altura, int quantidadeIrmaos, String endereco) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.altura = altura;
        this.quantidadeIrmaos = quantidadeIrmaos;
        this.endereco = endereco;
    }
    
    // Métodos de acesso
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public char getSexo() {
        return sexo;
    }
    
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int getQuantidadeIrmaos() {
        return quantidadeIrmaos;
    }
    
    public void setQuantidadeIrmaos(int quantidadeIrmaos) {
        this.quantidadeIrmaos = quantidadeIrmaos;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    // Métodos
    public void imprimeInformacoes() {
        System.out.println("Nome: " + nome + " - Sexo: " + sexo + " - Idade: " + idade + " - Altura: " + altura + " - Quantidade de irmãos: " + quantidadeIrmaos + " - Endereço: " + endereco);
    }
    
    public boolean isFilhoUnico() {
        if (quantidadeIrmaos == 0)
            return true;
        else
            return false;
    }
}