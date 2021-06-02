public class PrincipalPessoa {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Joaquim", 'M', 19, 1.78, 0, "Rua C, 145");
        Pessoa pessoa2 = new Pessoa("Manuelita", 'F', 30, 1.67, 3, "Rua dos Camelos, 12");
        Pessoa pessoa3 = new Pessoa("Pedro", 'M', 10, 1.91, 1, "Rua dos Gigantes, 189");
        
        pessoa1.imprimeInformacoes();
        if (pessoa1.isFilhoUnico() && pessoa1.getSexo() == 'M')
            System.out.println(pessoa1.getNome() + " é Filho único");
        else if (pessoa1.isFilhoUnico() && pessoa1.getSexo() == 'F')
            System.out.println(pessoa1.getNome() + " é Filha única");
        else if (!pessoa1.isFilhoUnico() && pessoa1.getSexo() == 'M')
            System.out.println(pessoa1.getNome() + " Não é filho único");
        else
            System.out.println(pessoa1.getNome() + " Não é filha única");
        
        pessoa2.imprimeInformacoes();
        if (pessoa2.isFilhoUnico() && pessoa2.getSexo() == 'M')
            System.out.println(pessoa2.getNome() + " é Filho único");
        else if (pessoa2.isFilhoUnico() && pessoa2.getSexo() == 'F')
            System.out.println(pessoa2.getNome() + " é Filha única");
        else if (!pessoa2.isFilhoUnico() && pessoa2.getSexo() == 'M')
            System.out.println(pessoa2.getNome() + " Não é filho único");
        else
            System.out.println(pessoa2.getNome() + " Não é filha única");
            
        pessoa3.imprimeInformacoes();
        if (pessoa3.isFilhoUnico() && pessoa3.getSexo() == 'M')
            System.out.println(pessoa3.getNome() + " é Filho único");
        else if (pessoa3.isFilhoUnico() && pessoa3.getSexo() == 'F')
            System.out.println(pessoa3.getNome() + " é Filha única");
        else if (!pessoa3.isFilhoUnico() && pessoa3.getSexo() == 'M')
            System.out.println(pessoa3.getNome() + " Não é filho único");
        else
            System.out.println(pessoa3.getNome() + " Não é filha única");
    }
}