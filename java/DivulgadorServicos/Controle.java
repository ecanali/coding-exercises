public class Controle {
    // Atributos
    private final int MAX_EMPRESAS = 30; //original=30
    private final int MAX_CLIENTES = 10; //original=10
    private Empresa[] empresas;
    private Cliente[] clientes;
    private Cliente clienteLogado;
    private Empresa empresaLogada;
    
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
    
    /*public boolean loginCliente() {
        String usuarioInformado, senhaInformada;
        boolean encontrouUsuario = false;
        int tentativasUsuario = 0;
        while (!encontrouUsuario) {
            if (tentativasUsuario >= 3) {
                System.out.println("Usuário não encontrado, 3 tentativas acabaram");
                return false;
            } else {
                usuarioInformado = t.leString("Digite o usuário do Cliente:");
                int quantDiferentes = 0;
                int quantNotNull = 0;
                for (int i = 0; i < clientes.length; i++)
                    if (clientes[i] != null) {
                        quantNotNull++;
                        if (clientes[i].getUsuario().equals(usuarioInformado)) {
                            encontrouUsuario = true;
                            clienteLogado = clientes[i];
                            break;
                        } else
                            quantDiferentes++;
                    }
                if (quantDiferentes == quantNotNull) {
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
                int quantDiferentes = 0;
                int quantNotNull = 0;
                for (int i = 0; i < clientes.length; i++)
                    if (clientes[i] != null) {
                        quantNotNull++;
                        if (clientes[i].getSenha().equals(senhaInformada)) {
                            acertouSenha = true;
                            clienteLogado = clientes[i];
                            break;
                        } else
                            quantDiferentes++;
                    }
                if (quantDiferentes == quantNotNull) {
                    tentativasSenha++;
                    System.out.println("Senha incorreta, tente novamente");
                    
                }
            }
        }
        //clienteLogado = 
        return true;
    }*/
    
    public boolean loginCliente() {
        String usuarioInformado, senhaInformada;
        
        // Verificação usuário
        boolean encontrouUsuario = false;
        Cliente usuarioEncontrado = null;
        int tentativasUsuario = 0;
        while (!encontrouUsuario) {
            if (tentativasUsuario >= 3) {
                System.out.println("Usuário não encontrado, 3 tentativas acabaram");
                return false;
            } else {
                usuarioInformado = t.leString("Digite o usuário do Cliente:");
                int quantDiferentes = 0;
                int quantNotNull = 0;
                for (int i = 0; i < clientes.length; i++)
                    if (clientes[i] != null) {
                        quantNotNull++;
                        if (clientes[i].getUsuario().equals(usuarioInformado)) {
                            encontrouUsuario = true;
                            usuarioEncontrado = clientes[i];
                            break;
                        } else
                            quantDiferentes++;
                    }
                if (quantDiferentes == quantNotNull) {
                    tentativasUsuario++;
                    System.out.println("Usuário não encontrado, tente novamente");
                }
            }
        }
        
        // Verificação senha
        boolean acertouSenha = false;
        int tentativasSenha = 0;
        while (!acertouSenha) {
            if (tentativasSenha >= 3) {
                System.out.println("Senha incorreta, 3 tentativas acabaram");
                return false;
            } else {
                senhaInformada = t.leString("Digite a senha do Cliente:");
                if (usuarioEncontrado.getSenha().equals(senhaInformada)) {
                    acertouSenha = true;
                    clienteLogado = usuarioEncontrado;
                    break;
                } else {
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
        while (tipo < 1 || tipo > 2) {
            tipo = t.leInt("Selecione o tipo da Empresa: \n1 - MEI\n2 - LTDA");
        }
        
        if (tipo == 1) {
            String cpf = t.leString("Digite o CPF do(a) dono(a) da Empresa:");
            return cadastraEmpresa(new MEI(nome, usuario, senha, endereco, cpf));
        } else if (tipo == 2)
            return cadastraEmpresa(new LTDA(nome, usuario, senha, endereco));                           
        
        return false;
    }
    
    /*public boolean loginEmpresa() {
        String usuarioInformado, senhaInformada;
        boolean encontrouUsuario = false;
        int tentativasUsuario = 0;
        while (!encontrouUsuario) {
            if (tentativasUsuario >= 3) {
                System.out.println("Usuário não encontrado, 3 tentativas acabaram");
                return false;
            } else {
                usuarioInformado = t.leString("Digite o usuário da Empresa:");
                int quantDiferentes = 0;
                int quantNotNull = 0;
                for (int i = 0; i < empresas.length; i++)
                    if (empresas[i] != null) {
                        quantNotNull++;
                        if (empresas[i].getUsuario().equals(usuarioInformado)) {
                            encontrouUsuario = true;
                            break;
                        } else
                            quantDiferentes++;
                    }
                if (quantDiferentes == quantNotNull) {
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
                senhaInformada = t.leString("Digite a senha da Empresa:");
                int quantDiferentes = 0;
                int quantNotNull = 0;
                for (int i = 0; i < empresas.length; i++)
                    if (empresas[i] != null) {
                        quantNotNull++;
                        if (empresas[i].getSenha().equals(senhaInformada)) {
                            acertouSenha = true;
                            break;
                        } else
                            quantDiferentes++;
                    }
                if (quantDiferentes == quantNotNull) {
                    tentativasSenha++;
                    System.out.println("Senha incorreta, tente novamente");
                    
                }
            }
        }
        
        return true;
    }*/
    
    public boolean loginEmpresa() {
        String usuarioInformado, senhaInformada;
        
        // Verificação usuário
        boolean encontrouUsuario = false;
        Empresa usuarioEncontrado = null;
        int tentativasUsuario = 0;
        while (!encontrouUsuario) {
            if (tentativasUsuario >= 3) {
                System.out.println("Usuário não encontrado, 3 tentativas acabaram");
                return false;
            } else {
                usuarioInformado = t.leString("Digite o usuário da Empresa:");
                int quantDiferentes = 0;
                int quantNotNull = 0;
                for (int i = 0; i < empresas.length; i++)
                    if (empresas[i] != null) {
                        quantNotNull++;
                        if (empresas[i].getUsuario().equals(usuarioInformado)) {
                            encontrouUsuario = true;
                            usuarioEncontrado = empresas[i];
                            break;
                        } else
                            quantDiferentes++;
                    }
                if (quantDiferentes == quantNotNull) {
                    tentativasUsuario++;
                    System.out.println("Usuário não encontrado, tente novamente");
                }
            }
        }
        
        // Verificação senha
        boolean acertouSenha = false;
        int tentativasSenha = 0;
        while (!acertouSenha) {
            if (tentativasSenha >= 3) {
                System.out.println("Senha incorreta, 3 tentativas acabaram");
                return false;
            } else {
                senhaInformada = t.leString("Digite a senha da Empresa:");
                if (usuarioEncontrado.getSenha().equals(senhaInformada)) {
                    acertouSenha = true;
                    empresaLogada = usuarioEncontrado;
                    break;
                } else {
                    tentativasSenha++;
                    System.out.println("Senha incorreta, tente novamente");
                }
            }
        }
        return true;
    }
    
    public void criaEmpresasClientesAleatorios(int quantEmpresas, int quantClientes) {
        // Criação de empresas
        String[] rua = {"Av. Carlos Gomes", "Av. Ipiranga", "Av. Assis Brasil", "Av. Nilo Peçanha", "Av. Farrapos"};
        String[] cidade = {"Porto Feliz", "Varginha", "Laranjão", "Tiatira", "Betania"};
        String[] estado = {"RS", "SP", "RJ", "BH", "AM"};
        String[] descServico = {"Lavagem", "Faxina", "Contabilidade", "Segurança", "Portaria", "Cobrança", "Curadoria", "Edição", "Gravação", "Treinamento"};
        String[] primeiroNome = {"Sigma", "Beta", "Αlfa", "Delta", "Omega"};
        String[] ultimoNome = {"Tecnologia", "Financiamentos", "Transportes", "Distribuição", "Educação"};
        String[] nomesEmpresas = new String[quantEmpresas];
        Endereco endereco;
        Servico[] servicos;
        Empresa[] empresasCriadas = new Empresa[quantEmpresas];
        for (int i = 0; i < nomesEmpresas.length; i++) {
            nomesEmpresas[i] = primeiroNome[(int)(Math.random() * 5)] + " " + 
                        ultimoNome[(int)(Math.random() * 5)];
                        
            endereco = new Endereco(
                rua[(int)(Math.random() * 5)],
                "1." + (int)(Math.random() * 500),
                cidade[(int)(Math.random() * 5)],
                estado[(int)(Math.random() * 5)]);
            
            servicos = new Servico[4];
            for (int j = 0; j < servicos.length; j++) {
                servicos[j] = new Servico(
                descServico[(int)(Math.random() * 10)],
                (Math.random() * 999));
            }
            
            if (i % 2 == 0) {
                Empresa emp = new MEI(nomesEmpresas[i], ultimoNome[i] + i * 3, ultimoNome[i] + 123, endereco, servicos, "36." + (int)(Math.random() * 1234567890));
                cadastraEmpresa(emp);
                empresasCriadas[i] = emp;
            } else {
                Empresa emp = new LTDA(nomesEmpresas[i], ultimoNome[i] + i * 3, ultimoNome[i] + 123, endereco, servicos);
                cadastraEmpresa(emp);
                empresasCriadas[i] = emp;
            }
        }

        System.out.println(nomesEmpresas.length + " Empresas cadastradas aleatoriamente");
        
        // Criação de clientes
        String[] primeiroNomePessoa = {"Roberto", "Mateus", "Mario", "Ricardo", "Cristiano"};
        String[] ultimoNomePessoa = {"Pereira", "Oliveira", "Silva", "Santos", "Skywalker"};
        String[] nomes = new String[quantClientes];
        Cliente cliente;
        Empresa[] interesseEmpresas;
        for (int m = 0; m < nomes.length; m++) {
            nomes[m] = primeiroNomePessoa[(int)(Math.random() * 5)] + " " + 
                        ultimoNomePessoa[(int)(Math.random() * 5)];
                        
            cliente = new Cliente(
                nomes[m], 
                ultimoNomePessoa[m] + m * 3,
                ultimoNomePessoa[m] + 123);
            
            cadastraCliente(cliente);
            
            interesseEmpresas = new Empresa[4];
            for (int n = 0; n < interesseEmpresas.length; n++)
                interesseEmpresas[n] = empresasCriadas[n];    
            
            cliente.setInteresseEmpresas(interesseEmpresas);
        
        }
        System.out.println(nomes.length + " Clientes cadastrados aleatoriamente");
    }
    
    public Empresa buscaEmpresaPorNome(String nomeDigitado) {
        for (int i = 0; i < empresas.length; i++) {
            if (empresas[i].getNome().equalsIgnoreCase(nomeDigitado)) {
                return empresas[i];
            }
        }
        return null;
    }
    
    public void menuCliente() {
        int opcao = 0;
        while (opcao < 1 || opcao > 4) {
            opcao = t.leInt("\n< Menu de Cliente: " + clienteLogado.getNome() + " >\nDigite a opção desejada:\n1) Buscar empresas por nome\n2) Buscar empresas por tipo (MEI ou LTDA)\n3) Listar empresas marcadas com interesse\n4) Fazer logout");
        }
        
        if (opcao == 1) {
            if (cadastraEmpresaTeclado()) {
                System.out.println("Empresa cadastrada com sucesso!\nRedirecionado ao menu principal...");
                inicio();
            } else {
                System.out.println("ERRO: não foi possível cadastrar como Empresa.\nRedirecionado ao menu principal...");
                inicio();
            }
        
        } else if (opcao == 4) {
            System.out.println("Logout como Cliente realizado.\nRedirecionado ao menu principal...");
            clienteLogado = null;
            inicio();
        }
    }
    
    public void inicio() {
        int opcao = 0;
        while (opcao < 1 || opcao > 6) {
            opcao = t.leInt("\nBem-vindo(a) ao Divulgador de Serviços!\nDigite a opção desejada:\n1) Fazer login como Cliente\n2) Fazer login como Empresa\n3) Cadastrar como Cliente\n4) Cadastrar como Empresa\n5) Fazer login como Administrador\n6) Sair");
        }
        
        if (opcao == 1) {
            if (loginCliente()) {
                System.out.println("Login como Cliente efetuado com sucesso!\nRedirecionado ao menu de Cliente...");
                menuCliente();
            } else {
                System.out.println("ERRO: não foi possível fazer login como Cliente.\nRedirecionado ao menu principal...");
                inicio();
            }
        } else if (opcao == 2) {
            loginEmpresa();
        } else if (opcao == 3) {
            if (cadastraClienteTeclado()) {
                System.out.println("Cliente cadastrado com sucesso!\nRedirecionado ao menu principal...");
                inicio();
            } else {
                System.out.println("ERRO: não foi possível cadastrar como Cliente.\nRedirecionado ao menu principal...");
                inicio();
            }
        } else if (opcao == 4) {
            if (cadastraEmpresaTeclado()) {
                System.out.println("Empresa cadastrada com sucesso!\nRedirecionado ao menu principal...");
                inicio();
            } else {
                System.out.println("ERRO: não foi possível cadastrar como Empresa.\nRedirecionado ao menu principal...");
                inicio();
            }
        } else if (opcao == 5) {
            String usuarioInformado = t.leString("Digite o usuário administrador:");
            String senhaInformada;
            if (usuarioInformado.equals("admin")) {
                senhaInformada = t.leString("Digite a senha do administrador:");
                if (senhaInformada.equals("admin")) {
                    System.out.println("Login como ADMIN com sucesso! \n...");
                } else {
                    System.out.println("ERRO: não foi possível fazer login como administrador.\nRedirecionado ao menu principal...");
                    inicio();
                }
            } else {
                System.out.println("ERRO: não foi possível fazer login como administrador.\nRedirecionado ao menu principal...");
                inicio();
            }
        } else if (opcao == 6) {
            System.out.println("Programa encerrado.");
        }
    }
}










