package Nivel3;

import javax.swing.JOptionPane;
/**
 *
 * @author Luized
 */
public class Entrada 
{  
    //1. Atributos o variables de clases
    private Estadisticas pepito;
    
    //2. Métodos:    
    //Obligatorios:   
    public static void main(String[] args)
    {   
        new Entrada();
    }
   
    public Entrada()
    {   
        this.pepito = new Estadisticas();
        this.menu();
    }
    
   // De servivio:
    private void menu()
    {
        char opcion;
        boolean yaCapturo = false;
        do
        {
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

            switch (opcion) 
            {
                case '1':
                    this.capturaDatos();
                    yaCapturo = true;
                    break;
                    
                case '2':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else                    
                        this.pepito.mostrarOriginales();
                    break;
                    
                case '3':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.pepito.mostrarOrdenados();
                    break;
                    
                case '4':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.pepito.promedio();
                    break;
                    
                case '5':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.pepito.desviacion();
                    break;
                    
                case '6':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.pepito.mejorDato();
                    break;
                    
                case '7':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.pepito.peorDato();
                    break;
                    
                case '8':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.pepito.xMejores();
                    break;
                    
                case '9':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.pepito.xPeores();
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
    
    private void capturaDatos()
    {
        //2. Captura de this.datos
        float datos[];
        float dato;
        int n;

        n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos son :"));        
        datos = new float [n];
        
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
        /*
        /VARIAS OPCIONES PARA CREAR OTRO OBJETO
        /crear el objeto tipo estadsticas
        /Estadisticas pepito = new Estadisticas();
        /pepito.setDatos(datos);
        /
        /this.pepito = new Estadisticas(datos);
        /OBJETO.metodo();
        /pepito.mostrarOriginales();
        */
        this.pepito.setDatos(datos);
    }    
}