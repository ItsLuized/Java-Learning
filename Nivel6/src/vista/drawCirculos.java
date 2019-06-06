package vista;

import java.awt.Color;
import negocio.Circulo;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class drawCirculos extends JApplet
{
    private Circulo circulito;
    
    public void init()
    {
        this.capturaDatos();
    }
    
    private void capturaDatos()
    {
        int r, x, y;
        r = Integer.parseInt(JOptionPane.showInputDialog("radio:"));
        x = Integer.parseInt(JOptionPane.showInputDialog("cordenada x del centro:"));
        y = Integer.parseInt(JOptionPane.showInputDialog("cordenada y del centro:"));
        this.circulito = new Circulo(r,x,y);
    }
    
    public void paint(Graphics pintor)
    {
        int r, g, b, respuesta = 0;
        
        do{
        r = (int)(Math.random()*255);
        g = (int)(Math.random()*255);
        b = (int)(Math.random()*255);
        Color colorcito = new Color(r, g, b);
        pintor.setColor(colorcito);
        pintor.drawOval(this.circulito.getX() - this.circulito.getR(), this.circulito.getY() - this.circulito.getR(), 2*this.circulito.getR(), 2*this.circulito.getR());
        pintor.drawOval(this.circulito.getX(), this.circulito.getY(), 1, 1);
        
        respuesta = Integer.parseInt(JOptionPane.showInputDialog("Quiere seguir dibujando circulo? (1. Si 2.No)"));
        if(respuesta == 1)
        {
            this.capturaDatos();
        }
        }while(respuesta != 2);
    }
}
