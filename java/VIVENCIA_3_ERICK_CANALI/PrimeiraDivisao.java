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
    
    /*
    public static void main(String[] args) {
        Socio socio1 = new Socio("Roberto", 27);
        Socio socio2 = new Socio("Betina", 35);

        Socio[] socios1 = {socio1, null};
        PrimeiraDivisao time1 = new PrimeiraDivisao("Inter", 2, 1);
        
        System.out.println(time1);
        time1.setSocios(socios1);
        System.out.println(time1);
        System.out.println(time1.insereSocio(socio2));
        System.out.println(time1);
        System.out.println(time1.insereSocio(socio1));
        System.out.println(time1);
        System.out.println("O sócio mais velho é: " + time1.socioMaisVelho());
        time1.imprimeSocios();
    }
    */
}