public class Servico {
    private String descricao;
    private double preco;
    
    public Servico() {
        descricao = "Não informado";
        preco = 0.0;
    }
    
    public Servico(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String toString() {
        return descricao + " | Preço: " + preco;
    }
    
    /*
    public static void main(String[] args) {
        System.out.println(new Servico());
        System.out.println(new Servico("Lavagem de carros", 45.90));
    }
    */
}