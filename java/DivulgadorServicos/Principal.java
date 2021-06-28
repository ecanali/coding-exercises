public class Principal {
    public static void main(String[] args) {
        Controle controle = new Controle();
        
        //controle.cadastraClienteTeclado();
        
        Cliente cli1 = new Cliente("Rodrigo", "rod", "rod123");
                
        controle.cadastraCliente(cli1);  
        
        for (int i = 0; i < controle.getClientes().length; i++)
            System.out.println(controle.getClientes()[i]);
            
        System.out.println(controle.loginCliente());
    }
}