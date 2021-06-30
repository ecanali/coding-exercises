public class Principal {
    public static void main(String[] args) {
        Controle controle = new Controle();
            
        controle.criaEmpresasClientesAleatorios(5, 3);
        
        controle.inicio();
    }
}