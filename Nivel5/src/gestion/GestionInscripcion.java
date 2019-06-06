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
import negocio.Inscripcion;
import negocio.Estudiante;
import negocio.Profesor;

/**
 *
 * @author Luized
 */
public class GestionInscripcion {
    private final String rutArchivo;
    private final GestionEstudiantes gestEst;
    private final GestionProfesores gestProf;
    private final GestionAsignatura gestAsig;

    public GestionInscripcion()
    {
        this.rutArchivo = "./Archivos/Inscripcion.txt";
        gestEst = new GestionEstudiantes();
        gestProf = new GestionProfesores();
        gestAsig = new GestionAsignatura();
        this.verificaArchivo();
    }

    public void agregarInscipcion()
    {
        String output = "", outputAsig = "", outputProf = "", codigoEstudiante = "", codigoAsignatura = "", codigoProf= "" ;
        int numero = 0, opcion, opcionAsig, opcionProf, salir = 0;
        ArrayList<Estudiante> estudiante = this.gestEst.getTodos();
        ArrayList<Asignatura> asignatura = this.gestAsig.getTodos();
        ArrayList<Profesor> profesores = this.gestProf.getTodos();
        boolean existe = false, existeProf = false, duplicado = false;

        for(Estudiante stud : estudiante)
        {
                numero++;
                output += numero + ". " + stud.getNombre()+" "+ stud.getApellido() + "\n";
        }
        numero = 0;
        for(Asignatura materia : asignatura)
        {
            numero++;
            outputAsig += numero + ". " + materia.getNombre()+" "+ materia.getCodigo() + "\n";
        }
        numero = 0;
        do
        {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Que estudiante va a inscribir materias?\n" + output));
            if (opcion < 0 || opcion > estudiante.size())
            {
                JOptionPane.showMessageDialog(null, "Digite una opcion valida");
            }
        }
        while(opcion < 0 || opcion > estudiante.size());
        do{
            outputProf = "";
            for(Estudiante stud : estudiante)
            {
                if(stud.getCodigo().equals(estudiante.get(opcion-1).getCodigo()))
                {
                    codigoEstudiante = stud.getCodigo();
                    do
                    {
                        existe = false;
                        existeProf = false;

                        opcionAsig = Integer.parseInt(JOptionPane.showInputDialog("Que materia quiere inscribir?\n" + outputAsig));

                        if (opcionAsig < 0 || opcionAsig > asignatura.size())
                        {
                            JOptionPane.showMessageDialog(null, "Esa materia no existe!", "Aviso", 2);
                            continue;
                        }
                        
                        
                        for(Asignatura materia : asignatura)
                        {
                            if(materia.getCodigo().equals(asignatura.get(opcionAsig-1).getCodigo()))
                            {
                                codigoAsignatura = materia.getCodigo();
                                duplicado = this.verficarDuplicado(codigoEstudiante, codigoAsignatura);
                                if (duplicado) 
                                {
                                    JOptionPane.showMessageDialog(null, "Ya inscribio esa materia!", "Error", 0);
                                    break;
                                }
                                numero = 0;
                                ArrayList<Profesor> teacher = new ArrayList<>();
                                for(Profesor profe : profesores)
                                {
                                    if (profe.getDictados().contains(materia.getCodigo()))
                                    //No lee de manera correcta ya que las llaves que genera el array, lo impiden
                                    {
                                        numero++;
                                        outputProf += numero + "." + profe.getNombre()+ " "+ profe.getApellido() +"\n";
                                        teacher.add(profe);
                                        existeProf = true;
                                    }
                                }
                                if (!existeProf) {
                                    JOptionPane.showMessageDialog(null, "No hay profesores que dicten esa materia!");
                                    break;
                                }
                                else
                                {
                                    do
                                    {
                                        opcionProf = Integer.parseInt(JOptionPane.showInputDialog("Que profesor quiere que le dicte la materia?\n" + outputProf));               
                                    }
                                    while(opcionProf < 0 || opcionProf > profesores.size());
                                    codigoProf = teacher.get(opcionProf-1).getIdentificacion();
                                }
                            }
                        }
                    }
                    while(opcionAsig < 0 || opcionAsig > asignatura.size());
                    existe = true;
                }
            }
            if (!existe) {
                JOptionPane.showMessageDialog(null, "Ese codigo no existe!", "Error", 0);
            }

            if (existe && existeProf && !duplicado) {
                Inscripcion inscripcion = new Inscripcion(codigoEstudiante, codigoAsignatura, codigoProf);
                this.guardaInscripcion(inscripcion);
            }

            do {
                salir = Integer.parseInt(JOptionPane.showInputDialog("Quiere seguir inscribiendo materias? \n1.Si \n0.No, salir!"));
            } while (salir < 0 || salir > 1);
        }
        while(salir !=0);
        //Guardar la materia en el archivo

    }

    private void guardaInscripcion(Inscripcion inscripcion)
    {
        File file;
        FileWriter fw;
        PrintWriter pw;

        try
        {
            file = new File(this.rutArchivo);
            fw = new FileWriter (file, true);
            pw = new PrintWriter(fw);
                pw.println(inscripcion);
            pw.close();
            JOptionPane.showMessageDialog(null, "La materia ha sido guardado en la base...", "Aviso", 1);
        }
        catch (IOException ex)
        {
            System.out.println("Problemas guardando la materia...");
        }
    }

    public void verInscritas() //
    {
        String code, output = "", name;
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        int numero = 0, opcion;
        ArrayList<Estudiante> estudiante = gestEst.getTodos();
        
        for(Estudiante stud : estudiante)
        {
                numero++;
                output += numero + ". " + stud.getNombre()+" "+ stud.getApellido() + "\n";
        }
        do
        {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Que estudiante va a ver las materias inscritas?\n" + output));
            if (opcion < 0 || opcion > estudiante.size())
            {
                JOptionPane.showMessageDialog(null, "Digite una opcion valida");
            }
        }
        while(opcion < 0 || opcion > estudiante.size());
        code = estudiante.get(opcion-1).getCodigo();
        ArrayList<Inscripcion> inscritas = this.getInscripciones(code);
        if (inscritas.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Inscriba materias!");
        }
        else
        {
            output = "";
            output = estudiante.get(opcion-1).getNombre()+ " " + estudiante.get(opcion-1).getApellido() + ":\n";
            for(Inscripcion ins : inscritas)
            {
                output += this.gestAsig.nombrePorCodigo(ins.getCodigoMateria()) + " : " + this.gestProf.nombrePorCodigo(ins.getCodigoProfesor()) + "\n";
            }
            System.out.println(output + "=============================================");
            JOptionPane.showMessageDialog(null, output);
        }
    }
    
    public ArrayList<Inscripcion> getInscripciones(String code)//Si tiene que devolver la inscripcion
    {
        String registro;
        boolean existe = false;
        ArrayList<Inscripcion> inscripcion = new ArrayList<>();
        FileReader file;
        BufferedReader br;
        
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while((registro=br.readLine())!= null)//mientras haya registro
            {
                String pieces[] = registro.split(",");
                if (code.equals(pieces[0])) 
                {                              //codigoEst,CodigoAsig,codigoProfe.
                    inscripcion.add(new Inscripcion(pieces[0], pieces[1], pieces[2]));
                    existe = true;
                }  
            }
            if (!existe) 
            {
                JOptionPane.showMessageDialog(null, "No ha inscrito materias!", "Aviso", 0);
            }
            
        } 
        catch (IOException ex) 
        {
            System.out.println("Problemas buscando profesor...");
        }
        return inscripcion;
    }

    public ArrayList<Inscripcion> getTodos()//Si tiene que devolver la materia
    {
        ArrayList<Inscripcion> inscritas = new ArrayList();
        Inscripcion inscripcion = null;
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
                inscripcion = new Inscripcion(pieces[0], pieces[1], pieces[2]);
                inscritas.add(inscripcion);
            }
        }
        catch (IOException ex)
        {
            System.out.println("Problemas buscando la materia...");
        }
        return inscritas;
    }

    public void retirarMateria()
    {
        String code, output = "", outputAsig = "";
        boolean existe = false;
        int numero = 0, opcion, opcion2;
        ArrayList<Inscripcion> inscrita = this.getTodos();
        ArrayList<Estudiante> estudiante = this.gestEst.getTodos();
        ArrayList<Asignatura> asignatura = this.gestAsig.getTodos();
        for(Estudiante stud : estudiante)
        {
                numero++;
                output += numero + ". " + stud.getNombre()+" "+ stud.getApellido() + "\n";
        }
        numero = 0;
        for(Asignatura materia : asignatura)
        {
            numero++;
            outputAsig += numero + ". " + materia.getNombre()+" "+ materia.getCodigo() + "\n";
        }
        
        do
        {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Que estudiante va a ver las materias inscritas?\n" + output));
            if (opcion < 0 || opcion > estudiante.size())
            {
                JOptionPane.showMessageDialog(null, "Digite una opcion valida");
            }
        }
        while(opcion < 0 || opcion > estudiante.size());
        
        do
        {
            opcion2 = Integer.parseInt(JOptionPane.showInputDialog("Que materia quiere retirar?\n" + outputAsig));
            if (opcion < 0 || opcion > estudiante.size())
            {
                JOptionPane.showMessageDialog(null, "Digite una opcion valida");
            }
        }
        while(opcion < 0 || opcion > estudiante.size());

        for(Inscripcion ins : inscrita)
        {
            if (asignatura.get(opcion2-1).getCodigo().equals(ins.getCodigoMateria()) && estudiante.get(opcion-1).getCodigo().equals(ins.getCodigoEstudiante()))
            {
                inscrita.remove(ins);
                this.reemplazarArchivo(inscrita);
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
    public boolean verficarDuplicado(String codigo, String materia)
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
                if(codigo.equals(pieces[0]) && materia.equals(pieces[1]))
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

    private void reemplazarArchivo(ArrayList<Inscripcion> Inscritas)
    {
        File file;
        FileWriter fw;
        PrintWriter pw;

        try
        {
            file = new File(this.rutArchivo);
            fw = new FileWriter (file, false);
            pw = new PrintWriter(fw);
            for(Inscripcion inscrita : Inscritas)
            {
                pw.println(inscrita);
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