/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import interfaces.PropiedadesFigura;

/**
 *
 * @author Luized
 */
public class Esfera extends Figura implements PropiedadesFigura
{
    
    public Esfera()
    {
        
    }
    
    public Esfera(int x, int y, int d1, int d2, int d3)
    {
        super(x,y,d1,0,0);
    }

    @Override
    public float getPerimetro() 
    {
        return (float) (2 * Math.PI * this.getD1());
    }

    @Override
    public float getArea() 
    {
        return (float)(4 * Math.PI * Math.pow(this.getD1(),2));
    }

    @Override
    public float getVolumen() 
    {
        return (float) ((4/3) * Math.PI * Math.pow(this.getD1(), 3));
    }

    @Override
    public String toString() 
    {
        return this.getX() + "," + this.getY() + "," + this.getD1() + "," + this.getD2();
    }
}
