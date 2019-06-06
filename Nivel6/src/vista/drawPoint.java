package vista;

import java.awt.Color;
import negocio.Punto;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class drawPoint extends JApplet
{
    private Punto puntico;
    
    public void init()
    {
        this.capturaDatos();
    }
    
    private void capturaDatos()
    {
        int x, y;
        x = Integer.parseInt(JOptionPane.showInputDialog("cordenada x:"));
        y = Integer.parseInt(JOptionPane.showInputDialog("cordenada y:"));
        this.puntico = new Punto(x,y);
    }
    
    public void paint(Graphics pintor)
    {
        boolean listo = false;
        int r, g, b, respuesta = 0;
        
        do{
        r = (int)(Math.random()*255);
        g = (int)(Math.random()*255);
        b = (int)(Math.random()*255);
        Color colorcito = new Color(r, g, b);
        pintor.setColor(colorcito);
        pintor.drawOval(this.puntico.getX(), this.puntico.getY(), 1, 1);
        respuesta = Integer.parseInt(JOptionPane.showInputDialog("Quiere seguir dibujando moscas? (1. Si 2.No)"));
        if(respuesta == 1)
        {
            this.capturaDatos();
        }
        }while(respuesta != 2);
    }
}
