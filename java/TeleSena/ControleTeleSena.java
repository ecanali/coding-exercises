// Organiza e gerencia todo o sorteio, desde os participantes, suas Tele Senas e o sorteio dos números
public class ControleTeleSena {
    private final int MAX_PESSOAS = 20;
    private final int MAX_TELE_SENA_VENDA = 300;
    private final int MAX_TELE_SENA_PESSOA = 15;
    private Pessoa[] pessoas;
    private TeleSena[] teleSenas;
    private int[] numerosSorteadosFinais;
    private int teleSenasVendidas;
    private int quantidadeGanhadores;
    private String nomesGanhadores;
    
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
    
    // Cria combinações de nomes de pessoas aleatoriamente
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
        System.out.println(pessoas.length + " Pessoas cadastradas com sucesso!");
    }
    
    // Cria de antemão o estoque de Tele Senas disponíveis para venda
    public void criaTeleSenas() {        
        for (int i = 0; i < teleSenas.length; i++)
            teleSenas[i] = new TeleSena();
        System.out.println(teleSenas.length + " Tele Senas criadas com sucesso!");
    }
    
    // Direciona Tele Senas para cada pessoa conforme a quantidade que cada um compra a partir do estoque já disponível 
    public void vendeTeleSenas() {
        teleSenasVendidas = 0;
        for (int j = 0; j < pessoas.length; j++) {
            for (int k = 0; k < pessoas[j].getTeleSenasCompradas().length; k++) {
                if (pessoas[j].getTeleSenasCompradas()[k] == null) {
                    pessoas[j].getTeleSenasCompradas()[k] = teleSenas[teleSenasVendidas];
                    teleSenasVendidas += 1;
                } else
                    break;
            }
        }
        System.out.println(teleSenasVendidas + " Tele Senas vendidas!");
    }
    
    // Sorteia os 25 primeiros números da Tele Sena entre 1 e 60 aleatóriamente e não repetindo
    public int[] sorteiaNumerosIniciais() {
        int[] numerosInicias = new int[25];
        int numeroSorteado;
        boolean encontrou, jaTem;
        System.out.println("Os números inicias sorteados são:");
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
            System.out.print(numerosInicias[i] + ", ");
        }
        return numerosInicias;
    }

    // Verifica cada número sorteado em cada conjunto de cada Tele Sena de cada participante, identificando se há ganhador
    public boolean verificaGanhadores(int[] numerosSorteados) {
        boolean sorteioComGanhador = false;
        quantidadeGanhadores = 0;
        nomesGanhadores = "";
        for (int j = 0; j < pessoas.length; j++) {
            System.out.println("Verificando " + pessoas[j].getNome() + " | Tele Senas compradas: " + pessoas[j].getTeleSenasCompradas().length);
            for (int k = 0; k < pessoas[j].getTeleSenasCompradas().length; k++) {
                System.out.println("Verificando Tele Sena " + (k + 1) + "...");
                int acertosConjunto1 = 0;
                for (int l = 0; l < pessoas[j].getTeleSenasCompradas()[k].getConjunto1().length; l++) {
                    for (int m = 0; m < numerosSorteados.length; m++) {
                        if (pessoas[j].getTeleSenasCompradas()[k].getConjunto1()[l] == numerosSorteados[m]) {
                            acertosConjunto1 += 1;
                            System.out.print(numerosSorteados[m] + ", ");
                        }
                    }
                }
                System.out.println("Conjunto 1 acertou " + acertosConjunto1 + " números");
                int acertosConjunto2 = 0;
                for (int l = 0; l < pessoas[j].getTeleSenasCompradas()[k].getConjunto2().length; l++) {
                    for (int m = 0; m < numerosSorteados.length; m++) {
                        if (pessoas[j].getTeleSenasCompradas()[k].getConjunto2()[l] == numerosSorteados[m]) {
                            acertosConjunto2 += 1;
                            System.out.print(numerosSorteados[m] + ", ");
                        }
                    }
                }
                System.out.println("Conjunto 2 acertou " + acertosConjunto2 + " números");
                if (acertosConjunto1 == 25 || acertosConjunto2 == 25) {
                    sorteioComGanhador = true;
                    quantidadeGanhadores += 1;
                    nomesGanhadores += pessoas[j].getNome() + ", ";
                }
            }
        }
        System.out.println("Sorteio com ganhador? " + sorteioComGanhador + " | Quantidade de ganhadores: " + quantidadeGanhadores + " | Nome dos ganhadores: " + nomesGanhadores);
        return sorteioComGanhador;
    }
    
    // Cria novo array de números sorteados a partir dos 25 primeiros com novo número aleatório e não repetido
    public int[] sorteiaNumeroExtra(int[] sorteioAtual) {
        // Cria array com +1 espaço para o número extra
        int[] numerosIniciasMaisExtra = new int[(sorteioAtual.length + 1)];
        // Copia array de numeros sorteados iniciais para novo array com +1 espaço
        for (int i = 0; i < sorteioAtual.length; i++) {
                numerosIniciasMaisExtra[i] = sorteioAtual[i];
        }
        System.out.println("Números sorteados totais: " + numerosIniciasMaisExtra.length);
        System.out.println("Os números inicias mais o número extra são:");
        int numeroSorteado;
        boolean encontrou, jaTem;
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
                if (!jaTem)
                   encontrou = true;
            }
            System.out.print(numerosIniciasMaisExtra[i] + ", ");
        }
        return numerosIniciasMaisExtra;
    }
    
    // Sorteia a primeira vez e não havendo ganhadores continua sorteando novos números até alguém ganhar
    public void realizaSorteio() {        
        int[] numerosSorteados = sorteiaNumerosIniciais();
        boolean temosGanhadores = false;
        while(!temosGanhadores) {
            temosGanhadores = verificaGanhadores(numerosSorteados);
            numerosSorteados = sorteiaNumeroExtra(numerosSorteados);
        }
        numerosSorteadosFinais = numerosSorteados;
    }
    
    // Imprime na tela informações relevantes do sorteio
    public void informaResultados() {
        System.out.println("\n\n## RESULTADOS DO SORTEIO:");
        System.out.print("// Números sorteados (total = " + numerosSorteadosFinais.length + "): ");
        for (int i = 0; i < numerosSorteadosFinais.length; i++)
            System.out.print(numerosSorteadosFinais[i] + ", ");
        System.out.println("\n// Tele Senas vendidas: " + teleSenasVendidas);
        System.out.println("// Quantidade de ganhadores: " + quantidadeGanhadores);
        System.out.println("// Nome(s) do(s) ganhador(es): " + nomesGanhadores);
        double valorTotalTSVendidas = teleSenasVendidas * teleSenas[0].getValorVenda();
        System.out.println("// Valor do prêmio para cada ganhador: R$" + ((valorTotalTSVendidas * 0.8) / quantidadeGanhadores));
        System.out.println("// Valor total das Tele Senas vendidas: R$" + valorTotalTSVendidas);
        System.out.println("// Lucro obtido pelo Sílvio Santos com a Tele Sena: R$" + (valorTotalTSVendidas * 0.2));
    }
}