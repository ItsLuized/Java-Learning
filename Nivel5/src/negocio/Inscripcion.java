package negocio;

public class Inscripcion 
{
    private String codigoEstudiante;
    private String codigoMateria;
    private String codigoProfesor;

    public Inscripcion(String codigoEstudiante, String codigoMateria, String codigoProfesor) {
        this.codigoEstudiante = codigoEstudiante;
        this.codigoMateria = codigoMateria;
        this.codigoProfesor = codigoProfesor;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    @Override
    public String toString() {
        return codigoEstudiante + "," + codigoMateria + "," + codigoProfesor;
    }
}
