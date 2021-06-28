public class MEI extends Empresa {
    private String cpf;
    
    public MEI() {
        super();
        cpf = "Não informado";
    }
    
    public MEI(String nome, String usuario, String senha, Endereco endereco, Servico[] servicos, String cpf) {
        super(nome, usuario, senha, endereco, servicos);
        this.cpf = cpf;
    }
    
    public MEI(String nome, String usuario, String senha, Endereco endereco, String cpf) {
        super(nome, usuario, senha, endereco);
        this.cpf = cpf;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String toString() {
        return super.toString() + "\tCPF: " + cpf;
    }
    
    /*
    public static void main(String[] args) {
        Servico s1 = new Servico();
        Servico s2 = new Servico("Lavagem de carros", 45.90);
        Servico[] servicos1 = {s1, s2};
        Endereco end = new Endereco("Av. Carlos Gomes", "1.672", "Porto Alegre", "RS");
        
        System.out.println();
        System.out.println(new MEI());
        System.out.println();
        System.out.println(new MEI("WeWork", "admin", "admin", end, servicos1, "041.470.659-48"));
    }
    */
}