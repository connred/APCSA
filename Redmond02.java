import java.util.Scanner;
// anti cheat code
public class Redmond02{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nProblem 2.1:");
        prob1();
        System.out.println("\nProblem 2.2:");
        prob2();
        System.out.println("\nProblem 2.5:");
        prob5();
        System.out.println("\nProblem 2.6:");
        prob6();
        System.out.println("\nProblem 2.12");
        prob12();
        System.out.println("\nProblem 2.14");
        prob14();
        System.out.println("\nProblem 2.19");
        prob19();
    }
    public static void prob1(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter degrees in C: ");
        double c = in.nextDouble();
        System.out.println("You entered: " + c);
        double f = (9.0 / 5) * c + 32;
        System.out.println("Tempurature in Farenheight: " + f);
    }
    public static void prob2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the radius : ");
        double radius = in.nextDouble();
		  System.out.println("Enter the length of a cylinder : ");
        double length = in.nextDouble(); //anti cheat code
        double area = (radius * radius * Math.PI);
        System.out.println("The Area is " + area);
        System.out.println("The Volume is " + (area * length));
    }
    public static void prob5(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Subtotal : ");
        double subtotal = in.nextDouble();
		  System.out.println("Enter the gradtuity rate : ");
        double gradRate = in.nextDouble();
        double grad = (gradRate / 10);
        double total = (grad + subtotal);
        System.out.println("The gradtuity is " + grad);
        System.out.println("The total is " + total);
    }
    public static void prob6(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter # between 0-1000 :");
        int input = in.nextInt();
        int dig1 = input % 10;
        input = (input / 10);
        int dig2 = input % 10;
        input = (input / 10);
        int dig3 = input % 10;
        int sum = (dig1 + dig2 + dig3);
        System.out.println("The sum of the digits is " + sum);
   }
   public static void prob12(){
         Scanner in = new Scanner(System.in);
         System.out.println("Enter speed :");
         double v = in.nextDouble();
         System.out.println("Enter acleration :");
         double a = in.nextDouble();
         double answer = ((Math.pow(v,2)) / (2 * a));
         System.out.println("The minimun runway length for this airplane is " + answer);
   }
   public static void prob14(){
      Scanner in = new Scanner(System.in);
      System.out.println("Enter Weight in pounds:");
      double w = in.nextDouble();
      System.out.println("Enter Height in inches:");
      double h = in.nextDouble();
      w = (w * 0.45359237);
      h = (h * 0.0254);
      double bmi = (w / Math.pow(h,2));
      System.out.println("BMI is " + bmi);
   }
   public static void prob19(){
      Scanner in = new Scanner(System.in);
      System.out.println("Enter point one X and Y :");
      double x1 = in.nextDouble();
      double y1 = in.nextDouble();
      System.out.println("Enter point two X and Y :");
      double x2 = in.nextDouble();
      double y2 = in.nextDouble();
      System.out.println("Enter point three X and Y :");
      double x3 = in.nextDouble();
      double y3 = in.nextDouble();
      double side1 = (Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2));
      double side2 = (Math.pow(x3 - x2, 2)) + (Math.pow(y3 - y2, 2));
      double side3 = (Math.pow(x1 - x3, 2)) + (Math.pow(y1 - y3, 2));
      side1 = Math.sqrt(side1);
      side2 = Math.sqrt(side2);
      side3 = Math.sqrt(side3);
      double s = ((side1 + side2 + side3) / 2);
      double area = Math.sqrt(s * ((s - side1) * (s -side2) * (s - side3)));
      System.out.println("The area of the triangle is " + area);
   }
}
/* OUTPUT */
/*
Connors-MacBook-Pro-3:git2 connorredmond$ java Redmond02

Problem 2.1:
Enter degrees in C:
43
You entered: 43.0
Tempurature in Farenheight: 109.4

Problem 2.2:
Enter the radius :
5.5
Enter the length of a cylinder :
12
The Area is 95.03317777109125
The Volume is 1140.398133253095

Problem 2.5:
Enter the Subtotal :
10
Enter the gradtuity rate :
15
The gradtuity is 1.5
The total is 11.5

Problem 2.6:
Enter # between 0-1000 :
999
The sum of the digits is 27

Problem 2.12
Enter speed :
60
Enter acleration :
3.5
The minimun runway length for this airplane is 514.2857142857143

Problem 2.14
Enter Weight in pounds:
95.5
Enter Height in inches:
50
BMI is 26.857257942215885

Problem 2.19
Enter point one X and Y :
1.5
-3.4
Enter point two X and Y :
4.6
5
Enter point three X and Y :
9.5
-3.4
The area of the triangle is 33.600000000000016
*/
