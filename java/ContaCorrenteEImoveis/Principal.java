public class Principal { 
    public static void main(String[] args) {
        int numeroContaCorrente = Teclado.leInt("Digite o número da Conta Corrente:");
        double saldoContaCorrente = Teclado.leDouble("Digite o saldo da Conta Corrente:");
        
        ContaCorrente minhaConta = new ContaCorrente(numeroContaCorrente, saldoContaCorrente);
        
        // Executa ações de acordo com opção escolhida em menu da conta corrente
        int opcaoEscolhida = 0;
        while (opcaoEscolhida != 4) {
            opcaoEscolhida = Teclado.leInt("Digite uma opção do menu:\n1) Efetuar um saque\n2) Efetuar um depósito\n3) Imprimir informações da conta\n4) Sair do menu");
            
            if (opcaoEscolhida == 1) {
                double valorSaqueDesejado = Teclado.leDouble("Digite o valor que deseja sacar:");
                minhaConta.efetuaSaque(valorSaqueDesejado);
            } else if (opcaoEscolhida == 2) {
                double valorDepositoDesejado = Teclado.leDouble("Digite o valor que deseja depositar:");
                minhaConta.efetuaDeposito(valorDepositoDesejado);
            } else if (opcaoEscolhida == 3)
                System.out.println(minhaConta);
            else if (opcaoEscolhida == 4) {
                System.out.println("Você saiu do menu.");
                break;
            } else
                System.out.println("Erro: opção inválida. Tente novamente.");
        }        
        
        System.out.println("Por favor, cadastre 3 imóveis");
        
        // Cria 3 objetos de Imovel com inputs do usuário e mostra informações
        for (int numImovel = 0; numImovel < 3; numImovel++) {
            
            double valorVenda = 0;
            double valorAluguel = 0;
            
            String endereco = Teclado.leString("Digite o endereço do " + (numImovel + 1) + "º imóvel:");
            while (valorVenda <= 0)
                valorVenda = Teclado.leDouble("Digite o valor de venda do " + (numImovel + 1) + "º imóvel:");
            while (valorAluguel <= 0)
                valorAluguel = Teclado.leDouble("Digite o valor de aluguel do " + (numImovel + 1) + "º imóvel:");
            char novo = Teclado.leChar("O " + (numImovel + 1) + "º imóvel é novo? [S/N]");
            boolean isNovo = (novo == 'S' || novo == 's') ? true : false;
            
            Imovel meuImovel = new Imovel(endereco, valorVenda, valorAluguel, isNovo);
            
            System.out.println("As informações do " + (numImovel + 1) + "º imóvel são:");
            System.out.println(meuImovel);
            System.out.println("O valor do imposto do " + (numImovel + 1) + "º imóvel é R$" + meuImovel.calculaImposto());
        }
    }
}