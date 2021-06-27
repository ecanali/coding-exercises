public class Endereco {
    private String rua, numero, cidade, estado;
    
    public Endereco() {
        rua = "Não informado";
        numero = "Não informado";
        cidade = "Não informado";
        estado = "Não informado";
    }
    
    public Endereco(String rua, String numero, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    public String getRua() {
        return rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String toString() {
        return rua + ", " + numero + ", " + cidade + ", " + estado;
    }
    
    /*
    public static void main(String[] args) {
        System.out.println(new Endereco());
        System.out.println(new Endereco("Av. Carlos Gomes", "1.672", "Porto Alegre", "RS"));
    }
    */
}