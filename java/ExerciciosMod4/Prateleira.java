public class Prateleira {
    private Produto produto1, produto2, produto3;
    
    public Prateleira(Produto produto1, Produto produto2, Produto produto3) {
        this.produto1 = produto1;
        this.produto2 = produto2;
        this.produto3 = produto3;
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
        if (produto2 != null && produto2.getPreco() > produtoMaisCaro.getPreco())
            produtoMaisCaro = produto2;
        if (produto3 != null && produto3.getPreco() > produtoMaisCaro.getPreco())
            produtoMaisCaro = produto3;
        return produtoMaisCaro;
    }
}