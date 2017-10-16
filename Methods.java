package MIT_Lectures_Java;
/*
 *Author:Luis Martinez
 * Date: 13/10/17
 */
import javax.swing.JOptionPane;
public class Methods {

    public static void pay(){
        boolean validation=false;
        double basewage=10,overtimewage=0, time=0, overtime=0;
        String answer;

        while(validation!=true) {
            try {

                answer=JOptionPane.showInputDialog("How many hours did you work this week?");
                if ((answer!= null)&& (answer.length()>0)){
                    time=Double.parseDouble(answer);
                    if (time>60){
                        JOptionPane.showMessageDialog(null, "You can't work more than 60 hours");
                        validation=false;
                    }
                    if (time > 40&& time<=60) {
                        overtime=time-40;
                        overtimewage=basewage*1.5;
                        validation=true;
                    }

                }else {
                    System.exit(0);
                    validation=true;}
            }catch(Exception error){
                JOptionPane.showMessageDialog(null, "Enter numbers, not letters");
                validation=false;
            }
        }
        JOptionPane.showMessageDialog(null,"You won "+(basewage*(time-overtime)+(overtime*overtimewage))+" dollars this week");
        JOptionPane.showMessageDialog(null,"If you work the same amount of hours all month you will win "+((basewage*(time-overtime)+(overtime*overtimewage))*4)+" dollars");
    }

    public static void main(String []args){
        pay();
    }
}
