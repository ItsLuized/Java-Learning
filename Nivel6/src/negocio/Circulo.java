package negocio;

public class Circulo 
{
    private int r;
    private int x;
    private int y;

    public Circulo() {
    }

    public Circulo(int r, int x, int y) {
        this.r = r;
        this.x = x;
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return r + "," + x + ","+ y ;
    }
    
}
