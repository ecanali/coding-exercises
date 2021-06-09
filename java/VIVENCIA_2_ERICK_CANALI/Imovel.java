public class Imovel {
    public static void main(String[] args) {
        Imovel meuImovel = new Imovel("Rua dos Pampas, 97 - Porto Alegre/RS", 230000, 1800, false);
        
        System.out.println(meuImovel);
        
        System.out.println("O valor do imposto do imóvel é: " + meuImovel.calculaImposto());
    }
    
    private String endereco;
    private double valorVenda, valorAluguel;
    private boolean novo;
    
    public Imovel(String endereco, double valorVenda, double valorAluguel, boolean novo) {
        this.endereco = endereco;
        this.valorVenda = valorVenda;
        this.valorAluguel = valorAluguel;
        this.novo = novo;
    }
    
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
    
    public String toString() {
        String texto = "[Endereço] " + endereco;
        texto += "\n[Valor de venda] " + valorVenda;
        texto += "\n[Valor de aluguel] " + valorAluguel;
        texto += "\n[Novo] " + novo;
        return texto;
    }
    
    public double calculaImposto() {
        return novo ? (valorVenda * 0.15) : (valorAluguel * 0.10);      
    }
}