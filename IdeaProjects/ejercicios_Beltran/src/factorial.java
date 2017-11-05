import javax.swing.JOptionPane;
public class factorial {
    public static void main(String[] args) {
        int n,multi=1;
        n=Integer.parseInt(JOptionPane.showInputDialog("Escriba un numero entero positivo al cual calcularle el factorial"));
        for (int i=1; i<=n; i++){
            multi=multi*i;
        }
        JOptionPane.showMessageDialog(null,"el calculo del factorial de "+n+" es \n"+multi);
    }
}
