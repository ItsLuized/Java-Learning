/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.Estudiante;

/**
 *
 * @author Luized
 */
public class GestionEstudiantes {
    private ArrayList <Estudiante> misEstudiantes;
    

    public GestionEstudiantes() 
    {
        this.misEstudiantes = new ArrayList();
    }
    
    
    
    public void agregarEstudiante()
    {
        String code, name, lastName, tele;
        char gender, auxiliar;
        boolean valido = false;
        //Capturar informacion del estudiante
        do{
            valido = true;
            code = JOptionPane.showInputDialog("Digite el codigo:");
            for(Estudiante stud : misEstudiantes)
            {
                if (stud.getCodigo().equals(code)) 
                {
                    JOptionPane.showMessageDialog(null, "Ese codigo ya existe!", "Aviso", 2);
                    valido = false;
                    break;
                }
            }
        }
        while(!valido);
        valido = false;
        
        name = JOptionPane.showInputDialog("Digite el nombre:").toUpperCase();
        lastName = JOptionPane.showInputDialog("Digite los apellidos:").toUpperCase();
        
        do
        {
            gender = JOptionPane.showInputDialog("Digite el generos (M o F):").toUpperCase().charAt(0);
            if (gender == 'M'|| gender == 'F') 
            {
                valido = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Digite M para masculino o F para Fememino", "Aviso", 2);
                valido = false;
            }
        }
        while(!valido);
        valido = false;
        
        tele = JOptionPane.showInputDialog("Digite el numero de telefono:");

        //Crear al estudiante
        Estudiante stud = new Estudiante(code, name, lastName, gender, tele);
        //Guardarlo en el contenedor
        this.misEstudiantes.add(stud);
        JOptionPane.showMessageDialog(null, "La operacion se realizo con exito!", "Aviso", 1);
    }
    
    public void buscarEstudiante()
    {
        String code;
        boolean existe = false;
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                System.out.println(stud);
                System.out.println("=============================================");
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 2);
    }
    
    public void verTodos()
    {
        for(Estudiante stud : this.misEstudiantes)
        {
            System.out.println(stud);
        }
        System.out.println("=============================================");
    }
    
    public void modificarCodigo()
    {
        String code, newCode;
        boolean existe = false;
        
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                //modificarlo
                newCode = JOptionPane.showInputDialog("Digite el nuevo codigo:");
                stud.setCodigo(newCode);
                JOptionPane.showMessageDialog(null, "La operacion se realizo con exito!", "Aviso", 1);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 2);
    }
    
    public void modificarNombre()
    {
        String code, newName;
        boolean existe = false;
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                //modificarlo
                newName = JOptionPane.showInputDialog("Digite el nuevo nombre:");
                stud.setNombre(newName.toUpperCase());
                JOptionPane.showMessageDialog(null, "La operacion se realizo con exito!", "Aviso", 1);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 2);
    }
    
    public void modificarApellidos()
    {
        String code, newApellido;
        boolean existe = false;
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                //modificarlo
                newApellido = JOptionPane.showInputDialog("Digite el nuevo apellido:");
                stud.setApellido(newApellido.toUpperCase());
                JOptionPane.showMessageDialog(null, "La operacion se realizo con exito!", "Aviso", 1);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 2);
    }
    
    public void modificarGenero()
    {
        String code;
        char newGender;
        boolean existe = false;
        boolean valido = false;
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                //modificarlo
                do
                {
                    newGender = JOptionPane.showInputDialog("Digite el genero (M o F):").toUpperCase().charAt(0);
                    if (newGender == 'M'|| newGender == 'F') 
                    {
                        valido = true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Digite M para masculino o F para Fememino", "Aviso", 2);
                        valido = false;
                    }
                }
                while(!valido);
                
                stud.setGenero(newGender);
                JOptionPane.showMessageDialog(null, "La operacion se realizo con exito!", "Aviso", 1);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 2);
    }
    
    public void modificarTelefono()
    {
        String code, newPhone;
        boolean existe = false;
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                //modificarlo
                newPhone = JOptionPane.showInputDialog("Digite el nuevo telefono:");
                stud.setTelefono(newPhone);
                JOptionPane.showMessageDialog(null, "La operacion se realizo con exito!", "Aviso", 1);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 2);
    
    }
    
    public void eliminarEstudiante()
    {
        String code;
        boolean existe = false;
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                this.misEstudiantes.remove(stud);
                JOptionPane.showMessageDialog(null, "La operacion se realizo con exito!", "Aviso", 1);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 2);
    }
    
}
