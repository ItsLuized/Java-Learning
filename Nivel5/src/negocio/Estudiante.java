/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import java.util.ArrayList;
import negocio.Asignatura;
/**
 *
 * @author Luized
 */
public class Estudiante 
{
    //Atributos:
    private String codigo;
    private String nombre;
    private String apellidos;
    private char genero;
    private String telefono;
    //private ArrayList<Asignatura> tomadas;
    
    //Constructores
    public Estudiante() 
    {
        this.codigo = "";
        this.nombre = "";
        this.apellidos = "";
        this.genero = '*';
        this.telefono = "";
    }

    public Estudiante(String codigo, String nombre, String apellidos, char genero, String telefono) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.telefono = telefono;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellidos;
    }

    public char getGenero() {
        return this.genero;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString()
    {
        return this.codigo+ ","+ this.nombre+ "," + this.apellidos + "," + this.genero + "," + this.telefono;
    }
}
