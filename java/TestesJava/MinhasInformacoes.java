public class MinhasInformacoes {
    public static void main(String[] args) {
        String nome = Teclado.leString("Digite seu nome:");
        double altura = Teclado.leDouble("Digite sua altura:");
        String dataNascimento = Teclado.leString("Digite sua data de nascimento dd/mm/aa:");
        String rg = Teclado.leString("Digite seu RG:");
        String rua = Teclado.leString("Digite sua rua:");
        int numero = Teclado.leInt("Digite o número da residência:");
        String complemento = Teclado.leString("Digite o complemento:");
        
        System.out.println("Nome: " + nome);
        System.out.println("Altura: " + altura);
        System.out.println("Data de nascimento: " + dataNascimento + " - RG: " + rg);
        System.out.println("Endereço: " + rua + " - Número: " + numero + " - Complemento: " + complemento);        
    }
}