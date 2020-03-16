package Nivel2;

import javax.swing.JOptionPane;
/**
 *
 * @author Luized
 */
public class Operaciones1 
{  
    //1. Atributos o variables de clases
   
    //2. Métodos:
    
    //Obligatorios:   
    public static void main(String[] args)
    {   
        new Operaciones1();
       }
   
    public Operaciones1()
    {   
        this.configuracion();
    }
    
   // De servivio:
    private void configuracion()
    {
        //1. Configuracion
        int x, n;
        float datos[];

        n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos son :"));
        datos = new float [n];

        this.capturaDatos(n, datos);
    }
    private void capturaDatos(int n, float[] datos)
    {
        //2. Captura de datos
        float dato;
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
        this.mostrarOriginales(n, datos);
    }
    private void mostrarOriginales(int n, float[] datos)
    {
        //3. Mostrar datos originales
        for (int i = 0; i < n; i++) 
        {
            System.out.print(datos[i] + " ");   
        }
        System.out.println();
        this.ordenarDatos(n, datos);
    }
    private void ordenarDatos(int n, float[] datos)
    {
        //4. Ordenar datos
        float auxiliar;
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
        this.mostrarOrdenados(n, datos);
    }
    private void mostrarOrdenados(int n, float[] datos)
    {
        //5. Mostrar datos ordenados
        for (int i = 0; i < n; i++) 
        {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
        
        this.promedio(n, datos);
    }
    private void promedio(int n, float[] datos)
    {
        //6.Promedio
        float acum = 0, prom = 0;
        for (int i = 0; i < n; i++) 
        {
            acum += datos[i];
        }
        prom = acum / n;
        JOptionPane.showMessageDialog(null, "El promedio es: "+prom, "Resultado", 1);
        
        this.desviacion(n, datos, prom);
    }
    private void desviacion(int n, float[] datos, float prom)
    {
        //7. Desviacion
        float acum = 0, desvi = 0;
        for (int i = 0; i < n; i++) 
        {
            acum = acum + (float)Math.pow(datos[i] - prom, 2);
        }
        acum = acum / (n/1);
        desvi = (float)Math.sqrt(acum);
        JOptionPane.showMessageDialog(null, "La desviacion estandar es: "+desvi, "Resultado", 1); 
        
        this.mejorDato(n, datos);
    }
    private void mejorDato(int n, float[] datos)
    {
        //8. Mejor dato
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+datos[0],"Resultado", 1);
        
        this.peorDato(n, datos);
    }
    private void peorDato(int n, float[] datos)
    {
        //9. Peor dato
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+datos[n-1],"Resultado", 1);
        
        this.xMejores(n, datos);
    }
    private void xMejores(int n, float[] datos)
    {
        //10. x Mejores
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos mejores quiere?"));
        if (x > 0 && x <= n) 
        {
            for (int i = 0; i < x; i++) 
                System.out.print(datos[i]+ " ");
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese nuemro de datos...!!!", "Error", 0);
        System.out.println();
        
        this.xPeores(n, datos);
    }
    private void xPeores(int n, float[] datos)
    {
    
        //11. x Peores
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos peores quiere?"));
        if (x > 0 && x <= n) 
        {
            for (int i = n - x; i < n; i++) 
            {
                System.out.print(datos[i] + " ");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese nuemro de datos...!!!", "Error", 0);
        System.out.println();
    }    
}