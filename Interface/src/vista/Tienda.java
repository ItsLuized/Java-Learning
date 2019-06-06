package vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import negocio.*;

/**
 *
 * @author Luized
 */
public class Tienda extends JApplet 
{
    private Circulo circulito;
    private Punto puntico;
    private Cilindro cilindro;
    private Cono cono;
    private Esfera esfera;
    private PrismaRectangular prisRec;
    
    private int opcion;
    
    @Override
    public void init() 
    {        
        this.capturaDatos();
    }
    
    @Override
    public void stop()
    {
        JOptionPane.showMessageDialog(null, "Chao", "Cerrando...", 1);
        System.exit(0);
    }
    
    private void capturaDatos()
    {
        int x, y, d1, d2, d3;
        if(this.opcion==1)
        {
            x = Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            y = Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            this.puntico=new Punto(x,y,0,0,0);
        }
        if(this.opcion==2)
        {
            x = Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            y = Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            d1 = Integer.parseInt(JOptionPane.showInputDialog("radio: "));        
            this.circulito=new Circulo(x,y,d1,0,0);
        }    
        if (this.opcion == 3)
        {
            x = Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            y = Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            d1 = Integer.parseInt(JOptionPane.showInputDialog("radio: ")); 
            d2 = Integer.parseInt(JOptionPane.showInputDialog("Altura: "));
            this.cilindro = new Cilindro(x,y,d1,d2,0);
        }
        if (this.opcion == 4) 
        {
            x = Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            y = Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            d1 = Integer.parseInt(JOptionPane.showInputDialog("radio: ")); 
            d2 = Integer.parseInt(JOptionPane.showInputDialog("Altura: "));
            this.cono = new Cono(x, y, d1, d2, 0);
        }
        if (this.opcion == 5) 
        {
            x = Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            y = Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            d1 = Integer.parseInt(JOptionPane.showInputDialog("radio: ")); 
            this.esfera = new Esfera(x, y, d1, 0, 0);
        }
        if (this.opcion == 6) 
        {
            x = Integer.parseInt(JOptionPane.showInputDialog("Coordenada x del centro: "));
            y = Integer.parseInt(JOptionPane.showInputDialog("Coordenada y del centro: "));
            d1 = Integer.parseInt(JOptionPane.showInputDialog("Cuanto tiene de altura: "));
            d2 = Integer.parseInt(JOptionPane.showInputDialog("Cuanto es el largo: "));
            d3 = Integer.parseInt(JOptionPane.showInputDialog("Cuanto es el ancho: "));
            this.prisRec = new PrismaRectangular(x, y, d1, d2, d3);
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
            pintor.drawOval(this.circulito.getX() - this.circulito.getD1(), this.circulito.getY() - this.circulito.getD1(), 2*this.circulito.getD1(), 2*this.circulito.getD1());
            pintor.drawOval(this.circulito.getX(), this.circulito.getY(), 1, 1);
        }
        if (this.opcion == 3)
        {
            pintor.drawOval(this.cilindro.getX() - this.cilindro.getD1(), this.cilindro.getY() - this.cilindro.getD1(), 2*this.cilindro.getD1(), this.cilindro.getD1()/2);
            pintor.drawOval(this.cilindro.getX() - this.cilindro.getD1(), this.cilindro.getY(), 2*this.cilindro.getD1(), this.cilindro.getD1()/2);
            pintor.drawLine(this.cilindro.getX() - this.cilindro.getD1(), this.cilindro.getY() + this.cilindro.getD1()/4, this.cilindro.getX() - this.cilindro.getD1(), this.cilindro.getY() - this.cilindro.getD2()/2);
            pintor.drawLine(this.cilindro.getX() + this.cilindro.getD1(), this.cilindro.getY() + this.cilindro.getD1()/4, this.cilindro.getX() + this.cilindro.getD1(), this.cilindro.getY() - this.cilindro.getD2()/2);            
        }
        if (this.opcion == 4) 
        {
            pintor.drawOval(this.cono.getX() - this.cono.getD1(), this.cono.getY() - this.cono.getD1(), 2*this.cono.getD1(), this.cono.getD1()/2);
            pintor.drawLine(this.cono.getX() - this.cono.getD1(), this.cono.getY() - this.cono.getD2()/2,this.cono.getX() + this.cono.getD1()/16, this.cono.getD2());
            pintor.drawLine(this.cono.getX() + this.cono.getD1(), this.cono.getY() - this.cono.getD2()/2, this.cono.getX() - this.cono.getD1()/16, this.cono.getD2());
        }
        if (this.opcion == 5) 
        {
            pintor.drawOval(this.esfera.getX() - this.esfera.getD1(), this.esfera.getY() - this.esfera.getD1(), 2*this.esfera.getD1(), 2*this.esfera.getD1());
            pintor.drawOval(this.esfera.getX() - this.esfera.getD1(), this.esfera.getY() - this.esfera.getD1()/4, 2*this.esfera.getD1(), this.esfera.getD1()/2);
            pintor.drawOval(this.esfera.getX(), this.esfera.getY(), 1, 1);
        }
        if (this.opcion == 6) 
        {
            pintor.drawRect(this.prisRec.getX() - this.prisRec.getD2(), this.prisRec.getY(), this.prisRec.getD2(), this.prisRec.getD1());
            int posx, posy;
            posx = (this.prisRec.getX() - this.prisRec.getD2()) - this.prisRec.getD3();
            posy = this.prisRec.getY() - this.prisRec.getD3();
            pintor.drawRect(posx, posy, this.prisRec.getD2(), this.prisRec.getD1());
            pintor.drawLine(this.prisRec.getX() - this.prisRec.getD2(), this.prisRec.getY(), (this.prisRec.getX() - this.prisRec.getD2()) - this.prisRec.getD3(), this.prisRec.getY() - this.prisRec.getD3());
            pintor.drawLine(this.prisRec.getX() - this.prisRec.getD2(), this.prisRec.getY() + this.prisRec.getD1(), (this.prisRec.getX() - this.prisRec.getD2()) - this.prisRec.getD3(), (this.prisRec.getY() + this.prisRec.getD1()) - this.prisRec.getD3());
            pintor.drawLine(this.prisRec.getX() , this.prisRec.getY(), this.prisRec.getX() - this.prisRec.getD3() , this.prisRec.getY() - this.prisRec.getD3());
            pintor.drawLine(this.prisRec.getX() , this.prisRec.getY() + this.prisRec.getD1(), this.prisRec.getX() - this.prisRec.getD3() , (this.prisRec.getY() + this.prisRec.getD1()) - this.prisRec.getD3());
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
            if (this.opcion == 4) 
            {
                JOptionPane.showMessageDialog(null, "El area del cono es: " + this.cono.getArea());
                JOptionPane.showMessageDialog(null, "El volumen del cono es: " + this.cono.getVolumen());
            }
            if (this.opcion == 5) 
            {
                JOptionPane.showMessageDialog(null, "El perimetro de la esfera es: " + this.esfera.getPerimetro());
                JOptionPane.showMessageDialog(null, "El area de la esfera es: " + this.esfera.getArea());
                JOptionPane.showMessageDialog(null, " el volumen de la esfera es: " + this.esfera.getVolumen());
            }
            if (this.opcion == 6) 
            {
                JOptionPane.showMessageDialog(null, "El area del prisma rectangualr es: " + this.prisRec.getArea());
                JOptionPane.showMessageDialog(null, "El volumen del prisma rectangular es: " + this.prisRec.getVolumen());
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
                                                                     "4. Cono \n"+
                                                                     "5. Esfera \n"+
                                                                     "6. Prima Rectangular\n"+
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
                case 4:
                    this.capturaDatos();
                    this.dibujador(pintor);
                    this.verPropiedades();
                    break;
                case 5:
                    this.capturaDatos();
                    this.dibujador(pintor);
                    this.verPropiedades();
                    break;
                case 6:
                    this.capturaDatos();
                    this.dibujador(pintor);
                    this.verPropiedades();
                    break;
                case 0:
                    this.stop();
                break;
                default:
                     JOptionPane.showMessageDialog(null, "Ese caso no existe!", "Error", 0);
                break;
            }
        }
        while(this.opcion!=0);
    }
}
