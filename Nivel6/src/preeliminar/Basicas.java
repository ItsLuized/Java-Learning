/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preeliminar;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

/**
 *
 * @author CUGSF220
 */
public class Basicas extends JApplet 
{    
    /*
    public void init() 
    {
        JOptionPane.showMessageDialog(null, "Paso por el init");
    }
    */

    public void paint(Graphics pintor)
    {
        
        JOptionPane.showMessageDialog(null, "Llegue al paint");
        pintor.drawLine(50, 50, 150, 50);
        pintor.setColor(Color.blue);
        pintor.drawString("Hola mundo", 60, 70);
        Color Colorcito = new Color(100,150,45);
        pintor.setColor(Colorcito);
        pintor.drawLine(50, 80, 150, 80);
        pintor.drawOval(100, 100, 50, 50);
        pintor.drawOval(125, 125, 1, 1);
    }
}
