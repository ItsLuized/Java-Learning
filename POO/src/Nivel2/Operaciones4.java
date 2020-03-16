package Nivel2;

import javax.swing.JOptionPane;
/**
 *
 * @author Luized
 */
public class Operaciones4 
{  
    //1. Atributos o variables de clases
    private float[] datos;
    private float[] ordenados;
    private float prom;
         
    //2. Métodos:
    
    //Obligatorios:   
    public static void main(String[] args)
    {   
        new Operaciones4();
       }
   
    public Operaciones4()
    {   
        this.datos = null;
        this.ordenados = null;
        this.prom = 0;
        this.menu();
    }
    
   // De servivio:
    private void menu()
    {
        char opcion;
        boolean yaCapturo = false;
        do{
            opcion=JOptionPane.showInputDialog("======OPCIONES======\n"
                                               +"1. Captura de datos \n"
                                               + "2. Mostrar originales\n"
                                               + "3. Mostrar ordenados\n"
                                               + "4. Promedio\n"
                                               + "5. Desviacion\n"
                                               + "6. Mejor dato\n"
                                               + "7. Peor dato\n"
                                               + "8. X mejores\n"
                                               + "9. X peores\n"
                                               + "0. Salir.").charAt(0);

            switch (opcion) {
                case '1':
                    this.configuracion();
                    this.capturaDatos();
                    this.ordenados= this.datos.clone();
                    this.ordenarDatos();
                    
                    yaCapturo = true;
                    break;
                    
                case '2':
                    if (!yaCapturo) {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else                    
                    this.mostrarOriginales();
                    break;
                    
                case '3':
                    if (!yaCapturo) {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.mostrarOrdenados();
                    break;
                    
                case '4':
                    if (!yaCapturo) {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.promedio();
                    break;
                    
                case '5':
                    if (!yaCapturo) {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.desviacion();
                    break;
                    
                case '6':
                    if (!yaCapturo) {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.mejorDato();
                    break;
                    
                case '7':
                    if (!yaCapturo) {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.peorDato();
                    break;
                    
                case '8':
                    if (!yaCapturo) {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.xMejores();
                    break;
                    
                case '9':
                    if (!yaCapturo) {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.xPeores();
                    break;
                    
                case '0':
                    JOptionPane.showMessageDialog(null, "Chao.");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe.", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }
    private void configuracion()
    {
        //1. Configuracion
        int n;

        n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos son :"));
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
    private void mostrarOrdenados()
    {
        //5. Mostrar this.this.datos ordenados
        for (int i = 0; i < this.ordenados.length; i++) 
        {
            System.out.print(this.ordenados[i] + " ");
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
        JOptionPane.showMessageDialog(null, "La mejor nota es: "+this.ordenados[0],"Resultado", 1);
        
        
    }
    private void peorDato()
    {
        //9. Peor dato
        JOptionPane.showMessageDialog(null, "La peor nota es: "+this.ordenados[this.datos.length-1],"Resultado", 1);
        
        
    }
    private void xMejores()
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
    private void xPeores()
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