public class MotoristaApp{
    private String nome;
    private double[] avaliacoes;

    public MotoristaApp(String nome, int quantMaxAvaliacoes){
        this.nome = nome;
        this.avaliacoes = new double[quantMaxAvaliacoes];
        for(int i=0; i<avaliacoes.length; i++)
            avaliacoes[i] = -1;
    }
    
    public void imprimeAvaliacoes(){
        for(int i=0; i<avaliacoes.length; i++)
            if(avaliacoes[i] != -1)
                System.out.print(avaliacoes[i] + " | ");
    }

    public boolean insereAvaliacao(double novaAvaliacao){
        if(novaAvaliacao < 0)
            return false;

        for(int i=0; i<avaliacoes.length; i++)
            if(avaliacoes[i] == -1){
                avaliacoes[i] = novaAvaliacao;
                return true;
            }
            
        return false;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double[] getAvaliacoes(){
        return avaliacoes;
    }

    public void setAvaliacoes(double[] avaliacoes){
        this.avaliacoes = avaliacoes;
    }
    
    public String toString() {
        return "[Nome do Motorista] " + nome;
    }
}