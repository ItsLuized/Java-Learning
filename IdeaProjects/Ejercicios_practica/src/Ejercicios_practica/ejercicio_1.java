package Ejercicios_practica;
import java.util.Scanner;

public class ejercicio_1 {
        public static void main(String[] args) {
            float valor_compra,valor_pagar;
            float descuento;

            Scanner input =new Scanner(System.in);
            System.out.println("Cuanto es el valor de la compra?");
            valor_compra=input.nextFloat();
            descuento = valor_compra*(float)0.1;
            valor_pagar=valor_compra - descuento;
            if(valor_compra>100000){
                System.out.println("Usted tiene un descuento del 10%, lo cual le representa "+descuento);
                System.out.println("el valor de su compra despues del descuento es "+valor_pagar);
            }
            else{
                System.out.println("Su compra no supera los 100.000 pesos, por lo que no tiene descuento");
            }
        }

}

