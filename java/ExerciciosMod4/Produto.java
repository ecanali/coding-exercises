public class Produto {
    /*public static void main(String[] args) {
        Data data1 = new Data(15, 06, 2021);
        Data data2 = new Data(14, 06, 2021);
        Data data3 = new Data(16, 06, 2021);
        
        Produto produto1 = new Produto("Leite", 3.79, data1);
        
        System.out.println(produto1);
        
        System.out.println(produto1.verificaProdutoVencido(data2));
        System.out.println(produto1.verificaProdutoVencido(data3));

    }*/
    
    private String nome;
    private double preco;
    private Data dataValidade;
    
    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }
    
    public String toString() {
        return "[Nome] " + nome + "\n[Preço] " + preco + "\n[Data de validade] " + dataValidade;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public Data getDataValidade() {
        return dataValidade;
    }
    
    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    /*public boolean verificaProdutoVencido(Data data) {
        if (data.getAno() >= dataValidade.getAno())
            return false;
        
        if (data.getMes() >= dataValidade.getMes())
            return false;
        if (data.getDia() > dataValidade.getDia())
            return false;
        else
            return true;
    }*/
    public boolean verificaProdutoVencido(Data dataAtual)
    {
        if(dataValidade.getAno() > dataAtual.getAno()){
            return false;
        }else if(dataValidade.getMes() > dataAtual.getMes()){
            return false;
        }else if(dataValidade.getDia() >= dataAtual.getDia()){
            return false;
        }else{
            return true;
        }
    }
}