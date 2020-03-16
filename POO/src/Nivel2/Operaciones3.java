package Nivel2;

import javax.swing.JOptionPane;
/**
 *
 * @author Luized
 */
public class Operaciones3 
{  
    //1. Atributos o variables de clases
    private float[] datos;
    private float prom;
        
    //2. Métodos:
    
    //Obligatorios:   
    public static void main(String[] args)
    {   
        new Operaciones3();
       }
   
    public Operaciones3()
    {   
        this.datos = null;
        this.prom = 0;
        this.manejador();
    }
    
   // De servivio:
    private void manejador()
    {
        this.configuracion();
        this.capturaDatos();
        this.mostrarOriginales();
        this.ordenarDatos();
        this.ordenarDatos();
        this.mostrarOrdenados();
        this.promedio();
        this.desviacion();
        this.mejorDato();
        this.peorDato();
        this.xMejores();
        this.xPeores();
    }
    private void configuracion()
    {
        //1. Configuracion
        int n;

        n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos this.datos son :"));
        this.datos = new float [n];

    }
    private void capturaDatos()
    {
        //2. Captura de this.datos
        float dato;
        for (int i = 0; i < this.datos.length; i++) 
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
            this.datos[i] = dato;
        }
        
    }
    private void mostrarOriginales()
    {
        //3. Mostrar this.this.datos originales
        for (int i = 0; i < this.datos.length; i++) 
        {
            System.out.print(this.datos[i] + " ");   
        }
        System.out.println();
        
    }
    private void ordenarDatos()
    {
        //4. Ordenar this.this.datos
        float auxiliar;
        for (int i = 0; i < this.datos.length; i++) 
        {
            for (int j = i+1; j < this.datos.length; j++) 
            {
                if (this.datos[j] > this.datos [i]) 
                {
                    auxiliar = this.datos [i];
                    this.datos[i] = this.datos [j];
                    this.datos[j] = auxiliar;
                }
            }
        }
        
    }
    private void mostrarOrdenados()
    {
        //5. Mostrar this.this.datos ordenados
        for (int i = 0; i < this.datos.length; i++) 
        {
            System.out.print(this.datos[i] + " ");
        }
        System.out.println();
        
        
    }
    private void promedio()
    {
        //6.Promedio
        float acum = 0;
        for (int i = 0; i < this.datos.length; i++) 
        {
            acum += this.datos[i];
        }
        this.prom = acum / this.datos.length;
        JOptionPane.showMessageDialog(null, "El promedio es: "+prom, "Resultado", 1);
        
    }
    private void desviacion()
    {
        //7. Desviacion
        float acum = 0, desvi = 0;
        for (int i = 0; i < this.datos.length; i++) 
        {
            acum = acum + (float)Math.pow(this.datos[i] - prom, 2);
        }
        acum = acum / (this.datos.length-1);
        desvi = (float)Math.sqrt(acum);
        JOptionPane.showMessageDialog(null, "La desviacion estandar es: "+desvi, "Resultado", 1); 
        
        
    }
    private void mejorDato()
    {
        //8. Mejor dato
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+this.datos[0],"Resultado", 1);
        
        
    }
    private void peorDato()
    {
        //9. Peor dato
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+this.datos[this.datos.length-1],"Resultado", 1);
        
        
    }
    private void xMejores()
    {
        //10. x Mejores
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos mejores quiere?"));
        if (x > 0 && x <= this.datos.length) 
        {
            for (int i = 0; i < x; i++) 
                System.out.print(this.datos[i]+ " ");
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese nuemro de this.datos...!!!", "Error", 0);
        System.out.println();
        
        
    }
    private void xPeores()
    {
    
        //11. x Peores
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos peores quiere?"));
        if (x > 0 && x <= this.datos.length) 
        {
            for (int i = this.datos.length - x; i < this.datos.length; i++) 
            {
                System.out.print(this.datos[i] + " ");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese nuemro de this.datos...!!!", "Error", 0);
        System.out.println();
    }    
}