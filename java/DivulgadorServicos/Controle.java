public class Controle {
    // Atributos
    private final int MAX_EMPRESAS = 30;
    private final int MAX_CLIENTES = 10;
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
    
    public boolean criaEmpresasClientesAleatorios(int quantEmpresas, int quantClientes) {
        // Criação de empresas
        if (quantEmpresas > MAX_EMPRESAS || quantClientes > MAX_CLIENTES || quantEmpresas <= quantClientes) {
            System.out.println("Não foi possível cadastrar Empresas e Clientes aleatórios, parâmetros inválidos.");
            return false;
        } else {
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
                
                interesseEmpresas = new Empresa[10];
                for (int n = 0; n < 4; n++)
                    interesseEmpresas[n] = empresasCriadas[n];    
                
                cliente.setInteresseEmpresas(interesseEmpresas);
            
            }
            System.out.println(nomes.length + " Clientes cadastrados aleatoriamente");
            return true;
        }
    }
    
    public Empresa buscaEmpresaPorNome(String nomeDigitado) {
        for (int i = 0; i < empresas.length; i++)
            if (empresas[i] != null)
                if (empresas[i].getNome().equalsIgnoreCase(nomeDigitado))
                    return empresas[i];
        return null;
    }
    
    public Empresa[] buscaEmpresaPorTipo(String tipoDigitado) {
        Empresa[] empresasTipoEncontradas = new Empresa[empresas.length];
        for (int i = 0; i < empresas.length; i++) {
            if (empresas[i] != null) {
                if (tipoDigitado.equalsIgnoreCase("MEI")) 
                    if (empresas[i] instanceof MEI)
                        empresasTipoEncontradas[i] = empresas[i];
                if (tipoDigitado.equalsIgnoreCase("LTDA"))    
                    if (empresas[i] instanceof LTDA)
                        empresasTipoEncontradas[i] = empresas[i];    
            }
        }
        return empresasTipoEncontradas;
    }
    
    public boolean marcarInteresse(Empresa empresa) {
        if (clienteLogado.getInteresseEmpresas() == null) return false;
        
        // Verifica se já está na lista primeiro
        for (int i = 0; i < clienteLogado.getInteresseEmpresas().length; i++)
            if (clienteLogado.getInteresseEmpresas()[i] == empresa) {
                return false;
            }
        
        for (int i = 0; i < clienteLogado.getInteresseEmpresas().length; i++)
            if (clienteLogado.getInteresseEmpresas()[i] == null) {
                clienteLogado.getInteresseEmpresas()[i] = empresa;
                return true;
            }
            
        return false; 
    }
    
    public boolean desmarcarInteresse(Empresa empresa) {
        if (clienteLogado.getInteresseEmpresas() == null) return false;
        
        for (int i = 0; i < clienteLogado.getInteresseEmpresas().length; i++)
            if (clienteLogado.getInteresseEmpresas()[i] == empresa) {
                clienteLogado.getInteresseEmpresas()[i] = null;
                return true;
            }
            
        return false; 
    }
    
    public boolean incluirServico() {
        Servico servico = new Servico(
            t.leString("Informe a descrição do serviço:"), 
            t.leDouble("Informe o preço do serviço:"));
        
        Servico[] novoServicos;
        if (empresaLogada.getServicos() == null) {
            novoServicos = new Servico[1];
            novoServicos[0] = servico;
            empresaLogada.setServicos(novoServicos);
            return true;
        }
        
        novoServicos = new Servico[empresaLogada.getServicos().length + 1];
        for (int i = 0; i < empresaLogada.getServicos().length; i++) {
            novoServicos[i] = empresaLogada.getServicos()[i];
        }
        
        novoServicos[novoServicos.length - 1] = servico;
        empresaLogada.setServicos(novoServicos);
        
        return true;
    }
    
    public void menuCliente() {
        int opcao = 0;
        while (opcao < 1 || opcao > 4)
            opcao = t.leInt("\n< Menu de Cliente: " + clienteLogado.getNome() + " >\nDigite a opção desejada:\n1) Buscar empresas por nome\n2) Buscar empresas por tipo (MEI ou LTDA)\n3) Listar empresas marcadas com interesse\n4) Fazer logout");
        
        if (opcao == 1) {
            String nomeEmpresa = t.leString("Digite o nome da empresa que deseja buscar:");
            Empresa empresaRetornada = buscaEmpresaPorNome(nomeEmpresa);
            
            if (empresaRetornada == null) {
                System.out.println("Nenhuma empresa encontrada com o nome informado.\nRedirecionado ao Menu de Cliente...");
                menuCliente();
            } else {
                System.out.println("Sua busca encontrou a seguinte empresa:\n" + empresaRetornada);
                
                int opcaoAvancada = 0;
                while (opcaoAvancada < 1 || opcaoAvancada > 4) {
                    opcaoAvancada = t.leInt("Selecione o que deseja fazer com a empresa " + empresaRetornada.getNome() + ":\n1) Marcar interesse\n2) Desmarcar interesse\n3) Imprimir serviços\n4) Voltar");
                }
                
                if (opcaoAvancada == 1) {
                    if (marcarInteresse(empresaRetornada)) {
                        System.out.println(empresaRetornada.getNome() + " incluída em sua lista de interesse. \nRedirecionado ao Menu de Cliente...");
                        menuCliente();
                    } else {
                        System.out.println("ERRO: não foi possível incluir empresa em sua lista de interesse, lista está cheia ou já tinha esta empresa.\nRedirecionado ao menu principal...");
                        menuCliente();
                    }
                } else if (opcaoAvancada == 2) {
                    if (desmarcarInteresse(empresaRetornada)) {
                        System.out.println(empresaRetornada.getNome() + " removida de sua lista de interesse. \nRedirecionado ao Menu de Cliente...");
                        menuCliente();
                    } else {
                        System.out.println("ERRO: não foi possível remover empresa de sua lista de interesse, já não estava nela.\nRedirecionado ao menu principal...");
                        menuCliente();
                    }
                } else if (opcaoAvancada == 3) {
                    if (empresaRetornada.getServicos() == null) {
                        System.out.println("ERRO: não foi possível ler lista de serviços.\nRedirecionado ao Menu de Cliente...");
                        menuCliente();
                    } else {
                        System.out.println("Os serviços oferecidos pela empresa " + empresaRetornada.getNome() + " são:\n");
                        for (int i=0; i < empresaRetornada.getServicos().length; i++)
                            if (empresaRetornada.getServicos()[i] != null)
                                System.out.println(empresaRetornada.getServicos()[i]);
                            
                        System.out.println("Redirecionado ao Menu de Cliente...");
                        menuCliente();
                    }
                } else if (opcaoAvancada == 4) {
                    System.out.println("Redirecionado ao Menu de Cliente...");
                    menuCliente();
                }
            }
        } else if (opcao == 2) {
            String tipoEmpresa = t.leString("Digite o tipo da empresa que deseja buscar (MEI ou LTDA):");
            Empresa[] empresasTipoEncontradas = buscaEmpresaPorTipo(tipoEmpresa);
            
            if (empresasTipoEncontradas == null) {
                System.out.println("Nenhuma empresa encontrada com o tipo informado.\nRedirecionado ao Menu de Cliente...");
                menuCliente();
            } else {
                System.out.println("Sua busca encontrou as seguintes empresas:\n");
                for (int i = 0; i < empresasTipoEncontradas.length; i++) {
                    if (empresasTipoEncontradas[i] != null) {
                        System.out.println(empresasTipoEncontradas[i]);
                    }
                }
                System.out.println("Redirecionado ao Menu de Cliente...");
                menuCliente();
            }
        } else if (opcao == 3) {
            if (clienteLogado.getInteresseEmpresas() == null) {
                System.out.println("ERRO: não foi possível ler lista de interesse.\nRedirecionado ao Menu de Cliente...");
                menuCliente();
            } else {
                System.out.println("Lista de empresas marcadas com interesse:");
                for (int i=0; i < clienteLogado.getInteresseEmpresas().length; i++)
                    if (clienteLogado.getInteresseEmpresas()[i] != null)
                        System.out.println(clienteLogado.getInteresseEmpresas()[i]);
                    
                System.out.println("Redirecionado ao Menu de Cliente...");
                menuCliente();
            }
        } else if (opcao == 4) {
            System.out.println("Logout como Cliente realizado.\nRedirecionado ao menu principal...");
            clienteLogado = null;
            inicio();
        }
    }
    
    public void menuEmpresa() {
        int opcao = 0;
        while (opcao < 1 || opcao > 4)
            opcao = t.leInt("\n< Menu de Empresa: " + empresaLogada.getNome() + " >\nDigite a opção desejada:\n1) Alterar usuário\n2) Alterar senha\n3) Incluir novo serviço\n4) Fazer logout");
        
        if (opcao == 1) {
            String senha = t.leString("Primeiro, digite sua senha:");
            if (senha.equals(empresaLogada.getSenha())) {
                empresaLogada.setUsuario(t.leString("Digite o novo usuario desejado:"));
                System.out.println("Usuário alterado com sucesso.\nRedirecionado ao Menu de Empresa...");
                menuEmpresa();
            } else {
                System.out.println("ERRO: senha incorreta.\nRedirecionado ao Menu de Empresa...");
                menuEmpresa();
            }
        } else if (opcao == 2) {
            String senhaAnterior = t.leString("Primeiro, digite sua senha anterior:");
            if (senhaAnterior.equals(empresaLogada.getSenha())) {
                String novaSenha1 = t.leString("Digite sua nova senha:");
                String novaSenha2 = t.leString("Repita sua nova senha:");
                if (novaSenha1.equals(novaSenha2)) {
                    empresaLogada.setSenha(novaSenha1);
                    System.out.println("Senha alterada com sucesso.\nRedirecionado ao Menu de Empresa...");
                    menuEmpresa();
                } else {
                    System.out.println("ERRO: senhas não combinam.\nRedirecionado ao Menu de Empresa...");
                    menuEmpresa();
                }
            } else {
                System.out.println("ERRO: senha incorreta.\nRedirecionado ao Menu de Empresa...");
                menuEmpresa();
            }
        } else if (opcao == 3) {
            if (incluirServico()) {
                System.out.println("Novo serviço adicionado com sucesso.\nRedirecionado ao Menu de Empresa...");
                menuEmpresa();
            } else {
                System.out.println("ERRO: não foi possível incluir novo serviço.\nRedirecionado ao Menu de Empresa...");
                menuEmpresa();
            }
        } else if (opcao == 4) {
            System.out.println("Logout como Empresa realizado.\nRedirecionado ao menu principal...");
            empresaLogada = null;
            inicio();
        }
    }
    
    public void menuAdmin() {
        int opcao = 0;
        while (opcao < 1 || opcao > 5)
            opcao = t.leInt("\n< Menu de Administrador >\nDigite a opção desejada:\n1) Imprimir todos os Clientes\n2) Imprimir todas as Empresas\n3) Imprimir CPF donos MEI\n4) Imprimir imposto todas LTDA\n5) Fazer logout");
        
        if (opcao == 1) {
            System.out.println("Lista de todos os Clientes cadastrados no sistema:");
            int soma = 0;
            for (int i = 0; i < clientes.length; i++)
                if (clientes[i] != null) {
                    soma++;
                    System.out.println(clientes[i]);
                }
            System.out.println("TOTAL: " + soma + " Clientes");
            System.out.println("\nRedirecionado ao Menu de Administrador...");
            menuAdmin();
        } else if (opcao == 2) {
            System.out.println("Lista de todas as Empresas cadastradas no sistema:");
            int soma = 0;
            for (int i = 0; i < empresas.length; i++)
                if (empresas[i] != null) {
                    soma++;
                    System.out.println(empresas[i]);
                }
            System.out.println("TOTAL: " + soma + " Empresas");
            System.out.println("\nRedirecionado ao Menu de Administrador...");
            menuAdmin();
        } else if (opcao == 3) {
            Empresa[] meis = buscaEmpresaPorTipo("MEI");
            System.out.println("Lista com apenas o CPF de cada um dos donos das empresas do tipo MEI:");
            int soma = 0;
            for (int i = 0; i < meis.length; i++)
                if (meis[i] != null) {
                    soma++;
                    System.out.println(((MEI)meis[i]).getCpf());
                }
            System.out.println("TOTAL: " + soma + " Empresas do tipo MEI");
            System.out.println("\nRedirecionado ao Menu de Administrador...");
            menuAdmin();
        } else if (opcao == 4) {
            Empresa[] ltdas = buscaEmpresaPorTipo("LTDA");
            System.out.println("Lista com apenas o valor de imposto que cada uma das empresas do tipo LTDA pagam:");
            int soma = 0;
            for (int i = 0; i < ltdas.length; i++)
                if (ltdas[i] != null) {
                    soma++;
                    System.out.println(((LTDA)ltdas[i]).getImposto());
                }
            System.out.println("TOTAL: " + soma + " Empresas do tipo LTDA");
            System.out.println("\nRedirecionado ao Menu de Administrador...");
            menuAdmin();
        } else if (opcao == 5) {
            System.out.println("Logout como Administrador realizado.\nRedirecionado ao menu principal...");
            empresaLogada = null;
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
            if (loginEmpresa()) {
                System.out.println("Login como Empresa efetuado com sucesso!\nRedirecionado ao menu de Empresa...");
                menuEmpresa();
            } else {
                System.out.println("ERRO: não foi possível fazer login como Empresa.\nRedirecionado ao menu principal...");
                inicio();
            }
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
                    System.out.println("Login como Administrador efetuado com sucesso!\nRedirecionado ao menu de Administrador...");
                    menuAdmin();
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