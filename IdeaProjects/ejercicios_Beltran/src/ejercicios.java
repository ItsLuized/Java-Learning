import javax.swing.*;

public class ejercicios{
    public static void main(String[] args) {
        int a, b,sum=0;
        String data="", sumafinal="";
        a = Integer.parseInt(JOptionPane.showInputDialog("Digite un valor para a"));
        b=Integer.parseInt(JOptionPane.showInputDialog("Digite un valor para b (que sea mayor que a)"));

        for (int i=a;  i <=b; i++){
          int calculo= (int) Math.pow(i,2);
          sum=sum+calculo;
        }
        JOptionPane.showMessageDialog(null,"La suma de los numeros entre el intervalo ("+a+", "+b+")\n es:  "+sum);

    }
}