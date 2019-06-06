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
        int a,b,r, h;
        if(this.opcion==1)
        {
            a=Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            b=Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            this.puntico=new Punto(a,b);
        }
        if(this.opcion==2)
        {
            a=Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            b=Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            r=Integer.parseInt(JOptionPane.showInputDialog("radio: "));        
            this.circulito=new Circulo(a,b,r);
        }    
        if (this.opcion == 3)
        {
            a=Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            b=Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            r=Integer.parseInt(JOptionPane.showInputDialog("radio: ")); 
            h = Integer.parseInt(JOptionPane.showInputDialog("Altura: "));
            this.cilindro = new Cilindro(a,b,r, h);
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
            pintor.drawOval(this.circulito.getX()-this.circulito.getR(), this.circulito.getY()-this.circulito.getR(), 2*this.circulito.getR(), 2*this.circulito.getR());
            pintor.drawOval(this.circulito.getX(), this.circulito.getY(), 1, 1);
        }
        if (this.opcion == 3) //arreglar!!
        {
            pintor.drawOval(this.cilindro.getX()-this.cilindro.getR(), this.cilindro.getY()-this.cilindro.getR(), 2*this.cilindro.getR(), this.cilindro.getR()/2);
            pintor.drawLine(this.cilindro.getX() - this.cilindro.getX()/4, this.cilindro.getY() - this.cilindro.getR()/2, this.cilindro.getX() - this.cilindro.getX()/4, this.cilindro.getY()+this.cilindro.getH()/2);
            pintor.drawLine(this.cilindro.getX() + this.cilindro.getX()/4, this.cilindro.getY() - this.cilindro.getR()/2, this.cilindro.getX() + this.cilindro.getX()/4, this.cilindro.getY()+this.cilindro.getH()/2);
            pintor.drawOval(this.cilindro.getX()-this.cilindro.getR(), (this.cilindro.getY()-this.cilindro.getR())+this.cilindro.getH(), 2*this.cilindro.getR(), this.cilindro.getR()/2);
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
                                                                     "0. SALIR"));
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