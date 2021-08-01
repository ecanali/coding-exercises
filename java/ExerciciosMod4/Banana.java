public class Banana extends Fruta {
    private String tipo;
    
    public Banana(String nome, double preco, String tipo) {
        super(nome, preco);
        this.tipo = tipo;
    }

    public Banana(String nome, double preco) {
        super(nome, preco);
        this.tipo = "undefined";
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }

}