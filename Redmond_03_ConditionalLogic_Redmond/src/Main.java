import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        System.out.println("\nProblem 3.1:");
		ex_3_1();
		ex_3_9();
		ex_3_11();
	}
	
	static void ex_3_1() {
		// DECIMALS OFF BY A VERY SMALL AMOUNT
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a, b, c: ");
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();

		double discriminant = Math.pow(Math.pow(b, 2) - (4 * a * c), 0.5);


		if (discriminant > 0){
			double ans_1 = ((b*(-1)) + Math.pow((Math.pow(b,2) - 4 * a * c), 0.5)) / (2 * a);
			double ans_2 = ((b*(-1)) - Math.pow((Math.pow(b,2) - 4 * a * c), 0.5)) / (2 * a);

			System.out.printf("The equation has two roots %.5f and %.5f", ans_1, ans_2);

		}else if(discriminant == 0){
			double ans = ((b*(-1)) + Math.pow((Math.pow(b,2) - 4 * a * c), 0.5)) / (2 * a);
			System.out.println("The equation has one root " + ans);
		}else{
			System.out.println("The equation has no real roots");
		}
 
	}
	
	static void ex_3_9() {
		// TESTMAIN.JAVA CANT HAVE SPACES INBETWEEN NUMBERS
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first 9 ISBN digits: ");
        int isbn = input.nextInt();

        int d1 = isbn / 100000000;
        int remainingDigits = isbn % 100000000;
        int d2 = remainingDigits / 10000000;
        remainingDigits %= 10000000;
        int d3 = remainingDigits / 1000000;
        remainingDigits %= 1000000;
        int d4 = remainingDigits / 100000;
        remainingDigits %= 100000;
        int d5 = remainingDigits / 10000;
        remainingDigits %= 10000;
        int d6 = remainingDigits / 1000;
        remainingDigits %= 1000;
        int d7 = remainingDigits / 100;
        remainingDigits %= 100;
        int d8 = remainingDigits / 10;
        remainingDigits %= 10;
        int d9 = remainingDigits;

        int d10 = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;

        System.out.print("" + d1 + d2 + d3 + d4 + d5 
                                 + d6 + d7 + d8 + d9);
        if (d10 == 10)
            System.out.print("X");
        else
            System.out.print(d10);
	}
	
	static void ex_3_11() {
		// DECIMALS OFF BY A VERY SMALL AMOUNT
		Scanner input = new Scanner(System.in);
		
				System.out.print("Enter the month: ");
				int month = input.nextInt();
				System.out.print("Enter the year: ");
				int year = input.nextInt();
		
				boolean leapYear = 
					(year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
				switch (month)
				{
					case 1: System.out.println(
							 "There are" + " 31 " + "days in that month on that year."); break;
					case 2: System.out.println( "There are" + ((leapYear) ? " 29 days" : " 28 days") + " in that month on that year."); break;
					case 3: System.out.println(
							 "There are" + " 31 " + "days in that month on that year."); break;
					case 4: System.out.println(
							"There are" + " 30 " + "days in that month on that year."); break;
					case 5: System.out.println(
							"There are" + " 31 " + "days in that month on that year."); break;
					case 6: System.out.println(
							"There are" + " 30 " + "days in that month on that year."); break;
					case 7: System.out.println(
							"There are" + " 31 " + "days in that month on that year."); break;
					case 8: System.out.println(
							"There are" + " 31 " + "days in that month on that year."); break;
					case 9: System.out.println(
							"There are" + " 30 " + "days in that month on that year."); break;
					case 10: System.out.println(
							"There are" + " 31 " + "days in that month on that year."); break;
					case 11: System.out.println(
							"There are" + " 30 " + "days in that month on that year."); break;
					case 12: System.out.println(
							"There are" + " 31 " + "days in that month on that year."); break;
				}
	}
}
