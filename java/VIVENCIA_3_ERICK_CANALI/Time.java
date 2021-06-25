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
            if (socios[i].getIdade() > socioMaisVelho.getIdade())
                socioMaisVelho = socios[i];
        }
        return socioMaisVelho.getNome();
    }
    
    public void imprimeSocios() {
        for (int i = 0; i < socios.length; i++)
            System.out.println(socios[i]);
    }
    
    /*
    public static void main(String[] args) {
        Socio socio1 = new Socio("Roberto", 27);
        Socio socio2 = new Socio("Betina", 35);

        Socio[] socios1 = {socio1, null};
        Time time1 = new Time("Inter", 2);
        
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