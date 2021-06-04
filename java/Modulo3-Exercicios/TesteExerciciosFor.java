public class TesteExerciciosFor {
    public static void main(String[] args) {
        ExerciciosFor teste = new ExerciciosFor();
    
        teste.exercicio1(Teclado.leInt("Digite a quantidade de pessoas desejada:"));
        teste.exercicio2(Teclado.leInt("Digite o valor final da impressão da sequência:"));
        teste.exercicio3(Teclado.leInt("Digite o valor final da impressão dos pares:"));
        teste.exercicio4(Teclado.leInt("Digite o valor final da impressão decrescente:"));
        teste.exercicio5(Teclado.leInt("Digite a quantidade de pessoas que inserirão seus times:"));
        double teste6 = teste.exercicio6(Teclado.leInt("Digite a quantidade de números flutuantes desejada:"));
        System.out.println("A soma dos números digitados é: " + teste6);
        teste.exercicio7();
        teste.exercicio8();
        int exercicio9Val1 = Teclado.leInt("Digite o primeiro valor:");
        int exercicio9Val2 = Teclado.leInt("Digite o segundo valor:");
        teste.exercicio9(exercicio9Val1, exercicio9Val2);
        System.out.println(teste.exercicio10());
        int exercicio11Val1 = Teclado.leInt("Digite o primeiro valor:");
        int exercicio11Val2 = Teclado.leInt("Digite o segundo valor:");
        System.out.println("A soma dos valores ímpares entre os dois valores é: " + teste.exercicio11(exercicio11Val1, exercicio11Val2));
        System.out.println("A média dos números informados é: " + String.format("%.2f", teste.exercicio12()));
        int exercicio13inteiro = Teclado.leInt("Digite um número inteiro:");
        System.out.println("O fatorial do número informado é: " + teste.exercicio13(exercicio13inteiro));
        int exercicio14inteiro = Teclado.leInt("Digite um número inteiro:");
        if (teste.exercicio14(exercicio14inteiro))
            System.out.println("O número informado é primo.");
        else
            System.out.println("O número informado não é primo.");
        teste.exercicio15(Teclado.leInt("Digite um número para saber a soma dos primos antecessores:"));
    }
}