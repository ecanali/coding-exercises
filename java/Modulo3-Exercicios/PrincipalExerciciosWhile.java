public class PrincipalExerciciosWhile {
    public static void main(String[] args) {
        ExerciciosWhile exercicio = new ExerciciosWhile(10);
        
        while (true) {
            System.out.println("MENU:\n1. conta até 300\n2. imprime pares\n3. verifica primo");
            int opcaoDesejada = Teclado.leInt("Digite o número da opção desejada: ");
            
            if (opcaoDesejada == 1)
                exercicio.contador(Teclado.leInt("A partir de que número deseja contar?"));
            else if (opcaoDesejada == 2)
                exercicio.imprimePares(Teclado.leInt("A partir de que número deseja imprimir os pares?"));
            else if (opcaoDesejada == 3) {
                int resposta = Teclado.leInt("Qual número deseja verificar se é primo?");
                if (exercicio.verificaPrimo(resposta))
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