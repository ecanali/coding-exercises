public class Teste {
    public static void main(String[] args) {
        Banana banana1 = new Banana("Banana", 2.49, "Caturra");
        Melancia melancia1 = new Melancia("Melancia", 8.79, 1.5, true);
        Programador programador1 = new Programador("Erick", 28, "JavaScript");
        Aluno aluno1 = new Aluno("Denis", 25, 8.7);
        
        System.out.println(banana1.getTipo());
        banana1.setTipo("Catarina");
        System.out.println(banana1.getTipo());
        
        System.out.println();
        
        System.out.println(melancia1.calculaPrecoFinal());
        melancia1.setEpoca(false);
        melancia1.setPreco(5);
        System.out.println(melancia1.calculaPrecoFinal());
        
        System.out.println();

        programador1.imprimeDados();
        
        System.out.println();
        
        aluno1.imprimeDados();
        
        System.out.println();
        
        Teclado t = new Teclado();
        Pessoa p;
        int resposta = 0;
        while (resposta != 1 || resposta != 2) {
            resposta = t.leInt("Digite a opção desejada:\n1) Para Programador\n2) Para Aluno");
            if (resposta == 1) {
                p = new Programador(t.leString("Qual nome?"), t.leInt("Qual idade?"), t.leString("Qual linguagem preferida?"));
                Programador programador2 = (Programador) p;
                System.out.println("A linguagem preferida de " + programador2.getNome() + " é: " + programador2.getLinguagemPreferida());
                break;
            } else if (resposta == 2) {
                p = new Aluno(t.leString("Qual nome?"), t.leInt("Qual idade?"), t.leDouble("Qual nota?"));
                Aluno aluno2 = (Aluno) p;
                System.out.println("A nota de " + aluno2.getNome() + " é: " + aluno2.getNota());
                break;
            }
        }
    }
}