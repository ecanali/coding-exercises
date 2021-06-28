public class LTDA extends Empresa {
    private double imposto;
    
    public LTDA() {
        super();
        imposto = 0.0;
    }
    
    public double calculaImposto(String estado) {
        if (estado.equalsIgnoreCase("RS") || estado.equalsIgnoreCase("SC") || estado.equalsIgnoreCase("PR"))
            return 100.0;
        else if (estado.equalsIgnoreCase("SP") || estado.equalsIgnoreCase("RJ"))
            return 150.0;
        else
            return 70.0;
    }
    
    public LTDA(String nome, String usuario, String senha, Endereco endereco, Servico[] servicos) {
        super(nome, usuario, senha, endereco, servicos);
        this.imposto = calculaImposto(super.getEndereco().getEstado());
    }
    
    public LTDA(String nome, String usuario, String senha, Endereco endereco) {
        super(nome, usuario, senha, endereco);
        this.imposto = calculaImposto(super.getEndereco().getEstado());
    }
    
    public double getImposto() {
        return imposto;
    }
    
    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
    
    public String toString() {
        return super.toString() + "\tImposto: " + imposto;
    }
    
    /*
    public static void main(String[] args) {
        Servico s1 = new Servico();
        Servico s2 = new Servico("Lavagem de carros", 45.90);
        Servico[] servicos1 = {s1, s2};
        Endereco end = new Endereco("Av. Carlos Gomes", "1.672", "Porto Alegre", "pr");
        
        System.out.println();
        System.out.println(new LTDA());
        System.out.println();
        System.out.println(new LTDA("WeWork", "admin", "admin", end, servicos1));
    }
    */
}
