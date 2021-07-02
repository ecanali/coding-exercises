public class Teste {
    public static void main(String[] args) {
        int idade;
        idade = 10;
        String nome = "George";
        double altura = 1.45;
        boolean correto = true;
        char sexo = 'M';
        
        System.out.println("Programador boladão");
        System.out.print("Olé!");
        System.out.println("Fim, grudado!");
        
        System.out.println(altura);

        System.out.println("A idade de " + nome + " é " + idade + " anos.");
        
        int quantidade = Teclado.leInt("Digite a quantidade:");
        String cidade = Teclado.leString("Digite a cidade:");
        double renda = Teclado.leDouble("Digite a renda:");
        char opcao = Teclado.leChar("Digite sua opção:");
        
        System.out.println("A quantidade informada é: " + quantidade);
        
        System.out.println("A altura informada é: " + altura);
    }
}