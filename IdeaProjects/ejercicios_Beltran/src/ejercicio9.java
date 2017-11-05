import javax.swing.JOptionPane;

public class ejercicio9 {
    public static void main(String[] args) {
        int n;
        float sum=0, sumtotal=0;
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor para n"));
        for (int i=1; i<=n; i++){
            sum=sum+ (24/(float)Math.pow(i,2));
        }
        sum=(float)Math.sqrt(sum);
        sum=sum*1/2;
        JOptionPane.showMessageDialog(null,"El valor aproximado para Pi cuando n es "+n+" es : "+sum);
    }

}
