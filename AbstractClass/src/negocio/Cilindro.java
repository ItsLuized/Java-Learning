/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author CUGSF220
 */
public class Cilindro extends Figura
{

    public Cilindro() 
    {
        
    }

    public Cilindro(int x, int y, int d1, int d2, int d3) {
        super(x, y, d1, d2, 0);
    }
    
    @Override
    public float getArea()
    {
        
        return ((float)(2*Math.PI*this.getD1()*this.getD2()+(2*Math.PI*this.getD1())));
    }
    
    @Override
    public float getVolumen()
    {
        return (float)(Math.PI*Math.pow(this.getD1(), 2)*this.getD2());
    }

    @Override
    public float getPerimetro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return this.getX() + "," + this.getY() + "," + this.getD1() + "," + this.getD2();
    }
}