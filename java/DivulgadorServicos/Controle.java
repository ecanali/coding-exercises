public class Controle {
    // Atributos
    private final int MAX_EMPRESAS = 30;
    private final int MAX_CLIENTES = 10;
    private Empresa[] empresas;
    private Cliente[] clientes;
    
    // Método construtor
    public Controle() {
        empresas = new Empresa[MAX_EMPRESAS];
        clientes = new Cliente[MAX_CLIENTES];
    }
    
    // Métodos de acesso
    public Empresa[] getEmpresas() {
        return empresas;
    }
    
    public void setEmpresas(Empresa[] empresas) {
        this.empresas = empresas;
    }
    
    public Cliente[] getClientes() {
        return clientes;
    }
    
    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }
    
    // Métodos gerais
    Teclado t = new Teclado();
    
    public boolean cadastraCliente(Cliente cliente) {
        if (clientes == null) return false;
        
        for (int i = 0; i < clientes.length; i++)
            if (clientes[i] == null) {
                clientes[i] = cliente;
                return true;
            }
            
        return false;                
    }
    
    public boolean cadastraClienteTeclado() {
        return cadastraCliente(
            new Cliente(
                t.leString("Digite o nome do Cliente:"), 
                t.leString("Digite o usuário do Cliente:"),
                t.leString("Digite a senha do Cliente:")));     
    }
    
    public boolean loginCliente() {
        String usuarioInformado, senhaInformada;
        boolean encontrouUsuario = false;
        int tentativasUsuario = 0;
        while (!encontrouUsuario) {
            if (tentativasUsuario >= 3) {
                System.out.println("Usuário não encontrado, 3 tentativas acabaram");
                return false;
            } else {
                usuarioInformado = t.leString("Digite o usuário do Cliente:");
                for (int i = 0; i < clientes.length; i++)
                    if (clientes[i] != null)
                        if (clientes[i].getUsuario().equals(usuarioInformado))
                            encontrouUsuario = true;
                        else {
                            tentativasUsuario++;
                            System.out.println("Usuário não encontrado, tente novamente");
                        }
            }
        }
        
        boolean acertouSenha = false;
        int tentativasSenha = 0;
        while (!acertouSenha) {
            if (tentativasSenha >= 3) {
                System.out.println("Senha incorreta, 3 tentativas acabaram");
                return false;
            } else {
                senhaInformada = t.leString("Digite a senha do Cliente:");
                for (int i = 0; i < clientes.length; i++)
                    if (clientes[i] != null)
                        if (clientes[i].getSenha().equals(senhaInformada))
                            acertouSenha = true;
                        else {
                            tentativasSenha++;
                            System.out.println("Senha incorreta, tente novamente");
                        }
            }
        }
        
        return true;
    }
    
    public boolean cadastraEmpresa(Empresa empresa) {
        if (empresas == null) return false;
        
        for (int i = 0; i < empresas.length; i++)
            if (empresas[i] == null) {
                empresas[i] = empresa;
                return true;
            }
            
        return false;                
    }
    
    public boolean cadastraEmpresaTeclado() {
        String nome = t.leString("Digite o nome da Empresa:");
        String usuario = t.leString("Digite o usuário da Empresa:");
        String senha = t.leString("Digite a senha da empresa:");
        
        Endereco endereco = new Endereco(
                t.leString("Digite a rua da Empresa:"), 
                t.leString("Digite o número da rua da Empresa:"),
                t.leString("Digite a cidade da Empresa:"),
                t.leString("Digite o estado (UF) da Empresa:"));
        
        int tipo = 0;
        while (tipo != 1 || tipo != 2) {
            tipo = t.leInt("Selecione o tipo da Empresa: \n1 - MEI/n2 - LTDA");
        }
        
        if (tipo == 1) {
            String cpf = t.leString("Digite o CPF do(a) dono(a) da Empresa:");
            return cadastraEmpresa(new MEI(nome, usuario, senha, endereco, cpf));
        } else if (tipo == 2)
            return cadastraEmpresa(new LTDA(nome, usuario, senha, endereco));                           
        
        return false;
    }
}