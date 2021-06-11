public class ContaCorrente {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente(01, 10000);
        
        System.out.println(conta1);
        
        conta1.efetuaDeposito(300);
        
        System.out.println(conta1);
        
        conta1.efetuaDeposito(-40);

        System.out.println(conta1);
        
        conta1.efetuaSaque(150);
        
        System.out.println(conta1);

        conta1.efetuaSaque(-150);

        System.out.println(conta1);

        conta1.efetuaSaque(11050);

        System.out.println(conta1);
    }
    
    private int numero;
    private double saldo;
    
    public ContaCorrente(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String toString() {
        return "[Número da conta] " + numero + "\n[Saldo da conta] " + saldo;
    }
    
    public void efetuaDeposito(double valorDeposito) {
        if (valorDeposito > 0) {
            saldo += valorDeposito;
            System.out.println("Valor de " + valorDeposito + " depositado com sucesso!");
        } else
            System.out.println("Erro: valor a ser depositado não pode ser negativo.");
    }
    
    public void efetuaSaque(double valorSacado) {            
        if (valorSacado < 0)
            System.out.println("Erro: valor a ser sacado não pode ser negativo.");
        else if (saldo < valorSacado)
            System.out.println("Erro: saldo insuficiente.");
        else {
            saldo -= valorSacado;
            System.out.println("Valor de " + valorSacado + " sacado com sucesso!");
        }
    }
}