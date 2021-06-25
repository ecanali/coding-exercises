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
    
    /*
    public static void main(String[] args) {
        Socio socio1 = new Socio("Roberto", 27);
        Socio socio2 = new Socio("Betina", 35);

        Socio[] socios1 = {socio1, null};
        SegundaDivisao time1 = new SegundaDivisao("Caxias", 2, 3);
        
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