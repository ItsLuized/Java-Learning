package Repaso;
import plantilla.*;
import javax.swing.JOptionPane;

public class E15 {  
    //1. Atributos o variables de clases
   
    //2. Métodos
   
    public static void main(String[] args){
   
        new E15();
       
    }
   
    public E15(){
   
        this.proceso();
       
    }
   
    private void proceso(){
        String binario = "";
        char caracter;
        int ascii = 0;
        
        caracter = JOptionPane.showInputDialog("Digite un caracter que quiera convertir a binario").charAt(0);
        ascii = (int)caracter;
        binario = Integer.toBinaryString(ascii);
        
        
        System.out.println("El  caracter que escribio fue: " + caracter + "\nEl el codigo Ascii que da es: " + ascii + "\nY su numero binario es: " + binario);
    }
   
}

