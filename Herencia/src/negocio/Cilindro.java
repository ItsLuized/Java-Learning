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
public class Cilindro extends Circulo
{
    private int h;

    public Cilindro(int h) {
        this.h = 0;
    }

    public Cilindro(int h, int x, int y, int r) {
        super(x, y, r);
        this.h = h;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    public float getArea()
    {
        
        return ((float)(2*Math.PI*this.getR()*this.h+(2*Math.PI*this.getR())));
    }
    
    public float getVolumen()
    {
        return (float)(Math.PI*Math.pow(this.getR(), 2)*this.h);
    }
    
    @Override
    public String toString() {
        return super.toString() + "," + h;
    }
    
    
}
