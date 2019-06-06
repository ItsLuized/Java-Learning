/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Luized
 */
public class Figura 
{
    private int x;
    private int y;
    private int d1;
    private int d2;
    private int d3;

    public Figura() 
    {
        this.x = 0;
        this.y = 0;
        this.d1 = 0;
        this.d2 = 0;
        this.d3 = 0;
    }

    public Figura(int x, int y, int d1, int d2, int d3) {
        this.x = x;
        this.y = y;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public int getD3() {
        return d3;
    }

    public void setD3(int d3) {
        this.d3 = d3;
    }
}
