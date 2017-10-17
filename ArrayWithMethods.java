import javax.swing.*;
public class ArrayWithMethods {
    public static void Mayor(int[] datos){
        int mayor=0;
        int posicion=0;
        for(int i=0; i < datos.length ;i++ ){

            if(datos[i] > mayor){
                mayor = datos[i];
                posicion = i + 1;
            }
        }
        JOptionPane.showMessageDialog(null,"el mayor numero es "+ mayor + " en la posicion "+posicion);
    }
    public static void Menor(int[] datos){
        int menor=0;
        int posicion=0;
        for (int i = 0; i < datos.length ; i++){

            if (datos[i] < menor){
                menor=datos[i];
                posicion = i + 1;
            }
        }
        JOptionPane.showMessageDialog(null,"el menor numero es "+ menor + " en la posicion "+posicion);
    }

    public static void main (String[] args){
        int[] datos = new int[]{15, 25, 32, 8, -6};
        JOptionPane.showMessageDialog(null, "Dada una serie de numeros, siendo : 15, 25, 35, 8, -6\n" +
                "Se va a imprimir el mayor y en que posicion esta, y el menor y su posicion");
        Mayor(datos);
        Menor(datos);
    }
}
