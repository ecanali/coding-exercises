public class Tamagotchi {
    // Atributos principais
    private String nome;
    private int idade;
    private int peso;
    private boolean isVivo;
    private int diasSemDormir;
    
    // Método construtor
    public Tamagotchi(String nome) {
        // Iniciação de atributos
        this.nome = nome;
        idade = 0;
        peso = 1;
        isVivo = true;
        diasSemDormir = 0;
    }
    
    // Método de acesso
    public boolean getIsVivo() {
        return isVivo;
    }
    
    // Informa o status atual dos principais atributos do Tamagotchi
    public void estadoAtual() {
        System.out.println("Estado atual = Nome: " + nome + " | Idade: " + idade + " dia(s) | Peso: " + peso + " kg(s) | Dias sem dormir: " + diasSemDormir);
    }
    
    // Mata e informa o usuário a causa
    public void morrer(String causa) {
        if (causa.equals("envelheceu"))
            System.out.println("Que pena! " + nome + " viveu todos os seus dias e morreu :(");
        else if (causa.equals("explodiu"))
            System.out.println("Que pena! " + nome + " comeu de mais e morreu explodindo :(");
        else if (causa.equals("desnutriu"))
            System.out.println("Que pena! " + nome + " se desnutriu demais e morreu :(");
            
        isVivo = false;
    }
    
    // Põe para dormir e verifica se já não envelheceu demais
    public void dormir() {
        diasSemDormir = 0;
        idade += 1;
        
        if (idade == 15) {
            morrer("envelheceu");
        } else
            System.out.println(nome + " dormiu.");
    }
    
    // Verifica se peso não extrapolou o mínimo ou máximo permitidos
    public boolean isNutrido() {
        if (peso > 20) {
            morrer("explodiu");
            return false;
        } else if (peso <= 0) {
            morrer("desnutriu");
            return false;
        } else
            return true;
    }
    
    // Avisa usuário sobre o desejo de dormir e traz opções de reações
    public void sentirSono() {
        if (diasSemDormir == 5) {
            System.out.println(nome + " diz: Não consigo mais! ZzzZzzZz");
            dormir();
        } else {
            int opcaoEscolhida = Teclado.leInt(nome + " diz: Estou com sono!\nEscolha sua reação:\n1) Dormir\n2) Permanecer acordado");
        
            if (opcaoEscolhida == 2) {
                System.out.println(nome + " não dormiu.");    
                diasSemDormir += 1;
            } else
                dormir();
        }
    }
    
    // Avisa usuário sobre o desejo de comer e traz opções de reações
    public void sentirFome() {
        int opcaoEscolhida = Teclado.leInt(nome + " diz: Estou com fome!\nEscolha sua reação:\n1) Comer muito\n2) Comer pouco\n3) Não comer");
        
        if (opcaoEscolhida == 3) {
            System.out.println(nome + " não comeu.");
            peso -= 2;
        } else if (opcaoEscolhida == 1) {
            System.out.println(nome + " comeu muito.");
            peso += 5;
            if (isNutrido())
                dormir();
        } else {
            System.out.println(nome + " comeu pouco.");
            peso += 1;
        }
        
        if (isVivo)
            isNutrido();
    }
    
    // Avisa usuário sobre o desejo de exercício e traz opções de reações
    public void ficarEntediado() {
        int opcaoEscolhida = Teclado.leInt(nome + " diz: Estou com tédio!\nEscolha sua reação:\n1) Correr 10 minutos\n2) Caminhar 10 minutos");
        
        if (opcaoEscolhida == 1) {
            System.out.println(nome + " correu 10 minutos.");
            System.out.println(nome + " comeu muito.");
            peso += 1;
            if (isNutrido())
                dormir();
        } else {
            System.out.println(nome + " caminhou 10 minutos.");
            peso -= 1;
            if (isNutrido()) {
                estadoAtual();
                sentirFome();
            }
        }    
    }
}
