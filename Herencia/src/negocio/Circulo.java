package negocio;

public class Circulo extends Punto
{
    private int r;

    public Circulo() 
    {
        super();
        this.r = 0;
    }

    public Circulo(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
    
    public float getPerimetro()
    {
        return (float)(2*Math.PI*this.r);
    }
    
    public float getArea()
    {
        return (float)(Math.PI*Math.pow(this.r, 2));
    }

    @Override
    public String toString() {
        return super.toString() + "," + r;
    }
    
}
