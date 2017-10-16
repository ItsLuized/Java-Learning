package MIT_Lectures_Java;
import javax.swing.*;

public class Methods_II {

    public static double pay(double x, double y){
        double basewage=10;
        double overtimewage = basewage * 1.5;
        double pay=0;
        pay = (x * basewage) + (y * overtimewage);
        return pay;
    }

    public static void main(String[] args){
        double time=0,overtime=0;
        String input;
        boolean validate=false;

        while(validate != true){

            try{
                input=JOptionPane.showInputDialog("Input the amount of hours you worked this week");
                if((input != "" ) && (input.length() > 0)){

                    time=Double.parseDouble(input);

                    if(time > 60){
                        JOptionPane.showMessageDialog(null, "You can't work more than 60 hours a week");
                        validate=false;
                    }

                    else if (time > 40){
                        overtime=time-40;
                        time=time-overtime;
                        validate=true;
                    }

                }else{
                    System.exit(0);
                    validate=true;
                }
                }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Input numbers, not letters");
                validate=false;
            }

        }

        double money= pay(time, overtime);
        JOptionPane.showMessageDialog(null,"If you worked "+(time + overtime)+" hours you would have won "+money+" dollars");
    }
}