package Ejercicios_practica;

import java.util.Scanner;

public class ejercicio_6 {
    public static void main(String[] args) {
        int lado1,lado2,hipotenusa;
        Scanner input = new Scanner(System.in);

        System.out.println("Este programa esta diseñado para detectar si un triangulo es rectangulo, solo con sus dos lados y la hipotenusa(los datos que ingrese " +
                "que sean enteros por favor)");
        System.out.println("Ingrese el valor del primer lado");
        lado1=input.nextInt();
        System.out.println("Ingrese el valor del segundo lado");
        lado2= input.nextInt();
        System.out.println("Ingrese el valor de la hipotenusa");
        hipotenusa=input.nextInt();

        if (hipotenusa <lado1 || hipotenusa<lado2){
            System.out.println("ERROR: La hipotenusa no puede ser menor que los otros dos lados");
            System.exit(0);
        }

        lado1= (int) Math.pow(lado1,2);
        lado2= (int)Math.pow(lado2,2);
        hipotenusa= (int)Math.pow(hipotenusa,2);


        if (lado1 + lado2 == hipotenusa){
            System.out.println("EURECA!");
        }else System.out.println("El triangulo no es rectangulo");

    }
}
