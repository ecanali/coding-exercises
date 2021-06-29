public class Principal {
    public static void main(String[] args) {
        Controle controle = new Controle();
        
        //controle.cadastraClienteTeclado();
        
        Cliente cli1 = new Cliente("Rodrigo", "rod", "rod123");
                
        controle.cadastraCliente(cli1);
        
        //controle.criaClientesAleatorios(3);
        
        //for (int i = 0; i < controle.getClientes().length; i++)
        //    System.out.println(controle.getClientes()[i]);
            
        controle.criaEmpresasClientesAleatorios(5, 3);
        
        
        
        for (int i = 0; i < controle.getEmpresas().length; i++)
            System.out.println(controle.getEmpresas()[i]);
        
        
        for (int i = 0; i < controle.getClientes().length; i++)
            System.out.println(controle.getClientes()[i]);
        
            
        //System.out.println(controle.loginCliente());
        
        
        /*System.out.println("Cadastro de Empresa com sucesso? " + controle.cadastraEmpresaTeclado());
        for (int i = 0; i < controle.getEmpresas().length; i++)
            System.out.println(controle.getEmpresas()[i]);*/
            
        //System.out.println("Login empresa com sucesso? " + controle.loginEmpresa());
        controle.inicio();
        

    }
}