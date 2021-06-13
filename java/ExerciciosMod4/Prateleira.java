public class Prateleira {
    public static void main(String[] args) {
        Data data1 = new Data(15, 06, 2021);
        Data data2 = new Data(14, 06, 2021);
        Data data3 = new Data(16, 06, 2021);
        
        Produto produto1 = new Produto("Leite", 25.79, data1);
        Produto produto2 = new Produto("Pão", 29.50, data2);
        Produto produto3 = new Produto("Queijo", 22.35, data3);
        
        Prateleira minhaPrat = new Prateleira(produto1, produto2, produto3);
        
        System.out.println(minhaPrat);
        System.out.println(minhaPrat.produtoMaisCaro());
    }
    
    private Produto produto1, produto2, produto3;
    
    public Prateleira(Produto produto1, Produto produto2, Produto produto3) {
        this.produto1 = new Produto(produto1.getNome(), produto1.getPreco(), produto1.getDataValidade());
        this.produto2 = new Produto(produto2.getNome(), produto2.getPreco(), produto2.getDataValidade());
        this.produto3 = new Produto(produto3.getNome(), produto3.getPreco(), produto3.getDataValidade());
    }
    
    public Prateleira() {
        
    }
    
    public String toString() {
        return "[Produto 1]\n" + produto1 
        + "\n[Produto 2]\n" + produto2
        + "\n[Produto 3]\n" + produto3;
    }
    
    public Produto getProduto1() {
        return produto1;
    }
    
    public void setProduto1(Produto novoProduto) {
        produto1 = novoProduto;
    }
    
    public Produto getProduto2() {
        return produto2;
    }
    
    public void setProduto2(Produto novoProduto) {
        produto2 = novoProduto;
    }
    
    public Produto getProduto3() {
        return produto3;
    }
    
    public void setProduto3(Produto novoProduto) {
        produto3 = novoProduto;
    }
    
    public Produto produtoMaisCaro() {
        Produto produtoMaisCaro = produto1;
        if (produto1.getPreco() > produto2.getPreco() && produto1.getPreco() > produto3.getPreco())
            return produto1;
        else if (produto2.getPreco() > produto1.getPreco() && produto2.getPreco() > produto3.getPreco())
            return produto2;
        else
            return produto3;
    }
}