public class Mercado {
    /*public static void main(String[] args) {
        Data data1 = new Data(15, 06, 2021);
        Data data2 = new Data(14, 06, 2021);
        Data data3 = new Data(16, 06, 2021);
        
        Produto produto1 = new Produto("Leite", 25.79, data1);
        Produto produto2 = new Produto("Pão", 29.50, data2);
        Produto produto3 = new Produto("Queijo", 22.35, data3);
        
        Prateleira minhaPrat = new Prateleira(produto1, produto2, produto3);
        Prateleira minhaPrat2 = new Prateleira(produto1, produto2, produto3);

        
        Mercado meuMercado = new Mercado(minhaPrat, minhaPrat2);
        
        System.out.println(meuMercado.mediaValorProdutos());
    }*/
    
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