package vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import negocio.Circulo;
import negocio.Punto;
import negocio.Cilindro;

/**
 *
 * @author Luis Miguel
 */
public class OpcionesFiguras extends JApplet 
{
    private Circulo circulito;
    private Punto puntico;
    private Cilindro cilindro;
    private int opcion;
    
    public void init() 
    {        
        this.capturaDatos();
    }
    private void capturaDatos()
    {
        int x,y,d1, d2;
        if(this.opcion==1)
        {
            y=Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            x=Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            this.puntico=new Punto(x,y,0,0,0);
        }
        if(this.opcion==2)
        {
            x=Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            y=Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            d1=Integer.parseInt(JOptionPane.showInputDialog("radio: "));        
            this.circulito=new Circulo(x,y,d1,0,0);
        }    
        if (this.opcion == 3)
        {
            x=Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            y=Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            d1=Integer.parseInt(JOptionPane.showInputDialog("radio: ")); 
            d2 = Integer.parseInt(JOptionPane.showInputDialog("Altura: "));
            this.cilindro = new Cilindro(x,y,d1,d2,0);
        }
    }   
    private void dibujador(Graphics pintor)
    {        
        int r,g,b; 
        
        r=(int)(Math.random()*255);
        g=(int)(Math.random()*255);
        b=(int)(Math.random()*255);        
        Color colorcito=new Color(r,g,b);        
        pintor.setColor(colorcito);
        if(this.opcion==1)
        {
            pintor.drawOval(this.puntico.getX(), this.puntico.getY(), 1, 1);
        }
        if(this.opcion==2)
        {
            pintor.drawOval(this.circulito.getX()-this.circulito.getD1(), this.circulito.getY()-this.circulito.getD1(), 2*this.circulito.getD1(), 2*this.circulito.getD1());
            pintor.drawOval(this.circulito.getX(), this.circulito.getY(), 1, 1);
        }
        if (this.opcion == 3) //arreglar!!
        {
            pintor.drawOval(this.cilindro.getX()-this.cilindro.getD1(), this.cilindro.getY()-this.cilindro.getD1(), 2*this.cilindro.getD1(), this.cilindro.getD1()/2);
            pintor.drawLine(this.cilindro.getX() - this.cilindro.getX()/4, this.cilindro.getY() - this.cilindro.getD1()/2, this.cilindro.getX() - this.cilindro.getX()/4, this.cilindro.getY()+this.cilindro.getD2()/2);
            pintor.drawLine(this.cilindro.getX() + this.cilindro.getX()/4, this.cilindro.getY() - this.cilindro.getD1()/2, this.cilindro.getX() + this.cilindro.getX()/4, this.cilindro.getY()+this.cilindro.getD2()/2);
            pintor.drawOval(this.cilindro.getX()-this.cilindro.getD1(), (this.cilindro.getY()-this.cilindro.getD1())+this.cilindro.getD2(), 2*this.cilindro.getD1(), this.cilindro.getD1()/2);
        }
    }
    
    private void verPropiedades()
    {
        int respuesta;
        respuesta = Integer.parseInt(JOptionPane.showInputDialog("Quiere ver las propiedades? \n1.Si \n2.No"));
        if (respuesta == 1) 
        {
            if (this.opcion == 2) 
            {
                JOptionPane.showMessageDialog(null, "El perimetro del circulo es: "+ this.circulito.getPerimetro());
                JOptionPane.showMessageDialog(null, "El area del circulo es: "+ this.circulito.getArea());
            }
            if (this.opcion == 3) 
            {
                JOptionPane.showMessageDialog(null, "El area del cilindro es: " + this.cilindro.getArea());
                JOptionPane.showMessageDialog(null, "El volumen del cilindro es: " + this.cilindro.getVolumen());
            }
        }
    }
        
    public void paint(Graphics pintor)
    {      
        do
        {
            this.opcion=Integer.parseInt(JOptionPane.showInputDialog("===Menú Figuras====\n"+
                                                                     "1. Punto\n"+
                                                                     "2. Círculo\n"+
                                                                     "3. Cilindro\n"+
                                                                     "0. Salir"));
            switch(this.opcion)
            {
                case 1:                    
                    this.capturaDatos();
                    this.dibujador(pintor);
                break;
                case 2:
                    this.capturaDatos();
                    this.dibujador(pintor);
                    this.verPropiedades();
                break;
                case 3 :
                    this.capturaDatos();
                    this.dibujador(pintor);
                    this.verPropiedades();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "CHAO PESCAO..!!!");
                    System.exit(0);
                break;
                default:
                     JOptionPane.showMessageDialog(null, "ESE CASO NO EXISTE..!!!");
                break;
            }
            
        }
        while(this.opcion!=0);
    }
}