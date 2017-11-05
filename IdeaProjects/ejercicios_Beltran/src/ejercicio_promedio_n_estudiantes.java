import javax.swing.JOptionPane;

public class ejercicio_promedio_n_estudiantes {
    public static void main(String[] args) {
        int n;
        float nota=0,promedio=0;
        n=Integer.parseInt(JOptionPane.showInputDialog("Cuantos estudiantes son?"));
        for (int i=1; i<=n; i++){
            nota=Float.parseFloat(JOptionPane.showInputDialog("Digite la nota del estudiante "+i+"\n(la nota tiene como un resultado maximo 5)"));
            promedio=promedio+nota;
        }
        promedio=promedio/n;
        JOptionPane.showMessageDialog(null,promedio);
    }
}
