public class Esporte {
    private int quantJogadores;
    private String nome, categoria;
    private boolean olimpico, individual;
    
    public Esporte(int numPlayers, String name, String category, boolean olimpic, boolean solo) {
        quantJogadores = numPlayers;
        nome = name;
        categoria = category;
        olimpico = olimpic;
        individual = solo;
    }
    
    public int getQuantJogadores() {
        return quantJogadores;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public boolean getOlimpico() {
        return olimpico;
    }
    
    public boolean getIndividual() {
        return individual;
    }
    
    public void setQuantJogadores(int novoQuantJogadores) {
        quantJogadores = novoQuantJogadores;
    }
    
    public void setNome(String novoNome) {
        nome = novoNome;
    }
    
    public void setCategoria(String novoCategoria) {
        categoria = novoCategoria;
    }
    
    public void setOlimpico(boolean novoOlimpico) {
        olimpico = novoOlimpico;
    }
    
    public void setIndividual(boolean novoIndividual) {
        individual = novoIndividual;
    }
}