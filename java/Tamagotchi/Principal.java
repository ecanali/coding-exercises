public class Principal {
    public static void main(String[] args) {
        System.out.println("Olá! Eu sou seu Tamagotchi, cuide de mim por favor!");
        
        Tamagotchi tamagotchi = new Tamagotchi(Teclado.leString("Qual é o meu nome?"));
        tamagotchi.estadoAtual();
                
        while (tamagotchi.getIsVivo()) {
            int sorteio = (int)(Math.random() * 3 + 1);
            
            if (sorteio == 1)
                tamagotchi.sentirSono();
            else if (sorteio == 2)
                tamagotchi.sentirFome();
            else
                tamagotchi.ficarEntediado();
                
            tamagotchi.estadoAtual();
        }
 
        System.out.println("Programa finalizado.");
    }
}
