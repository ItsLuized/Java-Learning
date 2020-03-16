/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nivel1;
import javax.swing.JOptionPane;
/**
 *
 * @author Luized
 */
public class Sumama 
{
    
    public static void main(String[] args) 
    {
        new Sumama();
    }
    
    public Sumama()
    {
        this.todero();
    }
    private void todero()
    {
        float x, y, z;
        x = Float.parseFloat(JOptionPane.showInputDialog("Digite un numero para sumar"));
        y = Float.parseFloat(JOptionPane.showInputDialog("Digite otro numero para sumar"));
        
        z = x + y;
        JOptionPane.showMessageDialog(null, "La suma entre los dos numeros es "+z);
    }
}
