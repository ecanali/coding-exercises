public class ExerciciosWhile {
    private int inteiro;
    
    public ExerciciosWhile(int inteiro) {
        this.inteiro = inteiro;
    }
    
    public void contador(int inteiro) {
        while (inteiro <= 300) {
            System.out.println(inteiro);
            inteiro++;
        }
    }
    
    public void imprimePares(int inteiro) {
        if (inteiro > 0) {
            while (inteiro >= 0) {
                if (inteiro % 2 == 0) {
                    System.out.println(inteiro);
                }
                inteiro--;
            } 
        } else {
            System.out.println("Erro: número informado é negativo.");
        }
    }
    
    public boolean verificaPrimo(int inteiro) {
        boolean isPrimo = true;
        int contador = 2;
        while (contador < inteiro) {
            if (inteiro % contador == 0) {
                isPrimo = false;
                break;
            }
            contador++;
        }
        return isPrimo;
    }
}