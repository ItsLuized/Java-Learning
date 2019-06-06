package gestion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.Asignatura;
import negocio.Estudiante;

/**
 *
 * @author Luized
 */
public class GestionEstudiantes {
    private String rutArchivo;
    private gestion.GestionAsignatura gestAsig;

    public GestionEstudiantes() 
    {
        this.rutArchivo = "./Archivos/misEstudiantes.txt";
        this.gestAsig = new GestionAsignatura();
        this.verificaArchivo();    
    }
    
    public void agregarEstudiante()
    {
        String code, name, lastName, tele, aux;
        char gender, auxiliar;
        boolean valido = false;
        ArrayList<Asignatura> tomadas = new ArrayList();
        int salir = 0;
        //Capturar informacion del estudiante
        do
        {
            code = JOptionPane.showInputDialog("Digite el codigo:");
            valido=this.verificarExistencia(code);
            if (valido) 
            {
                JOptionPane.showMessageDialog(null, "Ese codigo ya existe", "Error!", 0);
            }
        }
        while(valido);
        
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
        this.gestAsig.verTodos();
        //Crear al estudiante
        Estudiante stud = new Estudiante(code, name, lastName, gender, tele/*, tomadas*/);
        //Guardar el estudiante en el archivo
        this.guardaEstudiante(stud);
    }
    
    private void guardaEstudiante(Estudiante stud)
    {
        File file;
        FileWriter fw;
        PrintWriter pw;
        
        try 
        {
            file = new File(this.rutArchivo);
            fw = new FileWriter (file, true);
            pw = new PrintWriter(fw);
                pw.println(stud);
            pw.close();
            JOptionPane.showMessageDialog(null, "El estudiante ha sido guardado en la base...", "Aviso", 1);
        }
        catch (IOException ex) 
        {
            System.out.println("Problemas guardando el estudiante...");
        }
    }
    
    public void buscarEstudiante() //Si es solo mostrarlo
    {
        String code, registro;
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while((registro = br.readLine())!= null)//mientras haya registro
            {
                String pieces[] = registro.split(",");
                if (code.equals(pieces[0])) 
                {
                    System.out.println(registro);
                    existe = true;
                    break;
                }  
            }
            if (!existe) 
            {
                JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 0);
            }
            System.out.println("=============================================");
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando estudiante...");
        }
    }
            
    public Estudiante getEstudiante()//Si tiene que devolver al estudiante
    {
        String code, registro;
        boolean existe = false;
        Estudiante stud = null;
        FileReader file;
        BufferedReader br;
        
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while((registro=br.readLine())!= null)//mientras haya registro
            {
                String pieces[] = registro.split(",");
                if (code.equals(pieces[0])) 
                {
                    stud = new Estudiante(pieces[0], pieces[1], pieces[2], pieces[3].charAt(0), pieces[4]);
                    existe = true;
                    break;
                }  
            }
            if (!existe) 
            {
                JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 0);
            }
            
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando estudiante...");
        }
        return stud;
    }
        
    public void verTodos()//Si es solo mostrar el listado
    {
        String registro;
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while((registro=br.readLine())!= null)//mientras haya registro
            {
                    System.out.println(registro);
            }      
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando los estudiantes...");
        } 
        System.out.println("=============================================");
    }
        
    public ArrayList<Estudiante> getTodos()//Si tiene que devolver los estudiantes
    {
        ArrayList<Estudiante> students = new ArrayList();
        Estudiante stud = null;
        String registro;
        FileReader file;
        BufferedReader br;
        
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while((registro=br.readLine())!= null)//mientras haya registro
            {
                String pieces[] = registro.split(",");
                stud = new Estudiante(pieces[0], pieces[1], pieces[2], pieces[3].charAt(0), pieces[4]);
                students.add(stud);               
            }            
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando estudiante...");
        }       
        return students;
    }  
    
    public void modificarCodigo()
    {
        String code, newCode;
        boolean existe = false, valido = false;
        ArrayList<Estudiante> misEstudiantes = this.getTodos();
        
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:");
        
        for(Estudiante stud : misEstudiantes)
        {
            
            if (code.equals(stud.getCodigo())) 
            {
                do
                {
                    //modificarlo
                    newCode = JOptionPane.showInputDialog("Digite el nuevo codigo:");
                    valido = this.verificarExistencia(newCode);
                        if(valido)
                        {
                            JOptionPane.showMessageDialog(null, "Ese codigo ya existe!", "Aviso", 2);
                        }
                        else
                        {
                            stud.setCodigo(newCode);
                        }
                }
                while(valido);
                this.reemplazarArchivo(misEstudiantes);
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
        
        ArrayList <Estudiante> misEstudiantes = this.getTodos();
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                //modificarlo
                newName = JOptionPane.showInputDialog("Digite el nuevo nombre:");
                stud.setNombre(newName.toUpperCase());
                this.reemplazarArchivo(misEstudiantes);
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
        
        ArrayList <Estudiante> misEstudiantes = this.getTodos();
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                //modificarlo
                newApellido = JOptionPane.showInputDialog("Digite el nuevo apellido:");
                stud.setApellido(newApellido.toUpperCase());
                this.reemplazarArchivo(misEstudiantes);
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
        
        ArrayList <Estudiante> misEstudiantes = this.getTodos();
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
                this.reemplazarArchivo(misEstudiantes);
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
        
        ArrayList <Estudiante> misEstudiantes = this.getTodos();
        for(Estudiante stud : misEstudiantes)
        {
            if (stud.getCodigo().equals(code)) 
            {
                //modificarlo
                newPhone = JOptionPane.showInputDialog("Digite el nuevo telefono:");
                stud.setTelefono(newPhone);
                this.reemplazarArchivo(misEstudiantes);
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
        
        ArrayList<Estudiante> misEstudiantes = this.getTodos();
        
        for(Estudiante stud : misEstudiantes)
        {
            if (code.equals(stud.getCodigo()))
            {
                misEstudiantes.remove(stud);
                this.reemplazarArchivo(misEstudiantes);
                existe = true;
                break;
            }  
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 2);
    }
    
    public boolean checkExistencias()
    {
        boolean hay = false;
        FileReader file;
        BufferedReader br;
        
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            if(br.readLine() != null)
            {
                hay = true;
            }
            else 
            {
                BufferedWriter bw = new BufferedWriter(new FileWriter(this.rutArchivo));
                bw.write("");
                bw.close();
            }
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando estudiante...");
        }
        return hay;
    }
    
    //--------------------------------------------------------------------------------------
    public boolean verificarExistencia(String code)
    {
        boolean existe = false;
        String registro;
        FileReader file;
        BufferedReader br;
        
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null)
            {
                String pieces[] = registro.split(",");
                if(code.equals(pieces[0]))
                {
                    existe = true;
                    break;
                }
            }
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando al estudiante...");
        }                
        return existe;
    }
    
    private void reemplazarArchivo(ArrayList<Estudiante> students)
    {
        File file;
        FileWriter fw;
        PrintWriter pw;
        
        try 
        {
            file = new File(this.rutArchivo);
            fw = new FileWriter (file, false);
            pw = new PrintWriter(fw);
            for(Estudiante stud : students)
            {
                pw.println(stud);
            }
              pw.close();             
            JOptionPane.showMessageDialog(null, "El archivo a sido actualizado...", "Aviso", 1);
        }
        catch (IOException ex) 
        {
            System.out.println("Problemas reemplazando archivo...");
        }
    }
    
    private void verificaArchivo()
    {
        try 
        {
            File filex = new File(this.rutArchivo);
            if (!filex.exists()) 
                filex.createNewFile();//lo crea
        } 
        catch (IOException ex) 
        {
            System.out.println("Falló búsqueda de ruta...");
            //Logger.getLogger(GestionEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}