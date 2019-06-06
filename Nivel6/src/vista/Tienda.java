package vista;

import java.awt.Color;
import negocio.Circulo;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import negocio.Punto;

public class Tienda extends JApplet
{
    private Circulo circulito;
    private Punto puntico;
    
    @Override
    public void init()
    {
        
    }
    
    @Override
    public void stop()
    {
        System.exit(0);
    }
    
    public void capturaDatosCirculo()
    {
        int r, x, y;
        r = Integer.parseInt(JOptionPane.showInputDialog("radio:"));
        x = Integer.parseInt(JOptionPane.showInputDialog("cordenada x del centro:"));
        y = Integer.parseInt(JOptionPane.showInputDialog("cordenada y del centro:"));
        this.circulito = new Circulo(r,x,y);
    }
    private void capturaDatosPunto()
    {
        int x, y;
        x = Integer.parseInt(JOptionPane.showInputDialog("cordenada x:"));
        y = Integer.parseInt(JOptionPane.showInputDialog("cordenada y:"));
        this.puntico = new Punto(x,y);
    }
    
    @Override
    public void paint(Graphics pintor)
    {
        int r, g, b;
        int opcion;
        
        do{
            r = (int)(Math.random()*255);
            g = (int)(Math.random()*255);
            b = (int)(Math.random()*255);
            Color colorcito = new Color(r, g, b);
            pintor.setColor(colorcito);
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Que quiere dibuajar? \n1.Circulo \n2.Punto \n0.Salir"));
            switch (opcion) 
            {
                case 1:
                    this.capturaDatosCirculo();
                    pintor.drawOval(this.circulito.getX() - this.circulito.getR(), this.circulito.getY() - this.circulito.getR(), 2*this.circulito.getR(), 2*this.circulito.getR());
                    pintor.drawOval(this.circulito.getX(), this.circulito.getY(), 1, 1);
                    break;
                case 2:
                    this.capturaDatosPunto();
                    pintor.drawOval(this.puntico.getX(), this.puntico.getY(), 1, 1);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Chao!");
                    this.stop();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Escoga una opcion valida", "Error!", 0);
            }
        }
        while(opcion != 0);
    }
}
