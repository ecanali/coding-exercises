public class PrimeiraDivisao extends Time {
    private int posicaoRankingNacional;
    
    public PrimeiraDivisao(String nome, int quantidadeMaximaSocios, int posicaoRankingNacional) {
        super(nome, quantidadeMaximaSocios);
        this.posicaoRankingNacional = posicaoRankingNacional;
    }
    
    public int getPosicaoRankingNacional() {
        return posicaoRankingNacional;
    }
    
    public void setPosicaoRankingNacional(int posicaoRankingNacional) {
        this.posicaoRankingNacional = posicaoRankingNacional;
    }
    
    public String toString() {
        return super.toString() + 
            "[Posição Ranking Nacional] " + posicaoRankingNacional + "º lugar";
    }
}