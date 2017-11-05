/*
Author Luis E. Martinez
 */

import javax.swing.JOptionPane;
public class area {
    public static void main (String[] args){
    String fibo="", resprimo="";
    int option, option_general, fibonacci1=0, fibonacci2=1, next=0, limiteprimo;
    float base=0, base2=0, height=0, width=0, radius=0, radius2=0,n=0,areatriangulo, areacuadrado, arearectangulo, arearombo;
    float arearomboide, areatrapecio, areacirculo, areaelipse,areapoligonoreg, basecubo, aristatetraedro,a, nsides=0;
    boolean boolgeneral=false, boolAreageneral=false, boolVolgeneral=false, boolfibo=false, Primo=false, boolpoligono=false;

        JOptionPane.showMessageDialog(null,"Bienvenido!\n ");
        for (int i=0; i<=10; i++) {

            while(boolgeneral!=true) {
                try {
                    option_general = Integer.parseInt(JOptionPane.showInputDialog("Seleccione que quiere sacar de alguna figura geometrica: \n 1.Area \n 2.Volumen \n 3.Serie de Fibonacci \n 4.Numeros Primos" +
                            " \n 5.Juego de Logica \n 6.Salir"));
                    if (option_general<=0|| option_general>6){
                        JOptionPane.showMessageDialog(null,"No se pueden numeros menores a 1 o numeros mayores a 6");
                        boolgeneral=false;
                    }
                    switch (option_general) {

                        //Case 1 es si el usuario quiere el Area de una figura
                        case 1:
                            while (boolAreageneral != true) {
                                try {
                                    option = Integer.parseInt(JOptionPane.showInputDialog("De que figura geometrica quiere encontrar el area?\n(escriba el numero de la opcion que quiere)" +
                                            "\n\n 1: Triangulo \n 2: Cuadrado \n 3: Rectangulo \n 4: Rombo \n 5: Romboide \n 6: Trapecio \n 7: Circulo \n 8: Elipse \n 9: Poligono Regular \n 10: Cubo " +
                                            "\n 11: Tetraedro"));
                                    switch (option) {

                                        //Caso 1 es del Triangulo
                                        case 1:
                                            base = Float.parseFloat(JOptionPane.showInputDialog("Cual es la base del triangulo?"));
                                            height = Float.parseFloat(JOptionPane.showInputDialog("Cual es la altura del triangulo?"));
                                            areatriangulo = (base * height) / 2;
                                            JOptionPane.showMessageDialog(null, "Triangulo:\n Base: " + base + "\n Altura: " + height + "\n Area: " + areatriangulo);
                                            break;
                                        //Caso 2 es el caso del cuadrado
                                        case 2:
                                            base = Float.parseFloat(JOptionPane.showInputDialog("Cual es el tamaño de un lado del cuadrado?"));
                                            areacuadrado = (float) Math.pow(base, 2);
                                            JOptionPane.showMessageDialog(null, "Cuadrado:\n Tamaño de un lado: " + base + "\n Area: " + areacuadrado);
                                            break;
                                        //Caso 3 es el caso del Rectangulo
                                        case 3:
                                            base = Float.parseFloat(JOptionPane.showInputDialog("Cual es la base del rectangulo?"));
                                            height = Float.parseFloat(JOptionPane.showInputDialog("Cual es la altura del rectangulo?"));
                                            arearectangulo = base * height;
                                            JOptionPane.showMessageDialog(null, "Rectangulo:\n Base: " + base + "\n Altura: " + height + "\n Area: " + arearectangulo);
                                            break;
                                        // caso 4 es el caso del Rombo
                                        case 4:
                                            height = Float.parseFloat(JOptionPane.showInputDialog("Cual es la altura del rombo?"));
                                            width = Float.parseFloat(JOptionPane.showInputDialog("Cual es el ancho del rombo?"));
                                            arearombo = (height * width) / 2;
                                            JOptionPane.showMessageDialog(null, "Rombo: \n Altura: " + height + "\n Ancho: " + width + "\n Area: " + arearombo);
                                            break;
                                        //Caso 5 es el caso del Romboide
                                        case 5:
                                            base = Float.parseFloat(JOptionPane.showInputDialog("Cual es la base del romboide?"));
                                            height = Float.parseFloat(JOptionPane.showInputDialog("Cual es la altura del romboide?"));
                                            arearomboide = base * height;
                                            JOptionPane.showMessageDialog(null, "Romboide: \n Base: " + base + "\n Altura: " + height + "\n Area: " + arearomboide);
                                            break;
                                        //Caso 6 es el caso del Trapecio
                                        case 6:
                                            base = Float.parseFloat(JOptionPane.showInputDialog("Cual es la base mas larga?"));
                                            base2 = Float.parseFloat(JOptionPane.showInputDialog("Cual es la otra base?"));
                                            height = Float.parseFloat(JOptionPane.showInputDialog("Cual es la altura?"));
                                            areatrapecio = ((base * base2) * height) / 2;
                                            JOptionPane.showMessageDialog(null, "Trapecio: \n Base 1: " + base + "\n Base 2: " + base2 + "\n Altura: " + height + "\n Area: " + areatrapecio);
                                            break;
                                        //Caso 7 es el caso del Circulo
                                        case 7:
                                            radius = Float.parseFloat(JOptionPane.showInputDialog("Cual es el radio del circulo?"));
                                            areacirculo = (float) (Math.PI * Math.pow(radius, 2));
                                            JOptionPane.showMessageDialog(null, "Circulo: \n Radio: " + radius + "\n Area: " + areacirculo);
                                            break;
                                        //Caso 8 es el caso de la Elipse
                                        case 8:
                                            radius = Float.parseFloat(JOptionPane.showInputDialog("Cual es el Radio en el exe Y? "));
                                            radius2 = Float.parseFloat(JOptionPane.showInputDialog("Cual es el Radio en el exe X?"));
                                            areaelipse = (float) Math.PI * radius * radius2;
                                            JOptionPane.showMessageDialog(null, "Elipse: \n Radio 1: " + radius + "\n Radio 2: " + radius2 + "\n Area: " + areaelipse);
                                            break;
                                        //Caso 9 es el caso del Poligono Regular
                                        case 9:
                                            while(boolpoligono!=true){
                                                try {
                                                    nsides = Float.parseFloat(JOptionPane.showInputDialog("Cuantos lados tiene el poligono?"));
                                                    if(nsides<2){
                                                        JOptionPane.showMessageDialog(null, "No se puede numeros menores a 2");
                                                        boolpoligono=false;
                                                    }else boolpoligono=true;
                                                }catch(NumberFormatException error){
                                                    JOptionPane.showMessageDialog(null, "Error: Digite numeros, no letras por favor.");
                                                    boolpoligono=false;
                                                }
                                            }
                                            boolpoligono=true;
                                            base = Float.parseFloat(JOptionPane.showInputDialog("Cuanto mide un lado?\n(todos los lados son iguales en los poligonos regulares)"));
                                            float apotema = Float.parseFloat(JOptionPane.showInputDialog("Cuanto mide el apotema?\n(distancia del centro del poligono al punto medio de un lado)"));
                                            areapoligonoreg = (base * nsides * apotema) / 2;
                                            JOptionPane.showMessageDialog(null, "Poligono Regular: \n Numero de Lados: " + nsides + "\n Tamaño de Lado: " + base + "\n Apotema: " + apotema +
                                                    "\n Area: " + areapoligonoreg);
                                            break;
                                        //Caso 10 es el caso del Cubo
                                        case 10:
                                            basecubo = Float.parseFloat(JOptionPane.showInputDialog("Digite la longitud de un lado del cubo"));
                                            float areacubo = 6 * (float) Math.pow(basecubo, 2);
                                            JOptionPane.showMessageDialog(null, "Cubo: \n Longitud de un lado: " + basecubo + "\n Area: " + areacubo);
                                            break;
                                        //Caso 11 es el caso del tetraedro
                                        case 11:
                                            aristatetraedro = Float.parseFloat(JOptionPane.showInputDialog("Digite la longitud de una arista"));
                                            float areatetraedro = (float) (Math.sqrt(3) * Math.pow(aristatetraedro, 2));
                                            JOptionPane.showMessageDialog(null, "Tetraedro: \n Arista: " + aristatetraedro + "\n Area: " + areatetraedro);
                                            break;
                                            }
                                    boolAreageneral=true;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error: Digite numeros, no letras por favor.");
                                    boolAreageneral=false;
                                }
                            }boolAreageneral=false;
                            break;
                            //El caso 2 es el si el usuario quiere el Volumen de la figura
                        case 2:
                            while(boolVolgeneral!=true) {
                                try {
                                    option = Integer.parseInt(JOptionPane.showInputDialog("De que figura geometrica quiere encontrar el volumen?\n(escriba el numero de la opcion que quiere)" +
                                            "\n\n 1: Cubo \n 2: Tetraedro \n 3: Octaedro \n 4: Dodecaedro \n 5: Icosaedro \n 6: Prisma \n 7: Ortoedro \n 8: Piramide \n 9: Cilindro  \n 10: Cono" +
                                            "\n 11: Esfera"));
                                    switch (option) {
                                        //Caso 1 es el caso del Cubo
                                        case 1:
                                            basecubo = Float.parseFloat(JOptionPane.showInputDialog("Digite la longitud de un lado del Cubo"));
                                            float volumencubo = (float) Math.pow(basecubo, 3);
                                            JOptionPane.showMessageDialog(null, "Cubo: \n Longitud de un lado: " + basecubo + "\n Volumen: " + volumencubo);
                                            break;
                                        //Caso 2 es el del Tetraedro
                                        case 2:
                                            aristatetraedro = Float.parseFloat(JOptionPane.showInputDialog("Digite la longitud de una arista"));
                                            float volumentetraedro = (float) (Math.sqrt(2) * Math.pow(aristatetraedro, 3)) / 12;
                                            JOptionPane.showMessageDialog(null, "Tetraedro: \n Longitud de la arista: " + aristatetraedro + "\n Volumen: " + volumentetraedro);
                                            break;
                                        //Caso 3 es el caso del Octaedro
                                        case 3:
                                            a = Float.parseFloat(JOptionPane.showInputDialog("Digite el valor de una arista del Octaedro"));
                                            float volumenoctaedro = (float) (Math.sqrt(2) * Math.pow(a, 3)) / 3;
                                            JOptionPane.showMessageDialog(null, "Octaedro: \n Arista: " + a + "\n Volumen: " + volumenoctaedro);
                                            break;
                                        //Caso 4 es el caso del Dodecaedro
                                        case 4:
                                            a = Float.parseFloat(JOptionPane.showInputDialog("Digite el valor de una arista del Dodecaedro"));
                                            float volumendodecaedro = (float) (1 / 4 * (15 + (7 * Math.sqrt(5))) * Math.pow(a, 3));
                                            JOptionPane.showMessageDialog(null, "Dodecaedro: \n Arista: " + a + "\n Volumen: " + volumendodecaedro);
                                            break;
                                        //Caso 5 es el caso del Icosaedro
                                        case 5:
                                            a = Float.parseFloat(JOptionPane.showInputDialog("Digite el valor de una arista del Icosaedro"));
                                            float volumenIcosaedro = (float) (5 / 12 * (3 + (Math.sqrt(5))) * Math.pow(a, 3));
                                            JOptionPane.showMessageDialog(null, "Icosaedro: \n Arista: " + a + " \n Volumen: " + volumenIcosaedro);
                                            break;
                                        //Caso 6 es el caso del Prisma
                                        case 6:
                                            float areabase;
                                            areabase = Float.parseFloat(JOptionPane.showInputDialog("Digite el area de la base del Prisma"));
                                            height = Float.parseFloat(JOptionPane.showInputDialog("Digite la altura del Prisma"));
                                            float volumenPrisma = areabase * height;
                                            JOptionPane.showMessageDialog(null, "Prisma: \n Area de la base: " + areabase + "\n Altura: " + height + "\nVolumen: " + volumenPrisma);
                                            break;
                                        //Caso 7 es el caso del Ortoedro
                                        case 7:
                                            float b, c;
                                            a = Float.parseFloat(JOptionPane.showInputDialog("Digite el alto del Ortoedro"));
                                            b = Float.parseFloat(JOptionPane.showInputDialog("Digite el ancho del Ortoedro"));
                                            c = Float.parseFloat(JOptionPane.showInputDialog("Digite el largo del Ortoedro"));
                                            float volumenOrtoedro = a * b * c;
                                            JOptionPane.showMessageDialog(null, "Ortoedro: \n Alto: " + a + "\n Ancho: " + b + "\n Largo: " + c + "\n Volumen: " + volumenOrtoedro);
                                            break;
                                        //Caso 8 es el caso del Piramide
                                        case 8:
                                            areabase = Float.parseFloat(JOptionPane.showInputDialog("Digite el area de la base de la Piramide"));
                                            height = Float.parseFloat(JOptionPane.showInputDialog("Digite la altura de la Piramide"));
                                            float volumenPiramide = (areabase * height) / 3;
                                            JOptionPane.showMessageDialog(null, "Piramide \n Area de la base: " + areabase + "\n Alto: " + height + "\n Volumen: " + volumenPiramide);
                                            break;
                                        //Caso 9 es el caso del Cilindro
                                        case 9:
                                            radius = Float.parseFloat(JOptionPane.showInputDialog("Digite el radio del Cilindro"));
                                            height = Float.parseFloat(JOptionPane.showInputDialog("Digite la altura del Cilindro"));
                                            float volumenCilindro = (float) (Math.PI * Math.pow(radius, 2) * height);
                                            JOptionPane.showMessageDialog(null, "Cilindro: \n Radio: " + radius + "\n Altura: " + height + "\n Volumen: " + volumenCilindro);
                                            break;
                                        //Caso 10 es el caso del Cono
                                        case 10:
                                            radius = Float.parseFloat(JOptionPane.showInputDialog("Digite el radio del Cono"));
                                            height = Float.parseFloat(JOptionPane.showInputDialog("Digite la altura del Cono"));
                                            float volumenCono = (float) (Math.PI * Math.pow(radius, 2) * height) / 3;
                                            JOptionPane.showMessageDialog(null, "Cono: \n Radio: " + radius + "\n Altura: " + height + "\n Volumen: " + volumenCono);
                                            break;
                                        //Caso 11 es el caso del Esfera
                                        case 11:
                                            radius = Float.parseFloat(JOptionPane.showInputDialog("Digite el radio de la Esfera"));
                                            float volumenEsfera = (float) (4 * Math.PI * Math.pow(radius, 3)) / 3;
                                            JOptionPane.showMessageDialog(null, "Esfera: \n Radio: " + radius + "\n Volumen: " + volumenEsfera);
                                            break;

                                    } boolVolgeneral=true;
                                }catch(NumberFormatException e){
                                    JOptionPane.showMessageDialog(null,"Error: Digite numeros, no letras por favor.");
                                    boolVolgeneral=false;
                                }
                            }boolVolgeneral=false;
                            break;

                        //Caso 3 de opcion general es el caso de la serie de Fibonacci

                        case 3:
                            while (boolfibo!=true) {
                                try {
                                    int limfibo= Integer.parseInt(JOptionPane.showInputDialog("Digite un numero hasta el que la serie de fibonacci llegara"));

                                    JOptionPane.showMessageDialog(null,"Mostrando los primeros "+limfibo+" numeros de la serie de Fibonacci \n");
                                    for(int x=0;x<=limfibo;x++)
                                    {


                                        if(x<=1)
                                            next=x;
                                        else
                                        {
                                            next = fibonacci1 + fibonacci2;
                                            fibonacci1 = fibonacci2;
                                            fibonacci2= next;
                                        }
                                        fibo=fibo+next+", ";
                                    }

                                    boolfibo=true;
                                    JOptionPane.showMessageDialog(null, fibo);
                                } catch (NumberFormatException fibonacci) {
                                    JOptionPane.showMessageDialog(null, "Error: Digite numeros, no letras por favor.");
                                }
                           }fibo="";
                            next=0;
                            fibonacci1=0;
                            fibonacci2=1;
                           boolfibo=false;
                            break;

                            //Caso de los numeros primos

                        case 4:
                            while (Primo != true) {
                                try {
                                    limiteprimo = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero hasta el cual llegaran los numeros primos"));
                                    for (int numero = 1; numero <= limiteprimo; numero++) {
                                        int divisor = 0;
                                        for (int j = 1; j <= numero; j++) {
                                            if (numero % j == 0) {
                                                divisor++;
                                            }
                                        }
                                        if (divisor == 2) {
                                            resprimo = resprimo + numero + "\n";
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, "Primeros"+limiteprimo+" Numeros Primos: \n1\n" + resprimo);
                                    Primo = true;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Digite numeros, no letras Por favor");
                                    Primo=false;
                                }
                            }resprimo="";
                            Primo=false;
                            break;
                        case 5:
                            boolean booljuego=false;
                            while (booljuego!=true){
                                try {

                                    int eleccion=Integer.parseInt(JOptionPane.showInputDialog("El numero 325 es un numero peculiar \nYa que la suma de su primer digito con el segundo da el tercero \n\n  325---> 3+2=5 \n\n"
                                    +"Cuantos numeros de tres digitos cumplen esta propiedad?"));

                                    if(eleccion!=45){
                                        JOptionPane.showMessageDialog(null, "Sigue intentando!");
                                        booljuego=false;
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Felicitaciones, acertaste!");
                                        booljuego=true;
                                    }

                                }catch(NumberFormatException e){
                                    JOptionPane.showMessageDialog(null, "Digite numeros, no letras Por favor");
                                    booljuego=false;
                                }
                            }booljuego=false;
                            break;
                        case 6:
                            JOptionPane.showMessageDialog(null, "Adios!");
                            System.exit(0);
                            boolgeneral=true;
                            break;
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Digite numeros, no letras por favor.");
                    boolgeneral=false;
                }
            }
        }
    }
}