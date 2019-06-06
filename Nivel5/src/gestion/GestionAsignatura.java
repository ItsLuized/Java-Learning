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

/**
 *
 * @author Luized
 */
public class GestionAsignatura {
    private String rutArchivo;

    public GestionAsignatura() 
    {
        this.rutArchivo = "./Archivos/Asignaturas.txt";
        this.verificaArchivo();    
    }
    
    public void agregarAsignatura()
    {
        String codigo, nombre, aux;
        int creditos, auxiliar;
        boolean valido = false;
        //Capturar informacion dla materia
        
        nombre = JOptionPane.showInputDialog("Digite el nombre de la materia:").toUpperCase();
        aux = nombre.substring(0, 3);
        
        do
        {
            
            auxiliar = (int)(Math.random()*899)+100;
            codigo = Integer.toString(auxiliar);
            valido = this.verificarExistencia(codigo);
        }
        while(valido);
        
        codigo = aux + codigo;
        creditos = Integer.parseInt(JOptionPane.showInputDialog("Digite los creditos de la materia:"));
        
        //Crear la materia
        Asignatura materia = new Asignatura(codigo,nombre,creditos);
        //Guardar la materia en el archivo
        this.guardaAsignatura(materia);
    }
    
    private void guardaAsignatura(Asignatura materia)
    {
        File file;
        FileWriter fw;
        PrintWriter pw;
        
        try 
        {
            file = new File(this.rutArchivo);
            fw = new FileWriter (file, true);
            pw = new PrintWriter(fw);
                pw.println(materia);
            pw.close();
            JOptionPane.showMessageDialog(null, "La materia ha sido guardado en la base...", "Aviso", 1);
        }
        catch (IOException ex) 
        {
            System.out.println("Problemas guardando la materia...");
        }
    }
    
    public void buscarAsignatura() //Si es solo mostrarlo
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
            System.out.println("Problemas buscando profesor...");
        }
    }
    
    public Asignatura getAsignatura()//Si tiene que devolver la materia
    {
        String code, registro;
        boolean existe = false;
        Asignatura materia = null;
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
                    materia = new Asignatura(pieces[0], pieces[1], Integer.parseInt(pieces[2]));
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
            System.out.println("Problemas buscando profesor...");
        }
        return materia;
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
            System.out.println("Problemas buscando la materia...");
        } 
        System.out.println("=============================================");
    }
        
    public ArrayList<Asignatura> getTodos()//Si tiene que devolver la materia
    {
        ArrayList<Asignatura> materias = new ArrayList();
        Asignatura materia = null;
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
                materia = new Asignatura(pieces[0], pieces[1], Integer.parseInt(pieces[2]));
                materias.add(materia);               
            }            
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando la materia...");
        }       
        return materias;
    }  
    
    public String nombrePorCodigo(String codigo)
    {
        String nombre = "";
        ArrayList<Asignatura> asignatura = this.getTodos();
        for (Asignatura materia : asignatura) 
        {
            if (codigo.equals(materia.getCodigo())) 
            {
                nombre = materia.getNombre();
                break;
            }
        }
        return nombre;
    }
    
    public void modificarCodigo()
    {
       String codigo,newCodigo,numero,letras,nombre;
        boolean existe=false, valido= false;    
        int auxiliar;
        ArrayList <Asignatura> Asignaturas = this.getTodos();
        codigo = JOptionPane.showInputDialog("Digite el codigo a buscar ").toUpperCase();

        for (Asignatura materia: Asignaturas)
        {
            if (materia.getCodigo().equals(codigo))
            {
                nombre = materia.getNombre();
                letras = nombre.substring(0,3);
                do
                {
                    auxiliar = (int) (Math.random()*899)+100;
                    numero=Integer.toString(auxiliar);
                    newCodigo = letras + numero;
                    valido = this.verificarExistencia(newCodigo);
                }
                while(valido);
                materia.setCodigo(newCodigo);
                this.reemplazarArchivo(Asignaturas);
                existe=true;
                break;
            }
            else
            {
                if(!existe)
                JOptionPane.showMessageDialog(null,"Ese codigo no existe!", "Aviso", 2);
            }
        }
    }
    
    public void modificarNombre()
    {
        String codigo, nombre, letras, numeros, newCodigo;
        boolean existe = false, valido = false;
        
        codigo = JOptionPane.showInputDialog("Digite el codigo a buscar:").toUpperCase();
        
        ArrayList <Asignatura> Asignaturas = this.getTodos();
        for(Asignatura materia : Asignaturas)
        {
            if (materia.getCodigo().equals(codigo)) 
            {
                //modificarlo
                do
                {
                nombre = JOptionPane.showInputDialog("Digite el nuevo nombre:").toUpperCase();
                valido = this.verficarExistenciaNombre(nombre);
                }
                while(valido);
                
                materia.setNombre(nombre.toUpperCase());
                letras = nombre.substring(0, 3);
                numeros = materia.getCodigo().substring(3, 6);
                newCodigo = letras + numeros;
                materia.setCodigo(newCodigo);
                this.reemplazarArchivo(Asignaturas);
                existe = true;                
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Aviso", 2);
    }
    
    public void modificarCreditos()
    {
        String code;
        int newCred;
        boolean existe=false;
        code=JOptionPane.showInputDialog("Digite el codigo a buscar ").toUpperCase();

        ArrayList <Asignatura> misAsignaturas= this.getTodos();

        for (Asignatura asig: misAsignaturas)
        {
            if (asig.getCodigo().equals(code))
            {
                //modificarlo
                newCred = Integer.parseInt(JOptionPane.showInputDialog("Digite los nuevos creditos:"));
                asig.setCreditos(newCred);
                this.reemplazarArchivo(misAsignaturas);
                existe=true;
                break;
            }

        }
        if(!existe)
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
    }
    
    public void eliminarAsignatura()
    {
        String code;
        boolean existe = false;
        code = JOptionPane.showInputDialog("Digite el codigo a buscar:").toUpperCase();
        
        ArrayList<Asignatura> Asignaturas = this.getTodos();
        
        for(Asignatura materia : Asignaturas)
        {
            if (code.equals(materia.getCodigo()))
            {
                Asignaturas.remove(materia);
                this.reemplazarArchivo(Asignaturas);
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
            System.out.println("Problemas buscando profesor...");
        }
        return hay;
    }
    
    //--------------------------------------------------------------------------------------
    public boolean verificarExistencia(String codigo)
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
                if(codigo.equals(pieces[0]))
                {
                    existe = true;
                    break;
                }
            }
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando la materia...");
        }                
        return existe;
    }
    
    public boolean verficarExistenciaNombre(String nombre)
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
                if(nombre.equals(pieces[1]))
                {
                    existe = true;
                    break;
                }
            }
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando la materia...");
        }                
        return existe;
    }
    
    private void reemplazarArchivo(ArrayList<Asignatura> Asignaturas)
    {
        File file;
        FileWriter fw;
        PrintWriter pw;
        
        try 
        {
            file = new File(this.rutArchivo);
            fw = new FileWriter (file, false);
            pw = new PrintWriter(fw);
            for(Asignatura materia : Asignaturas)
            {
                pw.println(materia);
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
            //Logger.getLogger(GestionAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}