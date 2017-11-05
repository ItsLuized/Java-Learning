package Ejercicios_practica;
import java.util.Scanner;

public class ejercicio_2 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        float parcial, quizesytareas, projectofinal, definitiva;
        System.out.println("Ingrese la nota del parcial");
        parcial= input.nextFloat();
            if (parcial>5){
            System.out.println("ERROR: los datos tienen que estar entre 0 y 5");
            System.exit(0);
            }

        System.out.println("Ingrese la nota de quizes y tareas");
        quizesytareas=input.nextFloat();
            if (quizesytareas>5){
            System.out.println("ERROR: los datos tienen que estar entre 0 y 5");
                System.exit(0);
            }

        System.out.println("Ingrese la nota del projecto final");
        projectofinal=input.nextFloat();
        if (parcial>5){
            System.out.println("ERROR: los datos tienen que estar entre 0 y 5");
            System.exit(0);
            }

        definitiva=(parcial*0.4f)+(quizesytareas*0.25f)+(projectofinal*.35f);
        if (definitiva >=4.5 && definitiva<=5){
            System.out.println("Felicitaciones, su nota es "+ definitiva +", es sobresaliente");
        }
        if (definitiva >=3 && definitiva<4.5){
            System.out.println("paso la materia con "+definitiva);
        }
        if(definitiva <3 && definitiva<5) {
            System.out.println("perdiste la materia con "+definitiva);
        }
    }
}
