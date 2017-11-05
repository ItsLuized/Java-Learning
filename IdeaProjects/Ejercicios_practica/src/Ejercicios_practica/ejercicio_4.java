package Ejercicios_practica;

import java.util.Scanner;

public class ejercicio_4 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n1,n2;
        System.out.println("Ingrese un numero entero");
        n1=input.nextInt();
        System.out.println("Ingrese otro numero entero");
        n2=input.nextInt();
        if (n2%n1==0){
            System.out.println(n2 +" es multiplo de "+n1);
        } else System.out.println(n2+" no es multiplo de "+n1);
    }
}
