package Nivel1;

import Plantilla.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Luized
 */
public class Ejercicio2 
{  
    //1. Atributos o variables de clases
   
    //2. Métodos
   
    public static void main(String[] args)
    {
   
        new Ejercicio2();
       
    }
   
    public Ejercicio2()
    {
   
        this.proceso();
       
    }
   
    private void proceso()
    {
        //1. Configuracion
        int x, n;
        float datos[], dato, prom, desvi, acum = 0, auxiliar;
        
        n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos son :"));
        datos = new float [n];
        
        //2. Captura de datos
        for (int i = 0; i < n; i++) 
        {
            do
            {
                dato=Float.parseFloat(JOptionPane.showInputDialog("Digite nota del estudiante "+ (i+1)));
                if (dato < 0 || dato > 5) 
                {
                    JOptionPane.showMessageDialog(null,"Nota no valida. Digitela de nuevo...!", "Error", 0);
                    
                }
            }
            while (dato < 0 || dato > 5);
            datos[i] = dato;
        }
        
        //3. Mostrar datos originales
        for (int i = 0; i < n; i++) 
        {
            System.out.println(datos[i] + " ");   
        }
        System.out.println();
        
        //4. Ordenar datos
        for (int i = 0; i < n; i++) 
        {
            for (int j = i+1; j < n; j++) 
            {
                if (datos[j] > datos [i]) 
                {
                    auxiliar = datos [i];
                    datos[i] = datos [j];
                    datos[j] = auxiliar;
                }
            }
        }
        
        //5. Mostrar datos ordenados
        for (int i = 0; i < n; i++) 
        {
            System.out.println(datos[i] + " ");
        }
        System.out.println();
        
        //6.Promedio
        for (int i = 0; i < n; i++) 
        {
            acum += datos[i];
        }
        prom = acum / n;
        JOptionPane.showMessageDialog(null, "El promedio es: "+prom, "Resultado", 1);
        
        //7. Desviacion
        acum = 0;
        for (int i = 0; i < n; i++) 
        {
            acum = acum + (float)Math.pow(datos[i] - prom, 2);
        }
        acum = acum / (n/1);
        desvi = (float)Math.sqrt(acum);
        JOptionPane.showMessageDialog(null, "La desviacion estandar es: "+desvi, "Resultado", 1); 
        
        //8. Mejor dato
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+datos[0],"Resultado", 1);
        
        //9. Peor dato
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+datos[n-1],"Resultado", 1);
        
        //10. x Mejores
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos mejores quiere?"));
        if (x > 0 && x <= n) 
        {
            for (int i = 0; i < x; i++) 
                System.out.println(datos[i]+ " ");
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese nuemro de datos...!!!", "Error", 0);
        System.out.println();
        
        //11. x Peores
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos peores quiere?"));
        if (x > 0 && x <= n) 
        {
            for (int i = n - x; i < n; i++) 
            {
                System.out.println(datos[i] + " ");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese nuemro de datos...!!!", "Error", 0);
        System.out.println();
    }
    
}