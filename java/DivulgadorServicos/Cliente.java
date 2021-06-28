public class Cliente {
    private String nome, usuario, senha;
    private Empresa[] interesseEmpresas;
    
    public Cliente() {
        nome = "Não informado";
        usuario = "Não informado";
        senha = "Não informado";
        interesseEmpresas = null;
    }
    
    public Cliente(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.interesseEmpresas = new Empresa[10];
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Empresa[] getInteresseEmpresas() {
        return interesseEmpresas;
    }
    
    public void setInteresseEmpresas(Empresa[] interesseEmpresas) {
        this.interesseEmpresas = interesseEmpresas;
    }
    
    public String toString() {
        String texto = "Cliente: " + nome + "\n\tUsuário: " + usuario + "\n\tInteressado nas empresas:\n";
        if (interesseEmpresas != null)
            for (int i = 0; i < interesseEmpresas.length; i++)
                if (interesseEmpresas[i] != null)
                    texto += "\t\t" + interesseEmpresas[i].getNome() + "\n";
                else {
                    texto += "\t\tNão informado";
                    break;
                }
        else if (interesseEmpresas == null)
            texto += "\t\tNão informado";
        return texto;
    }
    
    /*
    public static void main(String[] args) {
        Servico s1 = new Servico();
        Servico s2 = new Servico("Lavagem de carros", 45.90);
        Servico[] servicos1 = {s1, s2};
        Endereco end = new Endereco("Av. Carlos Gomes", "1.672", "Porto Alegre", "RS");
        Empresa emp1 = new Empresa("WeWork", "admin", "admin", end, servicos1);
        Empresa[] listaEmp = {emp1, emp1};
        
        System.out.println();
        System.out.println(new Cliente());
        System.out.println();
        Cliente cli1 = new Cliente("Ricardo", "admin", "admin");
        System.out.println(cli1);
        cli1.setInteresseEmpresas(listaEmp);
        System.out.println(cli1);
    }
    */
}
