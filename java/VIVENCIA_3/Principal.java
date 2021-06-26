public class Principal {
    public static void main(String[] args) {
        Teclado t = new Teclado();
        
        System.out.println("// Cria um array de Time entre 1 e 50 elementos escolhido por usuário");
        int quantTimes = 0;
        while (quantTimes < 1 || quantTimes > 50) {
            quantTimes = t.leInt("Digite a quantidade de times que serão inseridos:");
        }
        Time[] times = new Time[quantTimes];
               
        System.out.println("// Preenche o array de Time com informações do usuário alternando entre 1ª e 2ª divisões");
        int sorteio;
        String nome;
        int quantMaxSocios;
        Time[] soPrimeiraDivisao = new Time[times.length];
        for (int i = 0; i < times.length; i++) {
            nome = t.leString("Digite o nome do " + (i + 1) + "º time:");
            quantMaxSocios = t.leInt("Digite a quantidade máxima de sócios do " + (i + 1) + "º time:");
            sorteio = (int)(Math.random() * 2 + 1);
            if (sorteio == 1) {
                times[i] = new PrimeiraDivisao(nome, quantMaxSocios, t.leInt("Digite a posição no ranking nacional do " + (i + 1) + "º time:"));    
                soPrimeiraDivisao[i] = times[i];
            } else
                times[i] = new SegundaDivisao(nome, quantMaxSocios, t.leInt("Digite a quantidade de anos seguidos na 2ª divisão do " + (i + 1) + "º time:"));
        }
        
        System.out.println("\n");
        
        System.out.println("// Insere 20 sócios em cada time do array");
        for (int n = 0; n < times.length; n++) {
            Socio[] novosSocios = new Socio[20];
            
            String[] primeiroNome = {"Roberto", "Mateus", "Mario", "Ricardo", "Cristiano"};
            String[] segundoNome = {"Onofre", "Raimundo", "Sebastian", "Luiz", "Adriano"};
            String[] ultimoNome = {"Pereira", "Oliveira", "Silva", "Santos", "Skywalker"};
            String[] nomes = new String[20];
            for (int i = 0; i < nomes.length; i++) {
                nomes[i] = primeiroNome[(int)(Math.random() * 5)] + " " + 
                            segundoNome[(int)(Math.random() * 5)] + " " + 
                            ultimoNome[(int)(Math.random() * 5)];
                for (int j = 0; j < novosSocios.length; j++) {
                    novosSocios[i] = new Socio(nomes[i], ((int)(Math.random() * 60 + 18)));
                }
            }
            boolean retorno = false;
            for (int k = 0; k < novosSocios.length; k++) {
                retorno = times[n].insereSocio(novosSocios[k]);
                
                if (retorno)
                    System.out.println(novosSocios[k].getNome() + " inserido com sucesso no time " + times[n].getNome());
                else
                    System.out.println("Erro ao tentar inserir " + novosSocios[k].getNome() + " no time " + times[n].getNome());
            }
        }
        
        System.out.println("\n");
        
        System.out.println("// Imprime as informações de todos os times do array");
        for (int i = 0; i < times.length; i++) {
            System.out.println(times[i]);
        }
        
        System.out.println("\n");
        
        System.out.println("// Imprime as informações de todos os sócios de todos os times");
        for (int i = 0; i < times.length; i++) {
            times[i].imprimeSocios();
        }
        
        System.out.println("\n");
        
        System.out.println("// Imprime o nome do sócio mais velho de cada um dos times presentes no array");
        for (int i = 0; i < times.length; i++) {
            System.out.println(times[i].getNome() + ": " + times[i].socioMaisVelho() + " é o sócio mais velho");
        }
        
        System.out.println("\n");
        
        System.out.println("// Imprime as informações do time da primeira divisão que está melhor colocado no ranking nacional de clubes");
        Time melhorColocado = null;
        for (int i = 0; i < soPrimeiraDivisao.length; i++) {
            if (soPrimeiraDivisao[i] != null) {
                melhorColocado = soPrimeiraDivisao[i];
            }
        }
        for (int i = 0; i < soPrimeiraDivisao.length; i++) {
            if (soPrimeiraDivisao[i] != null) {
                if (melhorColocado != null) {
                    if(((PrimeiraDivisao)soPrimeiraDivisao[i]).getPosicaoRankingNacional() < ((PrimeiraDivisao)melhorColocado).getPosicaoRankingNacional()) {
                        melhorColocado = soPrimeiraDivisao[i];
                    }
                }
            }
        }
        System.out.println(melhorColocado);
    }
}