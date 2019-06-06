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
public class Cono extends Figura implements PropiedadesFigura
{

    public Cono() 
    {
        
    }

    public Cono(int x, int y, int d1, int d2, int d3) 
    {
        super(x, y, d1, d2, 0);
    }
    
    @Override
    public float getPerimetro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * this.getD1() * Math.sqrt(Math.pow(this.getD1(), 2) + Math.pow(this.getD2(), 2)));
    } 

    @Override
    public float getVolumen() {
        return (float) (Math.PI * Math.pow(this.getD1(), 2) * this.getD2())/3;
    }
    
}
