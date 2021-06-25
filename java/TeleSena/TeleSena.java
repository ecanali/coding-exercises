// Estabelece características principais das Tele Senas e gerencia os números aleatórios dos conjuntos
public class TeleSena {
    private final double VALOR_VENDA = 10.0;
    private final int MAX_NUMEROS_CONJUNTO = 25;
    public int[] conjunto1, conjunto2;
    
    // Cria 25 números entre 1 e 60 aleatoriamente e não repetidos
    public int[] sorteiaNumerosConjunto() {
        int[] conjunto = new int[MAX_NUMEROS_CONJUNTO];
        int numeroSorteado;
        boolean encontrou, jaTem;
        for (int i = 0; i < conjunto.length; i++) {
            encontrou = false;
            while (!encontrou) {
                jaTem = false;
                numeroSorteado = (int)(Math.random() * 60 + 1);
                for (int j = 0; j < conjunto.length; j++) {
                    if (numeroSorteado == conjunto[j]) {
                        jaTem = true;
                        break;
                    }
                }
                if (!jaTem) {
                   encontrou = true;
                   conjunto[i] = numeroSorteado;
                }
            }
        }
        return conjunto;
    }
    
    public TeleSena() {        
        conjunto1 = sorteiaNumerosConjunto();
        conjunto2 = sorteiaNumerosConjunto();
    }
    
    public double getValorVenda() {
        return VALOR_VENDA;
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
        for (int i = 0; i < conjunto1.length; i++)
            textoConjunto1 += conjunto1[i] + ", ";
        String textoConjunto2 = "";
        for (int i = 0; i < conjunto2.length; i++)
            textoConjunto2 += conjunto2[i] + ", "; 
        return "[Valor de venda] " + VALOR_VENDA +
            "\n[Máximo de números no conjunto] " + MAX_NUMEROS_CONJUNTO + 
            "\n[Conjunto 1] " + textoConjunto1 +
            "\n[Conjunto 2] " + textoConjunto2;
    }
}