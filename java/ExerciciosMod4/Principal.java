public class Principal {
    public static void main(String[] args) {        
        double preco1 = 0;
        while (preco1 <= 0)
            preco1 = Teclado.leDouble("Digite o preço do amaciante:");
        Produto produto1 = new Produto("amaciante", preco1, new Data(10, 04, 2014));
        
        double preco2 = 0;
        while (preco2 <= 0)
            preco2 = Teclado.leDouble("Digite o preço do creme dental:");
        Produto produto2 = new Produto("creme dental", preco2, new Data(05, 05, 2015));
        
        double preco3 = 0;
        while (preco3 <= 0)
            preco3 = Teclado.leDouble("Digite o preço do leite condensado:");
        Produto produto3 = new Produto("leite condensado", preco3, new Data(04, 12, 2012));
        
        Prateleira prateleira1 = new Prateleira(produto1, produto2, produto3);
        
        Prateleira prateleira2 = new Prateleira();
        
        Produto produto4 = new Produto("cortina", 167.98, new Data(13, 10, 2025));
        
        prateleira2.setProduto1(produto4);
        
        Mercado mercado1 = new Mercado(prateleira1, prateleira2);
        
        System.out.println("Os produtos vencidos são:");
        System.out.println(mercado1.getPrateleira1().getProduto1().getDataValidade());
        System.out.println(mercado1.getPrateleira1().getProduto1().verificaProdutoVencido(new Data(10, 10, 2014)));
        System.out.println(mercado1.getPrateleira1().getProduto2().getDataValidade());
        System.out.println(mercado1.getPrateleira1().getProduto2().verificaProdutoVencido(new Data(10, 10, 2014)));
        System.out.println(mercado1.getPrateleira1().getProduto3().getDataValidade());
        System.out.println(mercado1.getPrateleira1().getProduto3().verificaProdutoVencido(new Data(10, 10, 2014)));
        System.out.println(mercado1.getPrateleira2().getProduto1().getDataValidade());
        System.out.println(mercado1.getPrateleira2().getProduto1().verificaProdutoVencido(new Data(10, 10, 2014)));
        
        Produto produtoMaisCaroPrateleira1 = mercado1.getPrateleira1().produtoMaisCaro();
        Produto produtoMaisCaroPrateleira2 = mercado1.getPrateleira2().produtoMaisCaro();
        
        if (produtoMaisCaroPrateleira1.getPreco() > produtoMaisCaroPrateleira2.getPreco())
            System.out.println("O produto mais caro é:\n" + produtoMaisCaroPrateleira1);
        else
            System.out.println("O produto mais caro é:\n" + produtoMaisCaroPrateleira2);
            
        System.out.println("A média de preços dos produtos do mercado é: " + mercado1.mediaValorProdutos());
    }
}