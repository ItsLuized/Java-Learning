package vista;

import gestion.GestionEstudiantes;
import javax.swing.JOptionPane;
/**
 *
 * @author Luized
 */
public class Entrada 
{  
    //1. Atributos o variables de clases
    private GestionEstudiantes gestor;
    
    //2. Métodos:    
    //Obligatorios:   
    public static void main(String[] args)
    {   
        new Entrada();
    }
   
    public Entrada()
    {   
        this.gestor = new GestionEstudiantes();
        this.menuPrincipal();
    }
    
   // De servivio:
    private void menuPrincipal()
    {
        char opcion;
        boolean yaCapturo = false;
        do
        {
            opcion=JOptionPane.showInputDialog("======OPCIONES======\n"
                                               + "1. Crear nuevo \n"
                                               + "2. Mostrar alguno\n"
                                               + "3. Ver todos\n"
                                               + "4. Modificar alguno\n"
                                               + "5. Eliminar alguno\n"
                                               + "0. Salir"
                                               ).charAt(0);

            switch (opcion) 
            {
                case '1':
                    this.gestor.agregarEstudiante();
                    yaCapturo = true;
                    break;
                    
                case '2':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else                    
                        this.gestor.buscarEstudiante();
                    break;
                    
                case '3':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.gestor.verTodos();
                    break;
                    
                case '4':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.menuModificaciones();
                    break;
                    
                case '5':
                    if (!yaCapturo) 
                    {
                        JOptionPane.showMessageDialog(null,"Lo siento, debe primero capturar datos!");
                    }
                    else 
                    this.gestor.eliminarEstudiante();
                    break;
                                    
                case '0':
                    JOptionPane.showMessageDialog(null, "Chao!", "Cerrando... ",1);
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe.", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }   
    
    private void menuModificaciones()
    {
        char opcion;
        do
        {
            opcion=JOptionPane.showInputDialog("======OPCIONES======\n"
                                               + "1. Modificar codigo \n"
                                               + "2. Modificar nombre\n"
                                               + "3. Modificar apellido\n"
                                               + "4. Modificar genero\n"
                                               + "5. Modificar telefono\n"
                                               + "0. Regresar"
                                               ).charAt(0);

            switch (opcion) 
            {
                case '1':
                    this.gestor.modificarCodigo();
                    break;                    
                case '2':
                    this.gestor.modificarNombre();
                    break;                    
                case '3':
                    this.gestor.modificarApellidos();
                    break;                    
                case '4':
                    this.gestor.modificarGenero();
                    break;                    
                case '5':
                    this.gestor.modificarTelefono();
                    break;                                    
                case '0':                    
                    break;                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe.", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }  
}