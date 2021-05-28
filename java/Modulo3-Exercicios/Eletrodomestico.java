public class Eletrodomestico {
    private int voltagem;
    private double preco;
    private String marca;
    private String cor;
    private boolean biVolt;
    
    public Eletrodomestico(int voltage, double price, String brand, String color, boolean biV) {
        voltagem = voltage;
        preco = price;
        marca = brand;
        cor = color;
        biVolt = biV;
    }
    
    public int getVoltagem() {
        return voltagem;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getCor() {
        return cor;
    }
    
    public boolean getBiVolt() {
        return biVolt;
    }
    
    public void setVoltagem(int novoVoltagem) {
        voltagem = novoVoltagem;
    }
    
    public void setPreco(double novoPreco) {
        preco = novoPreco;
    }
    
    public void setMarca(String novoMarca) {
        marca = novoMarca;
    }
    
    public void setCor(String novoCor) {
        cor = novoCor;
    }
    
    public void setBiVolt(boolean novoBiVolt) {
        biVolt = novoBiVolt;
    }
}