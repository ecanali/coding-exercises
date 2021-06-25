// Estabelece características principais das pessoas participantes que compram as Tele Senas para o sorteio
public class Pessoa {
    private String nome;
    private TeleSena[] teleSenasCompradas;
    private double valorPremiacaoRecebido;
    
    public Pessoa(String nome, int numeroTeleSenasCompradas) {
        this.nome = nome;
        this.teleSenasCompradas = new TeleSena[numeroTeleSenasCompradas];
        valorPremiacaoRecebido = 0.0;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public TeleSena[] getTeleSenasCompradas() {
        return teleSenasCompradas;
    }
    
    public void setTeleSenasCompradas(TeleSena[] teleSenasCompradas) {
        this.teleSenasCompradas = teleSenasCompradas;
    }
    
    public double getValorPremiacaoRecebido() {
        return valorPremiacaoRecebido;
    }
    
    public void setValorPremiacaoRecebido(double valorPremiacaoRecebido) {
        this.valorPremiacaoRecebido = valorPremiacaoRecebido;
    }
    
    public String toString() {
        String listaTeleSenas = "";
        for (int i = 0; i < teleSenasCompradas.length; i++)
            listaTeleSenas += ">>> Tele Sena nº" + (i + 1) + ":\n" + teleSenasCompradas[i] + "\n";
        return "[Nome] " + nome +
            "\n[Valor Premiação] " + valorPremiacaoRecebido +
            "\n[Tele Senas Compradas (" + teleSenasCompradas.length + ")]\n" + listaTeleSenas;
    }
}