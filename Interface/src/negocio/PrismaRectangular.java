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
public class PrismaRectangular extends Figura implements PropiedadesFigura
{

    public PrismaRectangular() 
    {
        
    }
    
    public PrismaRectangular(int x, int y, int d1, int d2, int d3) //x, y son cordenadas; D1 y D2 son lados; D3 es la altura.
    {
        super(x, y, d1, d2, d3);
    }
    
    
    @Override
    public float getPerimetro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getArea() {
        return (float)(2 * (this.getD1() * this.getD2()) + (this.getD1() * this.getD3()) + (this.getD2() * this.getD3()));
    }

    @Override
    public float getVolumen() {
        return (float)(this.getD1() * this.getD2() * this.getD3());
    }
    
}
