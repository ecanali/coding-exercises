public class Principal {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Programacao para Juniors", "Mateus Raeder", 2006, 87.90, 250);
        Livro livro2 = new Livro("Pintura para Plenos", "Marco Kich", 2015, 95.50, 312);
        Livro livro3 = new Livro("Ingles para Seniors", "Anderson Barcelos", 1997, 66.80, 293);
        
        Cliente cliente1 = new Cliente("Ricardo", 17, 'M', "ricardo@gmail.com", "ricardo123");
        Cliente cliente2 = new Cliente("Joana", 23, 'F', "joana@gmail.com", "joana123");
        Cliente cliente3 = new Cliente("Carlos", 19, 'M', "carlos@gmail.com", "carlos123");
        
        System.out.println("O preço por página do livro " + livro1.getTitulo() + " é: R$" + String.format("%.2f", livro1.calcularPrecoPorPagina()));
        System.out.println("O preço por página do livro " + livro2.getTitulo() + " é: R$" + String.format("%.2f", livro2.calcularPrecoPorPagina()));
        System.out.println("O preço por página do livro " + livro3.getTitulo() + " é: R$" + String.format("%.2f", livro3.calcularPrecoPorPagina()));
        
        livro1.imprimeInfo();
        livro2.imprimeInfo();
        livro3.imprimeInfo();
        
        cliente1.imprimeInformacoes();
        cliente2.imprimeInformacoes();
        cliente3.imprimeInformacoes();
    }
}