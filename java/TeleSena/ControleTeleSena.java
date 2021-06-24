public class ControleTeleSena {
    private final int MAX_PESSOAS = 20; //20 original
    private final int MAX_TELE_SENA_VENDA = 300; //300 original
    private final int MAX_TELE_SENA_PESSOA = 15; //15 original
    private Pessoa[] pessoas;
    private TeleSena[] teleSenas;
    
    public ControleTeleSena() {
        pessoas = new Pessoa[MAX_PESSOAS];
        teleSenas = new TeleSena[MAX_TELE_SENA_VENDA];
    }
    
    public Pessoa[] getPessoas() {
        return pessoas;
    }
    
    public void setPessoas(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }
    
    public TeleSena[] getTeleSenas() {
        return teleSenas;
    }
    
    public void setTeleSenas(TeleSena[] teleSenas) {
        this.teleSenas = teleSenas;
    }
    
    public void cadastraPessoas() {
        String[] primeiroNome = {"Roberto", "Mateus", "Mario", "Ricardo", "Cristiano"};
        String[] segundoNome = {"Onofre", "Raimundo", "Sebastian", "Luiz", "Adriano"};
        String[] ultimoNome = {"Pereira", "Oliveira", "Silva", "Santos", "Skywalker"};
        String[] nomes = new String[MAX_PESSOAS];
        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = primeiroNome[(int)(Math.random() * 5)] + " " + 
                        segundoNome[(int)(Math.random() * 5)] + " " + 
                        ultimoNome[(int)(Math.random() * 5)];
            for (int j = 0; j < pessoas.length; j++) {
                pessoas[i] = new Pessoa(nomes[i], ((int)(Math.random() * MAX_TELE_SENA_PESSOA + 1)));
            }
        }
    }
    
    public void criaTeleSenas() {        
        for (int i = 0; i < teleSenas.length; i++) {
            teleSenas[i] = new TeleSena();
        }
    }
    
    /*public void vendeTeleSenas() {
        for (int i = 0; i < pessoas.length; i++) {
            for (int j = 0; j < pessoas[i].getTeleSenasCompradas().length; j++) {
                pessoas[i].getTeleSenasCompradas()[j] = new TeleSena();
            }
        }
    }*/
    
    public void vendeTeleSenas() {
        // pegar as Pessoas
        // varrer cada lista de TS compradas delas
        // Adicionar TS criadas nessa lista
        /*for (int i = 0; i < teleSenas.length; i++) {
            for (int j = 0; j < pessoas.length; j++) {
                for (int k = 0; k < pessoas[j].getTeleSenasCompradas().length; k++) {
                    if (pessoas[j].getTeleSenasCompradas()[k] == null) {
                        pessoas[j].getTeleSenasCompradas()[k] = teleSenas[i];
                    } else
                        break;
                }   
            }
        }*/
        int teleSenasVendidas = 0;
        for (int j = 0; j < pessoas.length; j++) {
            for (int k = 0; k < pessoas[j].getTeleSenasCompradas().length; k++) {
                if (pessoas[j].getTeleSenasCompradas()[k] == null) {
                    pessoas[j].getTeleSenasCompradas()[k] = teleSenas[teleSenasVendidas];
                    teleSenasVendidas += 1;
                } else
                    break;
            }
        }
        System.out.println("/////////////   " + teleSenasVendidas + " Tele Senas Vendidas! ////////");
    }
    
    public int[] sorteiaNumerosIniciais() {
        int[] numerosInicias = new int[25]; //25 original
        int numeroSorteado;
        boolean encontrou, jaTem;
        
        //System.out.println("Os números inicias sorteados são:");
        
        for (int i = 0; i < numerosInicias.length; i++) {
            encontrou = false;
            while (!encontrou) {
                jaTem = false;
                numeroSorteado = (int)(Math.random() * 60 + 1);
                for (int j = 0; j < numerosInicias.length; j++) {
                    if (numeroSorteado == numerosInicias[j]) {
                        jaTem = true;
                        break;
                    }
                }
                if (!jaTem) {
                   encontrou = true;
                   numerosInicias[i] = numeroSorteado;
                }
            }
            //System.out.print(numerosInicias[i] + ", ");
        }
        
        return numerosInicias;
        
        
        //conferir se alguma Tele Sena comprada tem todos os números sorteados
        /*int quantidadeNumerosSorteados = 25;
        boolean sorteioComGanhador = false;
        boolean conjuntoGanhador = false;
        int quantidadeGanhadores = 0;
        String nomesGanhadores = "";
        while (!sorteioComGanhador) {
            for (int i = 0; i < numerosInicias.length; i++) {
                for (int j = 0; j < pessoas.length; j++) {
                    for (int k = 0; k < pessoas[j].getTeleSenasCompradas().length; k++) {
                        // if (pessoas[j].getTeleSenasCompradas()[k] == null) {}
                        int acertos1 = 0;
                        for (int l = 0; l < pessoas[j].getTeleSenasCompradas()[k].getConjunto1().length; l++) {
                            if (pessoas[j].getTeleSenasCompradas()[k].getConjunto1()[l] == numerosInicias[i]) {
                                acertos1 += 1;
                            }
                        }
                        int acertos2 = 0;
                        for (int l = 0; l < pessoas[j].getTeleSenasCompradas()[k].getConjunto2().length; l++) {
                            if (pessoas[j].getTeleSenasCompradas()[k].getConjunto2()[l] == numerosInicias[i]) {
                                acertos2 += 1;
                            }
                        }
                        if (acertos1 == quantidadeNumerosSorteados || acertos2 == quantidadeNumerosSorteados) {
                            sorteioComGanhador = true;
                            quantidadeGanhadores += 1;
                            nomesGanhadores += pessoas[j].getNome() + ", ";
                        }
                    }
                }
            }
            
        }
        
        
        System.out.println("Quantidade ganhadores: " + quantidadeGanhadores + "\nNomes dos ganhadores: " + nomesGanhadores);
        */
    }


    public boolean verificaGanhadores(int[] numerosSorteados) {
        boolean sorteioComGanhador = false;
        //boolean conjuntoGanhador = false;
        int quantidadeGanhadores = 0;
        String nomesGanhadores = "";
        
        for (int j = 0; j < pessoas.length; j++) {
            for (int k = 0; k < pessoas[j].getTeleSenasCompradas().length; k++) {
                // if (pessoas[j].getTeleSenasCompradas()[k] == null) {}
                int acertos1 = 0;
                for (int l = 0; l < pessoas[j].getTeleSenasCompradas()[k].getConjunto1().length; l++) {
                    
                    for (int m = 0; m < numerosSorteados.length; m++) {
                        if (pessoas[j].getTeleSenasCompradas()[k].getConjunto1()[l] == numerosSorteados[m]) {
                            acertos1 += 1;
                            System.out.println("Conj 1 da TS do " + pessoas[j].getNome() + " acertou o número: " + numerosSorteados[m]);
                        }
                    }
                }
                int acertos2 = 0;
                for (int l = 0; l < pessoas[j].getTeleSenasCompradas()[k].getConjunto2().length; l++) {
                    
                    for (int m = 0; m < numerosSorteados.length; m++) {
                        if (pessoas[j].getTeleSenasCompradas()[k].getConjunto2()[l] == numerosSorteados[m]) {
                            acertos2 += 1;
                            System.out.println("Conj 2 da TS do " + pessoas[j].getNome() + " acertou o número: " + numerosSorteados[m]);
                        }
                    }
                    
                }
                if (acertos1 == numerosSorteados.length || acertos2 == numerosSorteados.length) {
                    sorteioComGanhador = true;
                    quantidadeGanhadores += 1;
                    nomesGanhadores += pessoas[j].getNome() + ", ";
                }
            }
        }
        System.out.println("Sorteio com ganhador? " + sorteioComGanhador + " | Quantidade de ganhadores: " + quantidadeGanhadores + " | Nome dos ganhadores: " + nomesGanhadores);
        return sorteioComGanhador;
    }
    
    public int[] sorteiaNumeroExtra(int[] sorteioAtual) {
        // Cria array com +1 espaço para o número extra
        int[] numerosIniciasMaisExtra = new int[(sorteioAtual.length + 1)]; //25 original + 1
        
        // Copia array de numeros sorteados iniciais para novo array com +1 espaço
        for (int i = 0; i < sorteioAtual.length; i++) {
                numerosIniciasMaisExtra[i] = sorteioAtual[i];
        }
        
        int numeroSorteado;
        boolean encontrou, jaTem;
        
        //System.out.println("Os números inicias sorteados são:");
        
        for (int i = 0; i < numerosIniciasMaisExtra.length; i++) {
            encontrou = false;
            while (!encontrou) {
                jaTem = false;
                numeroSorteado = (int)(Math.random() * 60 + 1);
                for (int j = 0; j < numerosIniciasMaisExtra.length; j++) {
                    if (numeroSorteado == numerosIniciasMaisExtra[j]) {
                        jaTem = true;
                        break;
                    } else if (numerosIniciasMaisExtra[j] == 0) {
                        numerosIniciasMaisExtra[j] = numeroSorteado;
                    }
                }
                if (!jaTem) {
                   encontrou = true;
                   // numerosIniciasMaisExtra[i] = numeroSorteado;
                }
            }
            //System.out.print(numerosInicias[i] + ", ");
        }
        
        //return numerosIniciasMaisExtra;
        
        /*int numeroSorteado;
        boolean encontrou, jaTem;
        
        //System.out.println("Os números inicias sorteados são:");
        encontrou = false;
        while (!encontrou) {
            numeroSorteado = (int)(Math.random() * 60 + 1);
            for (int j = 0; j < numerosIniciasMaisExtra.length; j++) {
                if (numeroSorteado == numerosIniciasMaisExtra[j]) {
                    jaTem = true;
                    break;
                } else if (numerosIniciasMaisExtra[j] == 0)
                    numerosIniciasMaisExtra[j] = numeroSorteado;
                    encontrou = true;
                    break;
            }
        }
        
        /*for (int i = 0; i < numerosIniciasMaisExtra.length; i++) {
            encontrou = false;
            while (!encontrou) {
                jaTem = false;
                numeroSorteado = (int)(Math.random() * 60 + 1);
                for (int j = 0; j < numerosIniciasMaisExtra.length; j++) {
                    if (numeroSorteado == numerosIniciasMaisExtra[j]) {
                        jaTem = true;
                        break;
                    } else if (numerosIniciasMaisExtra[j] == 0)
                        numerosIniciasMaisExtra[j] = numeroSorteado;
                }
                if (!jaTem) {
                   encontrou = true;
                   numerosIniciasMaisExtra[i] = numeroSorteado;
                }
            }
            //System.out.print(numerosInicias[i] + ", ");
        }*/
        
        return numerosIniciasMaisExtra;
        
    }
    
    public void realizaSorteio() {
        //gerar 25 números aleatórios não repetidos
        //conferir se alguma Tele Sena comprada tem todos os números sorteados
            // pegar primeiro numero sorteado e olhar se tem em algum conjunto
            // se tem, pegar segundo numero, se tem = pergar terceiro numero
            // se terminou de varrer numeros sorteados e cartela tem todos = ganhador
        //caso não, sortear +1 número aleatório e não repetido e conferir de novo
        //fazer isso até (while) ter mínimo 1 ganhador
        // int[] sorteioInicial = 
        
        int quantidadeSorteios = 1;
        
        int[] numerosSorteados = sorteiaNumerosIniciais();
        
        System.out.println("Os números inicias sorteados são:");
        for (int i = 0; i < numerosSorteados.length; i++)
            System.out.print(numerosSorteados[i] + ", ");
        
        /*   
        verificaGanhadores(numerosSorteados);
        System.out.println("O sorteio de número " + quantidadeSorteios + " com número extra ficou:");
            for (int i = 0; i < numerosSorteados.length; i++)
                System.out.print(numerosSorteados[i] + ", ");
        
        numerosSorteados = sorteiaNumeroExtra(numerosSorteados);
        quantidadeSorteios += 1;
        
        verificaGanhadores(numerosSorteados);
        System.out.println("O sorteio de número " + quantidadeSorteios + " com número extra ficou:");
            for (int i = 0; i < numerosSorteados.length; i++)
                System.out.print(numerosSorteados[i] + ", ");
        */
       
        boolean temosGanhadores = false;
        
        while(temosGanhadores == false) {
            boolean temGanhadores = verificaGanhadores(numerosSorteados);
            
            if (temGanhadores) {
                temosGanhadores = true;
                break;
            } else {
            
                numerosSorteados = sorteiaNumeroExtra(numerosSorteados);
                quantidadeSorteios += 1;
            }
            
            
            System.out.println("O sorteio de número " + quantidadeSorteios + " com número extra ficou:");
            for (int i = 0; i < numerosSorteados.length; i++)
                System.out.print(numerosSorteados[i] + ", ");
                
            
        }
        
        
        // int[] sorteioExtra = sorteiaNumeroExtra(numerosSorteados);
        
        
    }
    
    public static void main(String[] args) {
        ControleTeleSena cts = new ControleTeleSena();
        
        //Pessoa[] part = cts.cadastraPessoas();
        
        cts.cadastraPessoas();
        
        // cts.vendeTeleSenas();
        cts.criaTeleSenas();
        cts.vendeTeleSenas();
        
        cts.realizaSorteio();
        
        /*for (int i = 0; i < cts.getTeleSenas().length; i++) {
            System.out.print("Tele Sena nº" + (i + 1) + cts.getTeleSenas()[i] + ", ");
        }*/
        
        
        

        //cts.setPessoas(part);
        
        /*for (int i = 0; i < cts.getPessoas().length; i++) {
            System.out.println(cts.getPessoas()[i]);
        }*/
    }
}