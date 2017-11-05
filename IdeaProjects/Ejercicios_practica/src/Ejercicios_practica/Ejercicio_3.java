package Ejercicios_practica;
import java.util.Scanner;
/**
 *
 * @author Luis Martinez
 */
public class Ejercicio_3{

    public static void main(String[]args){

        Scanner input = new Scanner(System.in);
        float x1, x2, y1, y2,xdiference, ydiference, distance;
        System.out.println("ingrese el valor de x1");
        x1= input.nextFloat();
        System.out.println("Ingrese el valor de y1");
        y1=input.nextFloat();
        System.out.println("ingrese el valor de x2");
        x2=input.nextFloat();
        System.out.println("ingrese el valor de y2");
        y2=input.nextFloat();
        xdiference=(float)Math.pow(x2-x1,2);
        ydiference=(float)Math.pow(y2-y1,2);
        distance=(float)Math.sqrt(xdiference+ydiference);
        if (distance>5){
            System.out.println("Los puntos son muy lejanos");
        }
        else System.out.println(distance);
    }

}

