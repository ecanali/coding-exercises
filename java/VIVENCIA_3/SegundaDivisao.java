public class SegundaDivisao extends Time {
    private int quantAnosSeguidos2Divisao;
    
    public SegundaDivisao(String nome, int quantidadeMaximaSocios, int quantAnosSeguidos2Divisao) {
        super(nome, quantidadeMaximaSocios);
        this.quantAnosSeguidos2Divisao = quantAnosSeguidos2Divisao;
    }
    
    public int getQuantAnosSeguidos2Divisao() {
        return quantAnosSeguidos2Divisao;
    }
    
    public void setQuantAnosSeguidos2Divisao(int quantAnosSeguidos2Divisao) {
        this.quantAnosSeguidos2Divisao = quantAnosSeguidos2Divisao;
    }
    
    public String toString() {
        return super.toString() + 
            "[Anos seguidos na 2ª divisão] " + quantAnosSeguidos2Divisao + " ano(s)";
    }
}