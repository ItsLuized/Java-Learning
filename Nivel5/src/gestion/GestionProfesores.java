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
import negocio.Profesor;
import negocio.Asignatura;

/**
 *
 * @author Luized
 */
public class GestionProfesores {
    private final String rutArchivo;
    private final GestionAsignatura gestAsig;
    
    public GestionProfesores() 
    {
        this.rutArchivo = "./Archivos/Profesores.txt";
        this.verificaArchivo();  
        gestAsig = new GestionAsignatura();
    }
    
    public void agregarProfesor()
    {
        String identificacion, nombre, apellido, auxiliar;
        ArrayList<Asignatura> Asignaturas = this.gestAsig.getTodos();
        ArrayList<String> dictados = new ArrayList();
        boolean valido = false;
        int salir = 0;
        //Capturar informacion del profesor
        do
        {
            identificacion = JOptionPane.showInputDialog("Digite la identificaion del profesor:");
            valido=this.verificarExistencia(identificacion);
            if (valido) 
            {
                JOptionPane.showMessageDialog(null, "Esa identificacion ya existe", "Error!", 0);
            }
        }
        while(valido);
        
        nombre = JOptionPane.showInputDialog("Digite el nombre:").toUpperCase();
        apellido = JOptionPane.showInputDialog("Digite los apellidos:").toUpperCase();
        this.gestAsig.verTodos();
        do
        {
            auxiliar = JOptionPane.showInputDialog("Digite el codigo de las materias que dicta:").toUpperCase();
            valido = this.gestAsig.verificarExistencia(auxiliar);
            if (valido) 
            {
                if (dictados.contains(auxiliar)) 
                {
                    JOptionPane.showMessageDialog(null, "Ya esa materia la dicta el profesor");
                }
                else
                {
                dictados.add(auxiliar);
                }
                salir = Integer.parseInt(JOptionPane.showInputDialog("Quiere seguir agregando materias?"
                                                                    + " \n 1. Si\n 0. No, Salir"));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ese codigo no existe", "Error!", 0);
            }
            
        }while(salir == 1);
        //Crear al profesor
        Profesor teacher = new Profesor(identificacion, nombre, apellido, dictados);
        //Guardar el profesor en el archivo
        this.guardaProfesor(teacher);
    }
    
    private void guardaProfesor(Profesor teacher)
    {
        File file;
        FileWriter fw;
        PrintWriter pw;
        
        try 
        {
            file = new File(this.rutArchivo);
            fw = new FileWriter (file, true);
            pw = new PrintWriter(fw);
                pw.println(teacher);
            pw.close();
            JOptionPane.showMessageDialog(null, "El profesor ha sido guardado en la base...", "Aviso", 1);
        }
        catch (IOException ex) 
        {
            System.out.println("Problemas guardando el profesor...");
        }
    }
    
    public void buscarProfesor() //Si es solo mostrarlo
    {
        String code, registro;
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        
        code = JOptionPane.showInputDialog("Digite la identificacion a buscar:");
        
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
                JOptionPane.showMessageDialog(null, "Esa identificacion no existe!", "Aviso", 0);
            }
            System.out.println("=============================================");
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando profesor...");
        }
    }
    
    public Profesor getProfesor()//Si tiene que devolver al profesor
    {
        String code, registro;
        boolean existe = false;
        Profesor teacher = null;
        FileReader file;
        BufferedReader br;
        ArrayList<String> materia;
        
        code = JOptionPane.showInputDialog("Digite la identificacion a buscar:");
        
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while((registro=br.readLine())!= null)//mientras haya registro
            {
                String pieces[] = registro.split(",");
                if (code.equals(pieces[0])) 
                {
                    materia = new ArrayList<>();
                    for (int i = 3; i < pieces.length; i++) 
                    {
                    materia.add(pieces[i]);
                    }
                    teacher = new Profesor(pieces[0], pieces[1], pieces[2],materia);
                    existe = true;
                    break;
                }  
            }
            if (!existe) 
            {
                JOptionPane.showMessageDialog(null, "Esa identificacion no existe!", "Aviso", 0);
            }
            
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando profesor...");
        }
        return teacher;
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
            System.out.println("Problemas buscando los profesores...");
        } 
        System.out.println("=============================================");
    }
        
    public ArrayList<Profesor> getTodos()//Si tiene que devolver los profesores
    {
        ArrayList<Profesor> teachers = new ArrayList();
        Profesor teacher = null;
        String registro;
        FileReader file;
        BufferedReader br;
        ArrayList<String> materia;
        
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while((registro=br.readLine())!= null)//mientras haya registro
            {
                String pieces[] = registro.split(",");

                materia = new ArrayList<>();
                for (int i = 3; i < pieces.length; i++) 
                {
                    materia.add(pieces[i]);
                }

                teacher = new Profesor(pieces[0], pieces[1], pieces[2],materia);
                teachers.add(teacher);               
            }            
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando al profesor...");
        }       
        return teachers;
    }  
    
    public String nombrePorCodigo(String identificacion)
    {
        String nombre = "";
        ArrayList<Profesor> profesor = this.getTodos();
        for (Profesor profe : profesor) 
        {
            if (identificacion.equals(profe.getIdentificacion())) 
            {
                nombre = profe.getNombre() + " "+ profe.getApellido();
                break;
            }
        }
        return nombre;
    }
    
    public void modificarIdentificacion()
    {
        String code, newId;
        boolean existe = false, valido = false;
        ArrayList<Profesor> Profesores = this.getTodos();
        
        code = JOptionPane.showInputDialog("Digite la identificacion a buscar:");
        
        for(Profesor teacher : Profesores)
        {
            
            if (code.equals(teacher.getIdentificacion())) 
            {
                do
                {
                    //modificarlo
                    newId = JOptionPane.showInputDialog("Digite la nueva identificacion:");
                    valido = this.verificarExistencia(newId);
                        if(valido)
                        {
                            JOptionPane.showMessageDialog(null, "Esa identificacion ya existe!", "Aviso", 2);
                        }
                        else
                        {
                            teacher.setIdentificacion(newId);
                        }
                }
                while(valido);
                this.reemplazarArchivo(Profesores);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Esa identificacion no existe!", "Aviso", 2);
    }
    
    public void modificarNombre()
    {
        String code, newName;
        boolean existe = false;
        code = JOptionPane.showInputDialog("Digite la identificacion a buscar:");
        
        ArrayList <Profesor> misProfesores = this.getTodos();
        for(Profesor teacher : misProfesores)
        {
            if (teacher.getIdentificacion().equals(code)) 
            {
                //modificarlo
                newName = JOptionPane.showInputDialog("Digite el nuevo nombre:");
                teacher.setNombre(newName.toUpperCase());
                this.reemplazarArchivo(misProfesores);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Esa identificacion no existe!", "Aviso", 2);
    }
    
    public void modificarApellidos()
    {
        String code, newApellido;
        boolean existe = false;
        code = JOptionPane.showInputDialog("Digite la identificacion a buscar:");
        
        ArrayList <Profesor> Profesores = this.getTodos();
        for(Profesor teacher : Profesores)
        {
            if (teacher.getIdentificacion().equals(code)) 
            {
                //modificarlo
                newApellido = JOptionPane.showInputDialog("Digite el nuevo apellido:");
                teacher.setApellido(newApellido.toUpperCase());
                this.reemplazarArchivo(Profesores);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Esa identificacion no existe!", "Aviso", 2);
    }
    
    public void modificarDictadas()
    {
        ArrayList<Asignatura> Asignaturas = this.gestAsig.getTodos();
        ArrayList <Profesor> Profesores = this.getTodos();
        ArrayList<String> dictados = new ArrayList();
        boolean existe = false, valido = false;
        String outputAsig = "", outputProf = "", auxiliar = "";
        char opcion;
        int numero = 0, salir, prof,  asig;
        for(Asignatura materia : Asignaturas)
        {
            numero++;
            outputAsig += numero + ". " + materia.getNombre()+" "+ materia.getCodigo() + "\n";
        }
        numero = 0;
        for(Profesor profe : Profesores)
        {
                numero++;
                outputProf += numero + "." + profe.getNombre()+ " "+ profe.getApellido() +"\n";
        }
        
        prof = Integer.parseInt(JOptionPane.showInputDialog("Que profesor va a ajustarle las materias dictadas?:\n" + outputProf));
        
        for(Profesor teacher : Profesores)
        {
            dictados = teacher.getDictados();
            if (teacher.getIdentificacion().equals(Profesores.get(prof-1).getIdentificacion())) 
            {
                do
                {
                    opcion = JOptionPane.showInputDialog("Quiere: \n1.Agregar materias \n2.Eliminar materias").charAt(0);
                    switch (opcion) 
                    {
                        case '1':
                            asig = Integer.parseInt(JOptionPane.showInputDialog("Que materia va a dictar?:\n" + outputAsig));
                            valido = this.gestAsig.verificarExistencia(Asignaturas.get(asig-1).getCodigo());
                            if (valido) 
                            {
                                if (dictados.contains(Asignaturas.get(asig-1).getCodigo())) 
                                {
                                    JOptionPane.showMessageDialog(null, "Ya esa materia la dicta el profesor");
                                }
                                else
                                {
                                dictados.add(Asignaturas.get(asig-1).getCodigo());
                                this.reemplazarArchivo(Profesores);
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Esa materia no existe!", "Error!", 0);
                            }
                            break;
                        case '2':
                            valido = false;
                            System.out.println("teacher.getDictados()");
                            auxiliar = JOptionPane.showInputDialog("Digite el codigo de las materias que quiere eliminar:").toUpperCase();
                            valido = this.gestAsig.verificarExistencia(auxiliar);
                            if (valido)
                            {
                                dictados.remove(auxiliar);
                                this.reemplazarArchivo(Profesores);
                            }
                            else
                                JOptionPane.showMessageDialog(null,"Esa materia no existe!", "Error!", 0);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Esa opcion no existe!", "Aviso", 2);
                    }
                    do
                    {
                        salir = Integer.parseInt(JOptionPane.showInputDialog("Quiere seguir agregando/eliminando materias?"
                                                                                    + " \n 1. Si\n 0. No, Salir"));
                        if (salir <0 && salir > 1) 
                        {
                            JOptionPane.showMessageDialog(null, "Digite una opcion valida");
                        }
                    }
                    while(salir <0 && salir > 1);
                }
                while(salir == 1);
                existe = true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Tiene que digitar una opcion valida!", "Error!", 0);
    }
    
    public void eliminarProfesor()
    {
        String code;
        boolean existe = false;
        code = JOptionPane.showInputDialog("Digite la identificacion a buscar:");
        
        ArrayList<Profesor> Profesores = this.getTodos();
        
        for(Profesor teacher : Profesores)
        {
            if (code.equals(teacher.getIdentificacion()))
            {
                Profesores.remove(teacher);
                this.reemplazarArchivo(Profesores);
                existe = true;
                break;
            }  
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "Esa identificacion no existe!", "Aviso", 2);
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
    public boolean verificarExistencia(String identificacion)
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
                if(identificacion.equals(pieces[0]))
                {
                    existe = true;
                    break;
                }
            }
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando al profesor...");
        }                
        return existe;
    }
    
    private void reemplazarArchivo(ArrayList<Profesor> Profesores)
    {
        File file;
        FileWriter fw;
        PrintWriter pw;
        
        try 
        {
            file = new File(this.rutArchivo);
            fw = new FileWriter (file, false);
            pw = new PrintWriter(fw);
            for(Profesor teacher : Profesores)
            {
                pw.println(teacher);
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
            //Logger.getLogger(GestionProfesors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}