package Nivel2;

import javax.swing.JOptionPane;
/**
 *
 * @author Luized
 */
public class Operaciones2 
{  
    //1. Atributos o variables de clases
   
    //2. Métodos:
    
    //Obligatorios:   
    public static void main(String[] args)
    {   
        new Operaciones2();
       }
   
    public Operaciones2()
    {   
        float[] datos = this.configuracion();
        this.capturaDatos(datos);
        this.mostrarOriginales(datos);
        this.ordenarDatos(datos);
        this.ordenarDatos(datos);
        this.mostrarOrdenados(datos);
        float prom = this.promedio(datos);
        this.desviacion(datos, prom);
        this.mejorDato(datos);
        this.peorDato(datos);
        this.xMejores(datos);
        this.xPeores(datos);
    }
    
   // De servivio:
    private float[] configuracion()
    {
        //1. Configuracion
        int n;
        float datos[];

        n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos son :"));
        datos = new float [n];

        return datos;
    }
    private void capturaDatos(float[] datos)
    {
        //2. Captura de datos
        float dato;
        for (int i = 0; i < datos.length; i++) 
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
        
    }
    private void mostrarOriginales(float[] datos)
    {
        //3. Mostrar datos originales
        for (int i = 0; i < datos.length; i++) 
        {
            System.out.print(datos[i] + " ");   
        }
        System.out.println();
        
    }
    private void ordenarDatos(float[] datos)
    {
        //4. Ordenar datos
        float auxiliar;
        for (int i = 0; i < datos.length; i++) 
        {
            for (int j = i+1; j < datos.length; j++) 
            {
                if (datos[j] > datos [i]) 
                {
                    auxiliar = datos [i];
                    datos[i] = datos [j];
                    datos[j] = auxiliar;
                }
            }
        }
        
    }
    private void mostrarOrdenados(float[] datos)
    {
        //5. Mostrar datos ordenados
        for (int i = 0; i < datos.length; i++) 
        {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
        
        
    }
    private float promedio(float[] datos)
    {
        //6.Promedio
        float acum = 0, prom = 0;
        for (int i = 0; i < datos.length; i++) 
        {
            acum += datos[i];
        }
        prom = acum / datos.length;
        JOptionPane.showMessageDialog(null, "El promedio es: "+prom, "Resultado", 1);
        
        return prom;
    }
    private void desviacion(float[] datos, float prom)
    {
        //7. Desviacion
        float acum = 0, desvi = 0;
        for (int i = 0; i < datos.length; i++) 
        {
            acum = acum + (float)Math.pow(datos[i] - prom, 2);
        }
        acum = acum / (datos.length-1);
        desvi = (float)Math.sqrt(acum);
        JOptionPane.showMessageDialog(null, "La desviacion estandar es: "+desvi, "Resultado", 1); 
        
        
    }
    private void mejorDato(float[] datos)
    {
        //8. Mejor dato
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+datos[0],"Resultado", 1);
        
        
    }
    private void peorDato(float[] datos)
    {
        //9. Peor dato
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+datos[datos.length-1],"Resultado", 1);
        
        
    }
    private void xMejores(float[] datos)
    {
        //10. x Mejores
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos mejores quiere?"));
        if (x > 0 && x <= datos.length) 
        {
            for (int i = 0; i < x; i++) 
                System.out.print(datos[i]+ " ");
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese nuemro de datos...!!!", "Error", 0);
        System.out.println();
        
        
    }
    private void xPeores(float[] datos)
    {
    
        //11. x Peores
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos peores quiere?"));
        if (x > 0 && x <= datos.length) 
        {
            for (int i = datos.length - x; i < datos.length; i++) 
            {
                System.out.print(datos[i] + " ");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese nuemro de datos...!!!", "Error", 0);
        System.out.println();
    }    
}