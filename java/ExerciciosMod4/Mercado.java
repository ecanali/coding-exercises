public class Mercado {
    private Prateleira prateleira1, prateleira2;
    
    public Mercado(Prateleira prateleira1, Prateleira prateleira2) {
        this.prateleira1 = prateleira1;
        this.prateleira2 = prateleira2;
    }
    
    public Prateleira getPrateleira1() {
        return prateleira1;
    }
    
    public Prateleira getPrateleira2() {
        return prateleira2;
    }
    
    public double mediaValorProdutos() {
        double soma = 0.0;
        int contador = 0;
        if (prateleira1.getProduto1() != null) {
            soma += prateleira1.getProduto1().getPreco();
            contador++;
        }
        if (prateleira1.getProduto2() != null) {
            soma += prateleira1.getProduto2().getPreco();
            contador++;
        }
        if (prateleira1.getProduto3() != null) {
            soma += prateleira1.getProduto3().getPreco();
            contador++;
        }
        if (prateleira2.getProduto1() != null) {
            soma += prateleira2.getProduto1().getPreco();
            contador++;
        }
        if (prateleira2.getProduto2() != null) {
            soma += prateleira2.getProduto2().getPreco();
            contador++;
        }
        if (prateleira2.getProduto3() != null) {
            soma += prateleira2.getProduto3().getPreco();
            contador++;
        }
        
        if (contador != 0)
            return soma / contador;
            
        return 0;
    }
}