public class ExerciciosFor {
    public void exercicio1(int quantidadePessoas) {
        for (int pessoa = 0; pessoa < quantidadePessoas; pessoa++)
            System.out.println(Teclado.leString("Digite o nome da " + (pessoa + 1) + "ª pessoa:"));
    }
    
    public void exercicio2(int valorFinal) {
        for (int valorContado = 0; valorContado <= valorFinal; valorContado++)
            System.out.println(valorContado);
    }
    
    public void exercicio3(int valorFinal) {
        if (valorFinal > 0) {
            for (int valorContado = 0; valorContado <= valorFinal; valorContado++) {
                if (valorContado % 2 == 0)
                    System.out.println(valorContado);
            }
        } else
            System.out.println("Erro: valor informado não pode ser negativo.");
    }
    
    public void exercicio4(int valorFinal) {
        if (valorFinal > 0) {
            for (int valorContado = valorFinal; valorContado >= 0; valorContado--)
                System.out.println(valorContado);
        } else
            System.out.println("Erro: valor informado não pode ser negativo.");
    }
    
    public void exercicio5(int quantidadeTimes) {
        int quantidadeGremio = 0;
        for (int time = 0; time < quantidadeTimes; time++) {
            String resposta = Teclado.leString("Digite o time da " + (time + 1) + "ª pessoa:");
            if (resposta.equals("gremio") || resposta.equals("grêmio") || resposta.equals("Gremio") || resposta.equals("Grêmio"))
                quantidadeGremio++;
        }
        System.out.println("A quantidade de torcedores para o Grêmio é: " + quantidadeGremio);
    }
    
    public double exercicio6(int quantidadeFlutuantes) {
        double somaFlutuantes = 0;
        for (int flutuante = 0; flutuante < quantidadeFlutuantes; flutuante++) {
            double resposta = Teclado.leDouble("Digite o " + (flutuante + 1) + "º número com ponto flutuante:");
            somaFlutuantes = somaFlutuantes + resposta;
        }
        return somaFlutuantes;
    }
    
    public void exercicio7() {
        int somaInteiros = 0;
        for (int inteiro = 0; inteiro < 10; inteiro++) {
            int resposta = Teclado.leInt("Digite o " + (inteiro + 1) + "º número inteiro:");
            somaInteiros = somaInteiros + resposta;
        }
        System.out.println("A soma dos 10 números inteiros informados é: " + somaInteiros);
    }
    
    public void exercicio8() {
        int quant = Teclado.leInt("Quantos números inteiros serão digitados?");
        for (int numero = 0; numero < quant; numero++) {
            int inteiroDigitado = Teclado.leInt("Digite o " + (numero + 1) + "º número inteiro:");
            if (inteiroDigitado > 0)
                System.out.println("O número digitado é positivo.");
            else if (inteiroDigitado < 0)
                System.out.println("O número digitado é negativo.");
            else
                System.out.println("O número digitado é zero.");
        }
    }
    
    public void exercicio9(int val1, int val2) {
        if (val1 > 0 && val2 > 0) {
            if (val1 < val2) {
                for (; val1 <= val2; val1++) {
                    if (val1 % 2 == 0)
                        System.out.println(val1);
                }
            } else {
                for (; val2 <= val1; val2++) {
                    if (val2 % 2 == 0)
                        System.out.println(val2);
                }
            }
        } else
            System.out.println("Erro: nenhum valor pode ser negativo.");
    }
    
    public int exercicio10() {
        int soma = 0;
        for (int numero = 0; numero <= 198; numero++)
            soma = soma + numero;
        return soma;
    }
    
    public int exercicio11(int val1, int val2) {
        int somaImpares = 0;
        if (val1 < val2) {
            for (; val1 < val2; val1++) {
                if (val1 % 2 != 0)
                    somaImpares = somaImpares + val1;
            }
        } else {
            for (; val2 < val1; val2++) {
                if (val2 % 2 != 0)
                    somaImpares = somaImpares + val2;
            }
        }
        return somaImpares;
    }
    
    public double exercicio12() {
        double quantidadeNumerosInformados = 0;
        double somaNumerosInformados = 0;
        for (;;) {
            double numInformado = Teclado.leInt("Digite um número positivo (negativo para sair):");
            if (numInformado < 0)
                break;
            quantidadeNumerosInformados += 1;
            somaNumerosInformados += numInformado;
        }
        return (somaNumerosInformados / quantidadeNumerosInformados);
    }
    
    public int exercicio13(int inteiro) {
        if (inteiro == 0 || inteiro == 1)
            return 1;
        else {
            int fatorial = inteiro;
            for (int contador = (inteiro - 1); contador > 0; contador--) {
                fatorial = fatorial * contador;
            }
            return fatorial;
        }
    }
    
    public boolean exercicio14(int inteiro) {
        boolean isPrimo = true;
        for (int contador = 2; contador < inteiro; contador++) {
            if (inteiro % contador == 0) {
                isPrimo = false;
                break;
            }
        }
        return isPrimo;
    }
    
    public void exercicio15(int valorFinal) {
        int somaPrimos = 0;
        for (int numeroAvaliado = 0; numeroAvaliado <= valorFinal; numeroAvaliado++) {
            boolean isPrimo = true;
            if (numeroAvaliado == 0 || numeroAvaliado == 1)
                isPrimo = false;
            else {
                for (int contador = 2; contador < numeroAvaliado; contador++) {
                    if (numeroAvaliado % contador == 0) {
                        isPrimo = false;
                        break;
                    }
                }
            }
            if (isPrimo) {
                System.out.println("O número " + numeroAvaliado + " é primo.");
                somaPrimos += numeroAvaliado;
            }
        }
        System.out.println("A soma de todos os números primos entre 0 e " + valorFinal + " é: " + somaPrimos);
    }
}