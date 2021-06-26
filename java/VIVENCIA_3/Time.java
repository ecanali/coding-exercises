public class Time {
    private String nome;
    private Socio[] socios;
    
    public Time(String nome, int quantidadeMaximaSocios) {
        this.nome = nome;
        this.socios = new Socio[quantidadeMaximaSocios];
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Socio[] getSocios() {
        return socios;
    }
    
    public void setSocios(Socio[] socios) {
        this.socios = socios;
    }
    
    public String toString() {
        String texto = "[Nome] " + nome + "\n[Sócios] \n";
        for (int i = 0; i < socios.length; i++)
            texto += socios[i] + "\n";
        return texto;
    }
    
    public boolean insereSocio(Socio novoSocio) {
        for (int i = 0; i < socios.length; i++) {
            if (socios[i] == null) {
                socios[i] = novoSocio;
                return true;
            }
        }
        return false;
    }
    
    public String socioMaisVelho() {
        Socio socioMaisVelho = socios[0];
        for (int i = 0; i < socios.length; i++) {
            if (socios[i] != null) {
                if (socios[i].getIdade() > socioMaisVelho.getIdade())
                    socioMaisVelho = socios[i];
            }
        }
        return socioMaisVelho.getNome();
    }
    
    public void imprimeSocios() {
        for (int i = 0; i < socios.length; i++)
            System.out.println(socios[i]);
    }
}