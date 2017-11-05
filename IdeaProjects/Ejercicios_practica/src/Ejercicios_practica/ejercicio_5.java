package Ejercicios_practica;

import java.util.Scanner;

public class ejercicio_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("¿Cual es su edad?");
        int edad=input.nextInt();
        if (edad>=18){
            System.out.println("Usted es mayor de edad");
        } else System.out.println("Usted es menor de edad");
    }
}
