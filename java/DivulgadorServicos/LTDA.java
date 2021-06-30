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
}
