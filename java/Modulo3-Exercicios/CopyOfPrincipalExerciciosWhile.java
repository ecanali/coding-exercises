public class CopyOfPrincipalExerciciosWhile {
    public static void main(String[] args) {
        ExerciciosWhile exercicio = new ExerciciosWhile(10);
        
        while (true) {
            System.out.println("MENU:\n1. conta até 300\n2. imprime pares\n3. verifica primo");
            int opcaoDesejada = Teclado.leInt("Digite o número da opção desejada: ");
            
            if (opcaoDesejada == 1) {
                int resposta = Teclado.leInt("A partir de que número deseja contar?");
                exercicio.contador(resposta);
            } else if (opcaoDesejada == 2) {
                int resposta = Teclado.leInt("A partir de que número deseja imprimir os pares?");
                exercicio.imprimePares(resposta);
            } else if (opcaoDesejada == 3) {
                int resposta = Teclado.leInt("Qual número deseja verificar se é primo?");
                boolean avaliacao = exercicio.verificaPrimo(resposta);
                if (avaliacao)
                    System.out.println("O número " + resposta + " é primo.");
                else
                    System.out.println("O número " + resposta + " não é primo.");
            } else {
                System.out.println("Opção inválida.");
                break;
            }
        }
        System.out.println("Programa finalizado.");
    }
}
