public class TeleSena {
    private final double VALOR_VENDA = 10.0;
    private final int MAX_NUMEROS_CONJUNTO = 25;
    public int[] conjunto1, conjunto2;
    
    // Retorna Array com números aleatórios e não repetidos do conjunto
    public int[] sorteiaNumerosConjunto() {
        int[] conjunto = new int[MAX_NUMEROS_CONJUNTO];
        int numeroSorteado;
        for (int i = 0; i < conjunto.length; i++) {
            numeroSorteado = (int)(Math.random() * 60 + 1);
            
            if (conjunto[i] == numeroSorteado) {
                break;
            } else {
                for (int j = 0; j < conjunto.length; j++) {
                    if (conjunto[j] == 0) {
                        conjunto[i] = numeroSorteado;
                        break;
                    }    
                }
            }
        }
        return conjunto;
    }
    
    public TeleSena() {        
        conjunto1 = sorteiaNumerosConjunto();
        conjunto2 = sorteiaNumerosConjunto();
    }
    
    public int[] getConjunto1() {
        return conjunto1;
    }
    
    public int[] getConjunto2() {
        return conjunto2;
    }
    
    public void setConjunto1(int[] conjunto1) {
        this.conjunto1 = conjunto1;
    }
    
    public void setConjunto2(int[] conjunto2) {
        this.conjunto2 = conjunto2;
    }
    
    public String toString() {
        String textoConjunto1 = "";
        for (int i = 0; i < conjunto1.length; i++) {
            textoConjunto1 += conjunto1[i] + ", ";
        }
        
        String textoConjunto2 = "";
        for (int i = 0; i < conjunto2.length; i++) {
            textoConjunto2 += conjunto2[i] + ", ";
        }
                
        return "[Valor de venda] " + VALOR_VENDA +
            "\n[Máximo de números no conjunto] " + MAX_NUMEROS_CONJUNTO + 
            "\n[Conjunto 1] " + textoConjunto1 +
            "\n[Conjunto 2] " + textoConjunto2;
    }
    
    
    public static void main(String[] args) {
        
        TeleSena novaTS1 = new TeleSena();
        
        System.out.println(novaTS1);
        
        //int[]conjunto2 = new int[25];
        
        
        
        //int numeroSorteado = (int)(Math.random() * 60 + 1);

        //System.out.println(numeroSorteado);
        
        
        //System.out.println(conjunto1.length);
        
            /*if (conjunto1[i] != numeroSorteado)
                for (int j = 0; j < conjunto1.length; i++) {
                    
                }
                conjunto1[i] = numeroSorteado;
            
            //
            
        TeleSena novaTS1 = new TeleSena();
        
        for (int i = 0; i < novaTS1.conjunto1.length; i++)
            System.out.print(novaTS1.conjunto1[i] + ", ");
        
        System.out.println();
        
        for (int i = 0; i < novaTS1.conjunto2.length; i++)
            System.out.print(novaTS1.conjunto2[i] + ", ");

    }*/
    }
}