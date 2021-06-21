public class ExemplosArrays{
    
    public int procuraNome(String[] nomes, String nome){
        for(int i=0; i<nomes.length; i++)
            if(nomes[i].equalsIgnoreCase(nome))
                return i;
        return -1; 
    }
    
    public double calculaMedia(double[] valores){
        double soma = 0;
        for(int i=0; i<valores.length; i++)
            soma += valores[i];
        return soma / valores.length;
    }
    
    public void imprimeAvaliacoesMotorista(MotoristaApp[] motoristas, String nome){
        System.out.println("Avaliações do motorista "+nome+":");
        for(int i=0; i<motoristas.length; i++){
            if(motoristas[i] != null){
                if(motoristas[i].getNome().equalsIgnoreCase(nome))
                    motoristas[i].imprimeAvaliacoes();
            }
        }
    }

    public static void main(String[] args){
        MotoristaApp[] motoristas = new MotoristaApp[10];
        for(int i=0; i<motoristas.length; i++)
            motoristas[i] = new MotoristaApp("Fulano "+i, 100);
        
        String nomeMotorista = Teclado.leString("Digite o nome do motorista para inserir a avaliação:");
       
        for(int i=0; i<motoristas.length; i++)
            if(motoristas[i].getNome().equalsIgnoreCase(nomeMotorista))
                if(motoristas[i].insereAvaliacao(Teclado.leDouble("Digite a nota do motorista:")))
                    System.out.println("Avaliação inserida com sucesso!");
                else
                    System.out.println("Erro ao inserir avaliação =(");
            
        ExemplosArrays e = new ExemplosArrays();
        e.imprimeAvaliacoesMotorista(motoristas, Teclado.leString("Digite o nome do motorista:"));
    }
}





