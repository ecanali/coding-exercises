public class Imovel {
    // Atributos globais
    private String endereco;
    private double valorVenda, valorAluguel;
    private boolean novo;
    
    // Método construtor
    public Imovel(String endereco, double valorVenda, double valorAluguel, boolean novo) {
        this.endereco = endereco;
        this.valorVenda = valorVenda;
        this.valorAluguel = valorAluguel;
        this.novo = novo;
    }
    
    // Métodos de acesso
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public double getValorVenda() {
        return valorVenda;
    }
    
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    public double getValorAluguel() {
        return valorAluguel;
    }
    
    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }
    
    public boolean isNovo() {
        return novo;
    }
    
    public void setNovo(boolean novo) {
        this.novo = novo;
    }
    
    // Informa sobre atuais atributos do imóvel
    public String toString() {
        String texto = "[Endereço] " + endereco;
        texto += "\n[Valor de venda] " + valorVenda;
        texto += "\n[Valor de aluguel] " + valorAluguel;
        texto += "\n[Novo] " + ((novo) ? "Sim" : "Não");
        return texto;
    }
    
    // Retorna cálculo do imposto correto caso imóvel novo ou usado
    public double calculaImposto() {
        return novo ? (valorVenda * 0.15) : (valorAluguel * 0.10);      
    }
}