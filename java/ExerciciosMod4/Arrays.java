public class Arrays {
    public static void main(String args[]) {
        int[] array1 = new int[10];
        for (int i = 10; i > 0; i--) {
            array1[i - 1] = i;
            System.out.println(i);
        }
        
        int array2[] = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        for (int i = 0; i < array2.length; i++)
            System.out.println(array2[i]);
            
        double array3[] = new double[10];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = Teclado.leDouble("Digite o double nº" + (i + 1) + ':');
        }
        
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
        
        int[] array4 = {2, -4, 56, -98, 0, -12345};
        System.out.println("A quantidade de negativos dentro do array é: " + quantosNegativos(array4));
        
        int array5[] = new int[5];
        array5[0] = 5;
        array5[1] = 4;
        array5[2] = 3;
        array5[3] = 2;
        array5[4] = 1;
        int array6[] = new int[5];
        array6 = transformaArray(array5);
        for (int i = 0; i < array6.length; i++) {
            System.out.println(array6[i]);
        }
    }
    
    public static int quantosNegativos(int[] array4) {
        int quantidadeNegativos = 0;
        for (int i = 0; i < array4.length; i++) {
            if (array4[i] < 0)
                quantidadeNegativos++;
        }
        return quantidadeNegativos;
    }
    
    public static int[] transformaArray(int array5[]) {
        int array6[] = new int[5];
        for (int i = 0; i < array5.length; i++) {
            if (array5[i] % 2 == 0)
                array6[i] = +1;
            else
                array6[i] = -1;
        }
        return array6;
    }
}