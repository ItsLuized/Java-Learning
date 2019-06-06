package vista;

import gestion.GestionEstudiantes;
import gestion.GestionProfesores;
import gestion.GestionAsignatura;
import gestion.GestionInscripcion;
import javax.swing.JOptionPane;
/**
 *
 * @author Luized
 */
public class Entrada 
{  
    //1. Atributos o variables de clases
    private GestionEstudiantes gestor;
    private GestionProfesores gestProf;
    private GestionAsignatura gestAsig;
    private GestionInscripcion gestIns;
    
    //2. Métodos:    
    //Obligatorios:   
    public static void main(String[] args)
    {   
        new Entrada();
    }
   
    public Entrada()
    {   
        this.gestor = new GestionEstudiantes();
        this.gestProf = new GestionProfesores() ;
        this.gestAsig = new GestionAsignatura();
        this.gestIns = new GestionInscripcion();
        //System.out.println(this.gestIns.getTodos());
        this.menuPrincipal();
    }
    
   // De servivio:
    private void menuPrincipal()
    {
       char opcion;
        do
        {
            opcion=JOptionPane.showInputDialog("======MENU PRINCIPAL======\n"
                                               + "1. Estudiantes \n"
                                               + "2. Profesores\n"
                                               + "3. Asignaturas\n"
                                               + "4. Inscripcion\n"
                                               + "0. Salir"
                                               ).charAt(0);

            switch (opcion) 
            {
                case '1':
                    this.menuEstudiante();
                    break;
                    
                case '2':
                    this.menuProfesor();
                    break;
                    
                case '3':
                    this.menuAsignaturas();
                    break;  
                    
                case '4':
                    this.menuInscripcion();
                    break;
                    
                case '0':
                    JOptionPane.showMessageDialog(null, "Chao!");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe!", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }    
    
    private void menuEstudiante()
    {
        char opcion;
        do
        {
            opcion=JOptionPane.showInputDialog("======MENU ESTUDIANTE======\n"
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
                    break;
                    
                case '2':
                    if (!this.gestor.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else                    
                        this.gestor.buscarEstudiante();
                    break;
                    
                case '3':
                    if (!this.gestor.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else 
                    this.gestor.verTodos();
                    break;
                    
                case '4':
                    if (!this.gestor.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else 
                    this.modificacionesEstudiante();
                    break;
                    
                case '5':
                    if (!this.gestor.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else 
                    this.gestor.eliminarEstudiante();
                    break;
                                    
                case '0':
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe!", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }   
    
    private void modificacionesEstudiante()
    {
        char opcion;
        do
        {
            opcion=JOptionPane.showInputDialog("======MODIFICAR ESTUDIANTES======\n"
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
                    JOptionPane.showMessageDialog(null, "Ese caso no existe!", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }
    
    private void menuProfesor()
    {
        char opcion;
        do
        {
            opcion=JOptionPane.showInputDialog("======MENU PROFESOR======\n"
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
                    if (!this.gestAsig.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe crear una asignatura primero!","Error",0);
                    }
                    else
                        this.gestProf.agregarProfesor();
                    break;
                    
                case '2':
                    if (!this.gestProf.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else                    
                        this.gestProf.buscarProfesor();
                    break;
                    
                case '3':
                    if (!this.gestProf.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else 
                    this.gestProf.verTodos();
                    break;
                    
                case '4':
                    if (!this.gestProf.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else 
                    this.modificacionesProfesor();
                    break;
                    
                case '5':
                    if (!this.gestProf.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else 
                    this.gestProf.eliminarProfesor();
                    break;
                                    
                case '0':
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe!", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }
    
    private void modificacionesProfesor()
    {
        char opcion;
        do
        {
            opcion=JOptionPane.showInputDialog("======MODIFICAR PROFESOR======\n"
                                               + "1. Modificar identificacion \n"
                                               + "2. Modificar nombre\n"
                                               + "3. Modificar apellido\n"
                                               + "4. Modificar dictados\n"
                                               + "0. Regresar"
                                               ).charAt(0);

            switch (opcion) 
            {
                case '1':
                    this.gestProf.modificarIdentificacion();
                    break;                    
                case '2':
                    this.gestProf.modificarNombre();
                    break;                    
                case '3':
                    this.gestProf.modificarApellidos();
                    break;                    
                case '4':
                    this.gestProf.modificarDictadas();
                    break;                                    
                case '0':                    
                    break;                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe!", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }
    
    private void menuAsignaturas()
    {
        char opcion;
        do
        {
            opcion=JOptionPane.showInputDialog("======MENU ASGINATURA======\n"
                                               + "1. Crear nueva \n"
                                               + "2. Mostrar alguna\n"
                                               + "3. Ver todas\n"
                                               + "4. Modificar alguna\n"
                                               + "5. Eliminar alguna\n"
                                               + "0. Salir"
                                               ).charAt(0);

            switch (opcion) 
            {
                case '1':
                    this.gestAsig.agregarAsignatura();
                    break;
                    
                case '2':
                    if (!this.gestAsig.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else                    
                        this.gestAsig.buscarAsignatura();
                    break;
                    
                case '3':
                    if (!this.gestAsig.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else 
                    this.gestAsig.verTodos();
                    break;
                    
                case '4':
                    if (!this.gestAsig.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else 
                    this.modificacionesAsignaturas();
                    break;
                    
                case '5':
                    if (!this.gestAsig.checkExistencias()) 
                    {
                        JOptionPane.showMessageDialog(null,"Debe capturar datos primero!","Error",0);
                    }
                    else 
                    this.gestAsig.eliminarAsignatura();
                    break;
                                    
                case '0':
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe!", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }
    
    private void modificacionesAsignaturas()
    {
        char opcion;
        do
        {
            opcion=JOptionPane.showInputDialog("======MODIFICAR ASIGNATURA======\n"
                                               + "1. Modificar codigo \n"
                                               + "2. Modificar nombre\n"
                                               + "3. Modificar créditos\n"
                                               + "0. Regresar"
                                               ).charAt(0);

            switch (opcion) 
            {
                case '1':
                    this.gestAsig.modificarCodigo();
                    break;                    
                case '2':
                    this.gestAsig.modificarNombre();
                    break;                    
                case '3':
                    this.gestAsig.modificarCreditos();
                    break;                          
                case '0':                    
                    break;                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe!", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }
    
    private void menuInscripcion()
    {
        char opcion;
        do
        {
            opcion=JOptionPane.showInputDialog("======MENU INSCRIPCION======\n"
                                               + "1. Inscribir materias \n"
                                               + "2. Ver inscritas\n"
                                               + "3. Retirar materia\n"
                                               + "0. Regresar"
                                               ).charAt(0);

            switch (opcion) 
            {
                case '1':
                    this.gestIns.agregarInscipcion();
                    break;                    
                case '2':
                    this.gestIns.verInscritas();
                    break;                    
                case '3':
                    this.gestIns.retirarMateria();
                    break;                          
                case '0':                    
                    break;                    
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe!", "Aviso", 2);
                    break;
            }
        }
        while(opcion != '0');
    }
}