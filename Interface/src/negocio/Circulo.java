package negocio;
import interfaces.PropiedadesFigura;

public class Circulo extends Figura implements PropiedadesFigura
{
    public Circulo() 
    {
        
    }

    public Circulo(int x, int y, int d1, int d2, int d3) 
    {
        super(x, y, d1, 0, 0);
    }
    
    @Override
    public float getPerimetro()
    {
        return (float)(2*Math.PI*this.getD1());
    }
    
    @Override
    public float getArea()
    {
        return (float)(Math.PI*Math.pow(this.getD1(), 2));
    }

    @Override
    public float getVolumen() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return this.getX() + "," + this.getY() + "," + this.getD1();
    }
}