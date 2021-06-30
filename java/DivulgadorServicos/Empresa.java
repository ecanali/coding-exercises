public class Empresa {
    private String nome, usuario, senha;
    private Endereco endereco;
    private Servico[] servicos;
    
    public Empresa() {
        nome = "Não informado";
        usuario = "Não informado";
        senha = "Não informado";
        endereco = null;
        servicos = null;
    }
    
    public Empresa(String nome, String usuario, String senha, Endereco endereco, Servico[] servicos) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.endereco = endereco;
        this.servicos = servicos;
    }
    
    public Empresa(String nome, String usuario, String senha, Endereco endereco) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.endereco = endereco;
        this.servicos = null;
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
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public Servico[] getServicos() {
        return servicos;
    }
    
    public void setServicos(Servico[] servicos) {
        this.servicos = servicos;
    }
    
    public String toString() {
        String texto = "Empresa: " + nome + "\n\tUsuário: " + usuario + "\n\tEndereço: " + endereco + "\n\tServiços:\n";
        if (servicos != null)
            for (int i = 0; i < servicos.length; i++) {
                if (servicos[i] != null)
                    texto += "\t\t" + servicos[i] + "\n";
                else break;
            }
        else if (servicos == null)
            texto += "\t\tNão informado\n";
        return texto;
    }
}