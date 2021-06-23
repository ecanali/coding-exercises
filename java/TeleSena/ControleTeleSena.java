public class ControleTeleSena {
    private final int MAX_PESSOAS = 10; //20 original
    private final int MAX_TELE_SENA_VENDA = 100; //300 original
    private final int MAX_TELE_SENA_PESSOA = 5; //15 original
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
    
    public void sorteia25NumerosIniciais() {
        int[] numerosInicias = new int[25];
        int numeroSorteado;
        boolean encontrou, jaTem;
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
        
        //conferir se alguma Tele Sena comprada tem todos os números sorteados
        int quantidadeNumerosSorteados = 25;
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
        
    }
    
    public static void main(String[] args) {
        ControleTeleSena cts = new ControleTeleSena();
        
        //Pessoa[] part = cts.cadastraPessoas();
        
        cts.cadastraPessoas();
        
        // cts.vendeTeleSenas();
        cts.criaTeleSenas();
        cts.vendeTeleSenas();
        
        cts.sorteia25NumerosIniciais();
        
        /*for (int i = 0; i < cts.getTeleSenas().length; i++) {
            System.out.print("Tele Sena nº" + (i + 1) + cts.getTeleSenas()[i] + ", ");
        }*/
        
        
        

        //cts.setPessoas(part);
        
        /*for (int i = 0; i < cts.getPessoas().length; i++) {
            System.out.println(cts.getPessoas()[i]);
        }*/
    }
}