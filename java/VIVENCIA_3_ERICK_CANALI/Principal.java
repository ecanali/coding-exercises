public class Principal {
    public static void main(String[] args) {
        Teclado t = new Teclado();
        
        // Cria um array de Time entre 1 e 50 elementos escolhido por usuário
        int quantTimes = 0;
        while (quantTimes < 1 || quantTimes > 50) {
            quantTimes = t.leInt("Digite a quantidade de times que serão inseridos:");
        }
        Time[] times = new Time[quantTimes];
                
        // Preenche o array de Time com informações do usuário alternando entre 1ª e 2ª divisões
        int sorteio;
        String nome;
        int quantMaxSocios;
        for (int i = 0; i < times.length; i++) {
            nome = t.leString("Digite o nome do " + (i + 1) + "º time:");
            quantMaxSocios = t.leInt("Digite a quantidade máxima de sócios do " + (i + 1) + "º time:");
            sorteio = (int)(Math.random() * 2 + 1);
            if (sorteio == 1)
                times[i] = new PrimeiraDivisao(nome, quantMaxSocios, t.leInt("Digite a posição no ranking nacional do " + (i + 1) + "º time:"));    
            else
                times[i] = new SegundaDivisao(nome, quantMaxSocios, t.leInt("Digite a quantidade de anos seguidos na 2ª divisão do " + (i + 1) + "º time:"));
        }
        
        for (int i = 0; i < times.length; i++) {
            System.out.println(times[i]);
        }
    }
}