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
}