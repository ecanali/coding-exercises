// Sorteio da Tele Sena
public class Principal {
    public static void main(String[] args) {
        ControleTeleSena cts = new ControleTeleSena();
        cts.cadastraPessoas();
        cts.criaTeleSenas();
        cts.vendeTeleSenas();
        cts.realizaSorteio();
        cts.informaResultados();
    }
}