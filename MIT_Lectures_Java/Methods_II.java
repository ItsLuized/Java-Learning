package MIT_Lectures_Java;
import javax.swing.*;

public class Methods_II {
    public static double pay(double x, double y){
        double basewage=15,overtimewage=basewage*1.5,pay=0;
        pay=(x*basewage)+(y*overtimewage);
        System.out.println("If you worked "+x+" hours you would have won "+pay+" dollars");
        return x;
    }
    public static void main(String[] args){
        double time=0,overtime=0;
        String input;
        boolean validate=false;
        while(validate=false){
            try{
                input=JOptionPane.showInputDialog("Input the amount of hours you worked this week");
                if(input!=null || input.length()>0 ){
                    time=Double.parseDouble(input);
                    if(time>60){
                        JOptionPane.showMessageDialog(null, "You can't work more than 60 hours a week");
                        validate=false;
                    }
                    if (time>40 && time<60){
                        overtime=time-40;
                    }
                    validate=true;
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Input numbers, not letters");
                validate=false;
            }
        }
        pay(time, overtime);
    }
}
