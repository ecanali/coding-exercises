public class Livro {
    // Atributos
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private double preco;
    private int quantidadePaginas;
    
    // Construtor
    public Livro(String titulo, String autor, int anoPublicacao, double preco, int quantidadePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.quantidadePaginas = quantidadePaginas;
    }
    
    // Métodos de acesso
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(char preco) {
        this.preco = preco;
    }
    
    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }
    
    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }
    
    // Métodos
    public double calcularPrecoPorPagina() {
        return (preco / quantidadePaginas);
    }
    
    public void imprimeInfo() {
        System.out.println("Título: " + titulo + " - Autor: " + autor + " - Ano de Publicação: " + anoPublicacao + " - Preço: " + preco + " - Quantidade de páginas: " + quantidadePaginas);
    }
}