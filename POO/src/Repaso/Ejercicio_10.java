package Repaso;
import javax.swing.JOptionPane;

public class Ejercicio_10 
{  
    //1. Atributos o variables de clases
   
    //2. Métodos
   
    public static void main(String[] args)
    {
   
        new Ejercicio_10();
       
    }
    
    public static void Print(String mensaje)
    {
    
        System.out.println(mensaje);
        
    }
   
    public Ejercicio_10()
    {
   
        this.proceso();
       
    }
   
    private void proceso()
    {
        
        boolean validar = false, primo = false;
        int numero = 0, divisor = 0, factorial = 1, resultado = 0, siguiente = 0, fibonacci1 = 0, fibonacci2 = 1;
        String output = "";
        
        while(validar != true)
        {
            
            try
            {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero."));
                validar = true;
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Ingrese un numero, no letras.");
                validar = false;
            }
        }
       
        for (int i = 1; i <= numero; i++) 
        {
            if (numero % i == 0) 
            {
                divisor++;
            }
        }
        
        if (divisor == 2) 
        {
            primo = true;
        }
        
        if(primo == true)
        {
        
            for (int i = 1; i <= numero; i++) {
                
                
                factorial *= i;
                if(i == 1)
                {
                    output += i;
                }else
                {
                output += " * " + i;
                }
            }
            Print(output + " = " + factorial);
            
        }else
        {
            if (numero % 2 == 0) 
            {
                
            
        
                for (int i = 1; i < numero; i += 2) 
                {
                    if (numero % i == 0) 
                    {
                    
                        resultado += i;
                        if (i > 1) 
                        {
                        
                            output += " + " + i ;
                      
                        }else
                        {
                    
                            output += i;
                        
                        }
                    }
                }
                
                Print(output + " = " + resultado);
            }else 
            {
            
                for (int i = 0; i < numero; i++) {
                    
                    if (i <= 1) 
                    {
                        siguiente = i;
                    }else
                    {
                    siguiente = fibonacci1 + fibonacci2;
                    fibonacci1 = fibonacci2;
                    fibonacci2= siguiente;
                    }
                    
                    if (i > 1) 
                    {
                    
                    output += " + " + siguiente;
                    
                    }else if(i > 0)
                    {
                        output += " + " +siguiente;
                    }else
                    {
                    output += siguiente;                        
                    }
                    
                    resultado += siguiente;
                }
                
                Print(output + " = "+ resultado);
                
            }
        }
    }
   
}

