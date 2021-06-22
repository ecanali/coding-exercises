public class ControleTeleSena {
    private Pessoa[] pessoas;
    private final int MAX_PESSOAS = 10; //20 original
    private final int MAX_TELE_SENA_VENDA = 100; //300 original
    private final int MAX_TELE_SENA_PESSOA = 5; //15 original
    private TeleSena[] teleSenas;
    
    public ControleTeleSena() {
        pessoas = new Pessoa[MAX_PESSOAS];
        teleSenas = new TeleSena[MAX_TELE_SENA_VENDA];
    }
    
    public Pessoa[] getPessoas() {
        return pessoas;
    }
    
    public void setPessoas(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }
    
    public void cadastraPessoas() {
        // Pessoa[] participantes = new Pessoa[MAX_PESSOAS];
        
        for (int i = 0; i < pessoas.length; i++) {
            pessoas[i] = new Pessoa(("Fulano 10" + i), ((int)(Math.random() * MAX_TELE_SENA_PESSOA + 1)));
        }
    }
    
    public void criaTeleSenasVenda() {        
        for (int i = 0; i < teleSenas.length; i++) {
            teleSenas[i] = new TeleSena();
        }
    }
    
    public void vendeTeleSenas() {
        for (int i = 0; i < pessoas.length; i++) {
            for (int j = 0; j < pessoas[i].getTeleSenasCompradas().length; j++) {
                pessoas[i].getTeleSenasCompradas()[j] = new TeleSena();
            }
        }
    }
    
    public static void main(String[] args) {
        ControleTeleSena cts = new ControleTeleSena();
        
        //Pessoa[] part = cts.cadastraPessoas();
        
        cts.cadastraPessoas();
        
        cts.vendeTeleSenas();
        
        //cts.setPessoas(part);
        
        for (int i = 0; i < cts.getPessoas().length; i++) {
            System.out.println(cts.getPessoas()[i]);
        }
    }
}