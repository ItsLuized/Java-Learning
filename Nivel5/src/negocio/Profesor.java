package negocio;

import java.util.ArrayList;

public class Profesor 
{
    private String identificacion;
    private String nombre;
    private String apellido;
    private ArrayList<String> dictados;

    public Profesor() 
    {
        
    }

    public Profesor(String identificacion, String nombre, String apellido, ArrayList<String> dictados) 
    {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dictados = dictados;
    }

    public String getIdentificacion() 
    {
        return identificacion;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public String getApellido() 
    {
        return apellido;
    }

    public ArrayList<String> getDictados() 
    {
        return dictados;
    }

    public void setIdentificacion(String identificacion) 
    {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }

    public void setDictados(ArrayList<String> dictados) 
    {
        this.dictados = dictados;
    }

    @Override
    public String toString() 
    {
        String materias = "";
        for (String mate : this.dictados) 
        {
            materias += "," + mate; 
        }
        return identificacion + "," + nombre + "," + apellido + materias;
    }   
}
