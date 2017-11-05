import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        int age1,age2;
        String name1,name2;

        Scanner input = new Scanner(System.in);
        Scanner strings = new Scanner(System.in);

        System.out.println("Enter your full name and your age");
        name1=strings.nextLine();
        age1=input.nextInt();
        System.out.println("Enter someone else's full name and age");
        name2=strings.nextLine();
        age2=input.nextInt();

        if(age1>age2){
            System.out.println(name1+ " is older than "+name2);
        }
        else {
            System.out.println(name2 + " is older than " + name1);
        }
    }
}
