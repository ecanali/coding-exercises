public class TeleSena {
    private final double VALOR_VENDA = 10.0;
    private final int MAX_NUMEROS_CONJUNTO = 25;
    public int[] conjunto1, conjunto2;
    
    // Retorna Array com números aleatórios e não repetidos
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
        // Cada um dos conjuntos de números de cada Tele Sena possui 
        // 25 números aleatórios entre 1 e 60, sem repetições 
        // (ou seja, no mesmo conjunto de 25 números não pode haver números 
        // repetidos)
        
        conjunto1 = sorteiaNumerosConjunto();
        conjunto2 = sorteiaNumerosConjunto();
        
        /*conjunto1 = new int[25];
        conjunto2 = new int[25];
        
        
        
        int numeroSorteado;
        

        for (int i = 0; i < conjunto1.length; i++) {
            conjunto1[i] = -1;
        }
        
        for (int i = 0; i < conjunto1.length; i++) {
            numeroSorteado = (int)(Math.random() * 60 + 1);
            if (conjunto1[i] == -1 && conjunto1[i] != numeroSorteado)
                conjunto1[i] = numeroSorteado;
        }*/
        
        
        
    }
    
    
    
    public static void main(String[] args) {
        
        //int[]conjunto2 = new int[25];
        
        
        
        //int numeroSorteado = (int)(Math.random() * 60 + 1);

        //System.out.println(numeroSorteado);
        
        
        //System.out.println(conjunto1.length);
        
            /*if (conjunto1[i] != numeroSorteado)
                for (int j = 0; j < conjunto1.length; i++) {
                    
                }
                conjunto1[i] = numeroSorteado;*/
            
            //
            
        TeleSena novaTS1 = new TeleSena();
        
        for (int i = 0; i < novaTS1.conjunto1.length; i++)
            System.out.print(novaTS1.conjunto1[i] + ", ");
        
        System.out.println();
        
        for (int i = 0; i < novaTS1.conjunto2.length; i++)
            System.out.print(novaTS1.conjunto2[i] + ", ");

    }
}