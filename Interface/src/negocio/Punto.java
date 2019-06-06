/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

public class Punto extends Figura
{

    public Punto() 
    {
        
    }
    
    public Punto(int x, int y, int d1, int d2, int d3) 
    {
        super(x, y, 0,0,0);
    }

    @Override
    public String toString() {
        return this.getX() + "," + this.getY();
    }
}
