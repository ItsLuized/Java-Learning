import javax.swing.JOptionPane;
public class AppMultifuncional {

    /**
     * @param message
     * @return Muestra el mensaje "message" con la opcion para ingresar algun dato.
     */
    public static String InputMessage(String message){
        return JOptionPane.showInputDialog(message);
    }

    /**
     * Funcion para mostrar mensaje.
     * @param message Recibe un mensaje el cual va a mostrar.
     */
    public static void  ShowMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Funcion para generar un dia aleatorio.
     * @return Devuelve el dia aleatorio para alojarlo en otra variable.
     */
    public static int Dia(){
        int x = (int) (Math.random()*29)+1;
        return x;
    }

    public static void main(String[] args){
        int saldo = 5000000;
        int sueldo = 7000000;
        int edad = 0;
        int genero = 0;
        int option = 0;
        int opcionretirar;
        int retirospordia = 3;
        int retirar = 0;
        int dia = 0;
        int test = 0;
        int days  = 0;
        int niños = 0;
        int personas = 0;
        int estrellas = 0;
        int Tickets = 0;
        int confirmar = 0;
        int preguntaniños = 0;
        int [] baloto = new int [5];
        int [] userInput = new int [5];
        int aciertos = 0;
        float estadia = 0;
        float estadianiño = 0;
        float peso = 0;
        long inicio = 1500000;
        boolean validate = false;
        boolean validar2 = false;
        boolean validar = false;
        String nombre = "";
        String opcion;
        String Input;
        String destino = "";




        /*
         *Pedir el nombre y apellido
         *Y asegurarme que si escriba algo, y que no sean numeros.
         */
        while(validate != true){

            try{
                nombre=InputMessage("Digite su nombre y apellido");
                Integer.parseInt(nombre);
                ShowMessage("Digite su nombre, no numeros");
                validate = false;
            }catch(Exception error){
                if ( nombre.isEmpty() ){
                    ShowMessage("Digite su nombre, por favor.");
                    validate = false;
                }
                else validate = true;
            }
        }validate=false;

        /*
         *Pedir la edad al usuario
         * Y asegurarme que no deje el espacio libre.
         */
        while(validate != true){

            try{
                Input=InputMessage("Cual es su edad?");
                if ( !Input.isEmpty() ){

                    edad=Integer.parseInt(Input);

                    if ((edad < 0) || (edad > 100)){
                    ShowMessage("Digite una edad real, por favor.");
                    validate = false;
                    }
                    else validate = true;
                }

            }catch(Exception error){
                ShowMessage("Digite su nombre, no numeros por favor.");
                validate = false;
            }
        }validate = false;

        /*
         *Pedir el genero de la persona
         */
        while(validar != true){
            try{
                genero = Integer.parseInt(InputMessage("Digite: \n" +
                                                        "1.Si es Mujer. \n" +
                                                        "2.Si es Hombre."));
                if ((genero < 1) || (genero >2)){
                    ShowMessage("Lo que digito no es una opcion.");
                }
                else {
                    validar = true;
                }
            }catch(Exception e){
                ShowMessage("Digite el numero de la opcion.");
                validar = false;
            }
        }validar = false;

        //loop para que esto se repita hasta que el usuario elija salir.
        do {



        /*
         *Aqui pedire al usuario que opcion quiere acceder
         * Asegurandome que no deje el espacio en blanco
         * Ni que escriba decimales o letras.
         */
            while (validate != true) {
                dia=Dia();
                if (dia >= 25){
                    ShowMessage("Se le ha depositado su sueldo.");
                    saldo+=sueldo;
                }
                try {
                    opcion = InputMessage("                                " +
                            "                    Dia:" + dia + "\n\n" +
                            "A que funcion quiere acceder? \n" +
                            "1. BancoVirtual \n" +
                            "2. Despegar.com \n" +
                            "3. Baloto \n" +
                            "0. Salir");

                    if ( !opcion.isEmpty() ){

                        option = Integer.parseInt(opcion);
                        if (option < 0 || option > 4) {
                            ShowMessage("Seleccione una de las opciones anteriores");
                            validate = false;
                        } else
                            validate = true;
                    }
                } catch ( Exception error ) {
                    ShowMessage("Ingrese el numero de la opcion que quiere, no letras ni decimales.");
                    validate = false;
                }
            }validate = false;

            switch(option){

                /*
                 *Caso 1 es el caso en donde se permite retirar dinero
                 * siempre y cuando lo tenga disponible.
                 * O ver cuanto tiene de Saldo Disponible
                 */
                case 1:

                    while ((validate != true) && (retirospordia >0)){
                        try {

                            Input = InputMessage("Que quiere hacer?\n" +
                                    "1.Retirar dinero \n" +
                                    "2. Consultar saldo\n" +
                                    "0.Salir");

                            if (!Input.isEmpty()) {
                                opcionretirar = Integer.parseInt(Input);

                                switch (opcionretirar) {
                                    case 1:
                                        if (edad < 18) {
                                            ShowMessage("Al ser menor de edad no puede retirar, Lo sentimos.");
                                            validate = true;
                                        } else {
                                            while (validar2 != true) {
                                                try {
                                                    Input = InputMessage("Cuanto dinero quiere retirar?\n" +
                                                            " El minimo monto para retirar es 10000 y el maximo 1'000000\n");
                                                    if (!Input.isEmpty()) {
                                                        retirar = Integer.parseInt(Input);
                                                        if ((retirar >= 10000) && (retirar <= 1000000)) {

                                                            if (retirar % 10000 == 0) {
                                                                if (saldo >= retirar) {
                                                                    saldo -= retirar;
                                                                    validar2 = true;
                                                                } else {
                                                                    ShowMessage("Sr. " + nombre + " No tiene ese dinero para retirar");
                                                                    validar2 = true;
                                                                }
                                                            } else {
                                                                validar2 = false;
                                                            }
                                                        }else {
                                                            ShowMessage("No puede retirar menos de 10 mil ni mas de 1 Millon");
                                                            validar2 = false;
                                                        }
                                                    }
                                                }catch (Exception error) {
                                                    ShowMessage("Introduzca el monto de dinero que quiere retirar.");
                                                    validar2 = false;
                                                }
                                            }
                                            validar2 = false;
                                            retirospordia--;
                                        }
                                        break;
                                    case 2:
                                        ShowMessage("Saldo Disponible: " + saldo);
                                        break;
                                    case 0:
                                        validate = true;
                                        break;

                                }


                            }else {
                                ShowMessage("Digite una opcion!");
                                validate = false;
                            }

                        } catch (Exception error) {
                            ShowMessage("Escriba el numero de la opcion, no letras.");
                            validate = false;
                        }
                    }validate = false;
                    retirospordia=3;

                    break;

                /*
                 *Caso 2 es el caso de Despegar.com
                 *
                 */
                case 2:

                    //Se pregunta si el destino es Nacional o Internacional
                    while(validar != true){
                        try {
                            destino=InputMessage("Su destino es Nacional o Internacional?");
                            test=Integer.parseInt(destino);
                            ShowMessage( "Digite una opcion valida");
                            validar = false;
                        } catch (Exception e) {

                            if (destino.equals("Nacional")) {
                                inicio += (inicio*0.02f);
                                validar = true;
                            }
                            else if(destino.equals("Internacional")){
                                inicio += (inicio*0.05f);
                                validar = true;
                            }
                            else{
                                validar = false;
                            }
                        }
                    }validar=false;


                    /*
                     *Se preguntaran cuantas personas mayores de 8 años van a viajar
                     */
                    while(validar != true){
                        try{
                            personas = Integer.parseInt(InputMessage("Cuantas personas mayores de 8 años van a viajar?"));
                            if (personas < 1){
                                ShowMessage("Tiene que viajar almenos una persona.");
                                validar = false;
                            }
                            else{
                            validar = true;
                            }
                        }catch(Exception e){
                        ShowMessage("Digite el numero de personas mayores de 8 años van a viajar");
                        validar = false;
                        }
                    }validar = false;


                    /*
                     *Se pregunta si van niños menores de 8 años, si van se preguntan cuantos
                     * si no va ningun niño menor de 8 se pasa a la proxima pregunta.
                     */
                    while(validate != true){
                        try{
                            preguntaniños = Integer.parseInt(InputMessage("Van niños?: \n1.Si \n2.No"));

                            if (preguntaniños == 1){
                                while(validar2 != true){
                                    try{
                                        niños = Integer.parseInt(InputMessage("Cuantos niños van?"));
                                        if (niños < 1) {
                                            ShowMessage("Tiene que ir almenos un niños, ya que dijo que si iba alguno.");
                                            validar2 = false;
                                        }
                                        else{
                                            validar2 = true;
                                        }

                                    }catch (Exception error){
                                        ShowMessage("Digite el numero de niños que van.");
                                        validar2 = false;
                                    }
                                }validar2 = false;
                                validate = true;
                            }
                            else if(preguntaniños == 2){
                                niños = 0;
                                validate = true;
                            }
                            else{
                                ShowMessage("Digite una opcion valida.");
                                validate = false;
                            }
                        }catch(Exception e){
                        ShowMessage("Digite el numero de la opcion.");
                        validate = false;
                        }
                    }validate = false;

                    /*
                     *Si la suma de niños + las personas mayores de 8 es mas de 5
                     * se reduce 300000 para destino nacional
                     * se reduce 400000 para destino internacional
                     */
                    if (personas + niños > 5){

                        if (destino.equals("Nacional")) {
                            inicio -= 300000;
                        }
                        else if(destino.equals("Internacional")){
                            inicio -= 400000;
                        }
                    }

                    /*
                     *Se le pregunta el numero de dias que se quedara en su destino
                     * para calcula cuanto es el valor de la estadia
                     * estadia = dias*250000 *personas
                     * estadianiño = ((days*250000)*niños)*0.5f
                     */
                    while(validar != true){
                        try {
                            days=Integer.parseInt(JOptionPane.showInputDialog("Cuantos dias se quedara en su destino?"));
                            if (days < 0){
                                ShowMessage("No se puede quedar menos de un dia.");
                                validar = false;
                            }
                            else{
                            validar=true;
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,"Digite el numero de dias.");
                            validar = false;
                        }
                    }validar = false;
                        estadia = ((days*250000)*personas);
                        estadianiño = ((days*250000)*niños)*0.5f;

                    /*
                     *Se le pregunta el peso total de las maletas
                     * Si es superior o igual a 12.5kg se le aumenta 200000
                     */
                    while(validar != true){
                        try{
                            peso = Float.parseFloat(InputMessage("Cuanto pesan todas las maletas en total?"));
                            validar = true;
                        }catch(Exception e){
                            ShowMessage("Digite el peso total de las maletas");
                            validar = false;
                        }
                    }validar = false;

                    if (peso > 12.5){
                        inicio += 200000;
                    }

                    /*
                     *Se le preguntara de cuantas estrellas quiere que sea el Hotel en el que se hospedaran
                     * Si estrellas >3 --> inicio += 500000
                     */
                    while(validar != true){
                        try{
                            estrellas = Integer.parseInt(InputMessage("Cuantas estrellas quiere que tenga el Hotel en el que se hospedaran?"));
                            if ((estrellas < 1) || (estrellas > 5)){
                                ShowMessage("El hotel no puede tener mas de 5 estrellas ni menos de 1");
                                validar =false;
                            }
                            else if(estrellas >= 3){
                                inicio += 500000;
                                validar = true;
                            }
                            else{
                                validar = true;
                            }
                        }catch(Exception e){
                        ShowMessage("Digite el nuemero de estrellas del hotel en el que se quiere hospedar");
                        validar = false;
                        }
                    }validar = false;

                    /*
                     *Si el genero es igual a 1 significa que es una mujer
                     * por lo que se suman 100000 al total.
                     * si el genero es igual a 2 es un hombre
                     * por lo que se le suma 200000 al total.
                     */
                    if (genero == 1){
                        inicio += 100000;
                    }
                    else{
                        inicio += 200000;
                    }
                    inicio += estadia + estadianiño;
                    Tickets = personas + niños;

                    /*
                     *Mostrar todos los datos
                     * y luego le preguntar al usuario si quiere adquerir los Tickets de Viaje.
                     */
                    while(validar != true){
                        ShowMessage("Despegar.com \n" +
                                    "Nombre: "+ nombre + "\n" +
                                    "Edad: " +edad + "\n" +
                                    "Precio Inicial: 1500000" + "\n" +
                                    "Destino: "+ destino + "\n" +
                                    "Dias: " + days + "\n" +
                                    "Tickets: " + Tickets + "\n" +
                                    "Peso total de las maletas: " + peso + "\n" +
                                    "Numero de niños: " + niños + "\n" +
                                    "Precio de estadia: " + estadia + "\n" +
                                    "Precio estadia de niños: " + estadianiño +"\n"+
                                    "Estrellas del Hotel: " + estrellas + "\n" +
                                    "Total:  " + inicio + "\n" +
                                    "Saldo: " + saldo );

                        try{
                            confirmar = Integer.parseInt(InputMessage("Digite:\n" +
                                                                        "1. Comprar \n" +
                                                                        "2.Cancelar"));
                            if ((confirmar <1) || (confirmar >2)){
                                ShowMessage("Digite una opcion valida.");
                                validar = false;
                            }
                            else if (confirmar == 1){
                                if (saldo >= inicio){
                                saldo -= inicio;
                                validar = true;
                                }else{
                                    ShowMessage("Sr. " + nombre + ", No tiene el saldo suficiente para hacer esta compra.");
                                    validar = true;
                                }
                            }
                            else{
                                validar = true;
                            }
                        }catch(Exception e){
                            ShowMessage("Digite el numero de la opcion que quiere.");
                            validar = false;
                        }
                    }validar = false;
                    inicio = 1500000;

                    break;

                    /*
                     *Caso de el baloto
                     * el usuario digita 5 numeros y se checkea si acerto alguno
                     * si acieta 5/5 se le depositan 10 millones
                     * si acierta 4/5 se le depositan 5 millones
                     * si acierta 3/5 se le devuelve el dinero que pago
                     */
                case 3:

                    while(validate != true){
                        try{
                            confirmar = Integer.parseInt(InputMessage("Quiere comprar el baloto por 10000?\n" +
                                                                        "1.Confirmar.\n" +
                                                                        "2. Cancelar"));
                            if ((confirmar <1) || (confirmar >2)){
                                ShowMessage("Digite una opcion valida.");
                            }
                            else{
                                validate = true;
                            }
                        }catch(Exception e){
                        ShowMessage("Digite el numero de la opcion que desea.");
                        validate = false;
                        }
                    }validate = false;

                        System.out.println("Numeros del Baloto: ");
                        if (confirmar == 1) {
                            for (int i = 0; i < baloto.length; i++) {
                                baloto[i] = (int) (Math.random() * 44) + 1;
                                System.out.println((i+1) + ". " + Integer.toString(baloto[i]));
                            }
                            System.out.println("--------------------------------------------------------");


                            for (int i =0; i < userInput.length; i++){
                                while(validate != true) {
                                    try {
                                        userInput[i] = Integer.parseInt(InputMessage("Digite un numero entre 1 y 45, que desea que sea su n° "+(i+1)));
                                        if ((userInput[i] < 1) || (userInput[i] > 45)){
                                            ShowMessage("El numero debe ser entre 1 y 45");
                                        }
                                        else{
                                            System.out.println(userInput[i]);
                                            validate = true;
                                        }
                                    }catch(Exception e){
                                        ShowMessage("Digite un numero entre 1 y 45");
                                        validate = false;
                                    }
                                }validate = false;
                            }

                            for (int i = 0; i < baloto.length; i++){
                                if (baloto[i] == userInput[i]){
                                    aciertos ++;
                                }
                            }


                            if (aciertos == 5) {
                                ShowMessage("     FELICITACIONES! Se gano el Baloto.\n" +
                                        "Le hemos depositado los 10 millones de premio. ");
                                saldo += 10000000;
                            } else if (aciertos == 4) {
                                ShowMessage("          Acerto 4 de los 5 numeros!\n" +
                                        "Le hemos depositado 5 millones de premio\n" +
                                        "  Por haber acertado 4 de los 5 numeros.");
                            } else if (aciertos == 3) {
                                ShowMessage("         Acerto 3 de 5 numeros!\n" +
                                        "Le hemos devuelto lo que pago por el baloto.");
                            } else {
                                ShowMessage("Siga Intentando.");
                            }
                        }
                        else {

                        }

                    break;

                case 0:
                    ShowMessage("Adios!");
                    break;

            }
        }while(option != 0);
    }
}
