/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel3;

import javax.swing.JOptionPane;

/**
 *
 * @author Luized
 */
public class Estadisticas 
{
    //variables de clase o atributos
    private float[] datos;
    private float[] ordenados;
    private float prom;
    
    //Metodos
    //Obligatorios:
    public Estadisticas()
    {
    this.datos = null;
    this.ordenados = null;
    this.prom = 0;
    }  
    
    public Estadisticas(float[] datos)
    {
    this.datos = datos;
    this.ordenados = this.datos.clone();
    this.ordenarDatos();
    this.prom = 0;
    }  
    
    //Modificadores
    public void setDatos(float[] datos)
    {
    this.datos = datos;
    this.ordenados = this.datos.clone();
    this.ordenarDatos();
    }
    
    //De servicio:
    public void mostrarOriginales()
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
        for (int i = 0; i < this.ordenados.length; i++) 
        {
            for (int j = i+1; j < this.ordenados.length; j++) 
            {
                if (this.ordenados[j] > this.ordenados [i]) 
                {
                    auxiliar = this.ordenados [i];
                    this.ordenados[i] = this.ordenados [j];
                    this.ordenados[j] = auxiliar;
                }
            }
        }
        
    }
    public void mostrarOrdenados()
    {
        //5. Mostrar this.this.datos ordenados
        for (int i = 0; i < this.ordenados.length; i++) 
        {
            System.out.print(this.ordenados[i] + " ");
        }
        System.out.println();
          
    }
    public void promedio()
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
    public void desviacion()
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
    public void mejorDato()
    {
        //8. Mejor dato
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+this.ordenados[0],"Resultado", 1);
        
    }
    public void peorDato()
    {
        //9. Peor dato
        JOptionPane.showMessageDialog(null, "La peor nota es: "+this.ordenados[this.datos.length-1],"Resultado", 1);
        
    }
    public void xMejores()
    {
        //10. x Mejores
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos mejores quiere?"));
        if (x > 0 && x <= this.ordenados.length) 
        {
            for (int i = 0; i < x; i++) 
                System.out.print(this.ordenados[i]+ " ");
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese numero de datos...!!!", "Error", 0);
        System.out.println(); 
    }
    public void xPeores()
    {
    
        //11. x Peores
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos peores quiere?"));
        if (x > 0 && x <= this.ordenados.length) 
        {
            for (int i = this.ordenados.length - x; i < this.ordenados.length; i++) 
            {
                System.out.print(this.ordenados[i] + " ");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ese numero de datos...!!!", "Error", 0);
        System.out.println();
    }
}
