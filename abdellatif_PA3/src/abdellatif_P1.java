import java.security.SecureRandom;
import java.util.Scanner;

public class abdellatif_P1 {

    public static int difficulty(int dif) {
    int ab;
    ab = (int) Math.pow(10,dif);
    return ab;
}

    public static double arithmetic(int type, double num1, double num2) {

        SecureRandom random = new SecureRandom();
        int numt = random.nextInt(3);
        double answer = 0;
        if (type == 5) {
            switch (numt + 1) {
                case 1:
                    System.out.printf("How much is %.0f plus %.0f%n", num1, num2);
                    answer = (num1+num2);
                    break;
                case 2:
                    System.out.printf("How much is %.0f minus %.0f%n", num1, num2);
                    answer = (num1-num2);
                    break;
                case 3:
                    System.out.printf("How much is %.0f times %.0f%n", num1, num2);
                    answer = (num1*num2);
                    break;
                case 4:
                    System.out.printf("How much is %.0f divided %.0f%n", num1, num2);
                    answer = (num1/num2);
                    break;
            }
            return answer;
        }else {
            switch (type) {
                case 1:
                    System.out.printf("How much is %.0f plus %.0f%n", num1, num2);
                    answer = (num1+num2);
                    break;
                case 2:
                    System.out.printf("How much is %.0f minus %.0f%n", num1, num2);
                    answer = (num1-num2);
                    break;
                case 3:
                    System.out.printf("How much is %.0f times %.0f%n", num1, num2);
                    answer = (num1*num2);
                    break;
                case 4:
                    System.out.printf("How much is %.0f divided by %.0f%n", num1, num2);
                    answer = (num1/num2);
                    break;
            }
            return answer;
        }


    }

    public static int responses(int a) {
        SecureRandom random = new SecureRandom();
        int numr = random.nextInt(3);
        if (a == 1) {
            switch (numr) {
                case 0: System.out.println("Very Good!");
                    break;
                case 1: System.out.println("Excellent!");
                    break;
                case 2: System.out.println("Nice Work!");
                    break;
                case 3: System.out.println("Keep up the good work!");
                    break;
            }

        } else if(a == 2) {
            switch (numr) {
                case 0: System.out.println("No. Please try again.");
                    break;
                case 1: System.out.println("Wrong. Try once more.");
                    break;
                case 2: System.out.println("Don't give up!");
                    break;
                case 3: System.out.println("No. Keep trying.");
                    break;
            }

        }
        return 0;
    }


    public static int mathprob(int dif, int type) {
        SecureRandom random = new SecureRandom();
        Scanner input = new Scanner(System.in);

        int difff = difficulty(dif);

        int num1 = random.nextInt(difff);
        int num2 = random.nextInt(difff);

        double answer = arithmetic(type, num1, num2);

        double stanswer = input.nextDouble();
        int a;
        int correct;

        if ((Math.abs(stanswer - answer) <= .00001)) {
            a = 1;
            responses(a);
            correct = 1;

        } else {
            a = 2;
            responses(a);
            correct = 2;
        }



        return correct;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int right = 0;
        int wrong = 0;
        int cont = 0;
        int dif;
        int type;

        while(cont == 0) {
            System.out.println("What difficulty? Up to four digits (enter 1,2,3, or 4)");
            while (true) {
                dif = input.nextInt();
                if ((dif < 5) && (dif > 0))  {
                    break;
                } else {
                    System.out.println("Please enter a valid option");
                }
            }

            while (true) {
                System.out.printf("Addition, Subtraction, Multiplication, Division, or all four? %n (Enter 1,2,3,4, or 5 for respective difficulty");
                type = input.nextInt();
                if ((type < 6) && (type > 0)) {
                    break;
                } else {
                    System.out.println("Please enter a valid option");
                }
            }

            for (int i = 0; i < 10; i++) {
                int correct = mathprob(dif,type);
                if (correct == 1) {
                    right++;
                } else if (correct == 2) {
                    wrong++;
                }

            }

            double percent = right / 10.0 * 100.0;
            System.out.println(percent + "% right");
            if (percent >= 75.0) {
                System.out.println("Congratulations, you are ready to go to the next level!");
            } else {
                System.out.println("Please ask your teacher for extra help.");
            }
            System.out.println("Enter yes to continue practicing, anything else to exit");
            String studentcont = input.next();
            if (studentcont.equalsIgnoreCase("yes") == false) {
                cont = 1;
            }


        }
    }
}
