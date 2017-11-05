import javax.swing.JOptionPane;

public class Vectoraleatoriedad {
    public static void main(String[]args) {
        String output="";
        char caracter;
        int nfilas = 0, option=0, limite=0, numero=0;
        boolean validation = false;

        while (validation != true) {
            try {
                nfilas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas de caracteres aleatorios que quiere mostrar"));
                if (nfilas < 1) {
                    JOptionPane.showMessageDialog(null, "Escriba un numero mayor a 0");
                    validation=false;
                }
                validation=true;
            }catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null,"Escriba el numeros de filas, no letras.");
                validation=false;
            }
        }validation=false;

            char vector[] = new char[nfilas];
            int numeroporelusuario[] = new int[nfilas];

            while(validation!=true){
                try{
                    option=Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero de la opcion que quiere:\n" +
                            "1.Digitar un numero para el cual se mostraran numeros aleatorios hasta ese numero" +
                            "\n2.Mostrar cualquier caracter aleatoriamente."));
                    if (option>2||option<1){
                        JOptionPane.showMessageDialog(null,"Digite una de las opciones que se le ofrecieron antes.");
                        validation=false;
                    }validation=true;
                }catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(null,"Escriba un numero, no letras.");
                    validation=false;
                }
            }validation=false;

            switch (option){
                case 1:
                    while (validation!=true) {
                        try {
                            limite = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero hasta el cual los numeros aleatorios llegaran"));
                            if (limite < 1) {
                                JOptionPane.showMessageDialog(null, "Digite un numero positivo.");
                                validation = false;
                            }
                            validation = true;
                        } catch (NumberFormatException error) {
                            JOptionPane.showMessageDialog(null, "Escriba un numero, no letras.");
                            validation = false;
                        }
                        for (int i = 0; i < nfilas; i++) {
                             numero= (int)(Math.random() * limite);
                            numeroporelusuario[i] = numero;
                            output = output + numeroporelusuario[i] + "\n";
                        }
                    }
                    break;
                case 2:
                for (int i = 0; i < nfilas; i++) {
                    caracter = (char) (Math.random() * 97 + 33);
                    vector[i] = caracter;
                    output = output + vector[i] + "\n";
                }
                break;
            }
            JOptionPane.showMessageDialog(null, output);
    }
}
