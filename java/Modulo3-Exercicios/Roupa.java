public class Roupa
{
    // instance variables
    private String marca;
    private double preco;
    private char genero;

    public Roupa(String brand, double price, char genre)
    {
        // initialise instance variables
        marca = brand;
        preco = price;
        genero = genre;
    }

    public String getMarca()
    {
        return marca;
    }
    
    public double getPreco()
    {
        return preco;
    }
    
    public char getGenero(char novoGenero)
    {
        return genero;
    }
    
    public void setMarca(String novoMarca)
    {
        marca = novoMarca;
    }
    
    public void setPreco(double novoPreco)
    {
        preco = novoPreco;
    }
    
    public void setGenero(char novoGenero)
    {
        genero = novoGenero;
    }
}
