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
        return descricao + " | Preço: R$" + String.format("%.2f", preco);
    }
}