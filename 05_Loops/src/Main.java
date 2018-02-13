import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ex_5_1();
		ex_5_7();
		ex_5_10();
		ex_5_12();
		ex_5_13();
		ex_5_30();
		ex_5_41();
		ex_5_43();
	}
	
	static void ex_5_1() {
		Scanner input = new Scanner(System.in);
		int entered = input.nextInt();
		int total = 0;
		double sum = 0;
		int numPos = 0;
		int numNeg = 0;
		while (entered != 0) {
			total += 1;
			sum += entered;
			if (entered > 0) {
				numPos += 1;
			} else {
				numNeg += 1;
			}
		}
		System.out.println("Enter an integer, the input ends if it is 0: ");
		double avg = sum / (total);
		System.out.println("The number of positives is " + numPos);
		System.out.println("The number of negatives is " + numNeg);
		System.out.println("The total is " + total);
		System.out.println("The average is " + avg);
	}
	
	static void ex_5_7() {

	    int tuitionPerYear = 10000;
	    int totalCost = 0;

	    for (int i = 1; i <= 14; i++) {

	        tuitionPerYear += tuitionPerYear * .05;

	        if (i == 10) {
	            System.out.println("The cost of tuition in 10 years is $"
	                    + tuitionPerYear);
	        }
	        if (i > 10) {
	            totalCost = totalCost + tuitionPerYear;
	        }
	    }

	    System.out.println("The total cost of 4 years tuition in 10 years is $"
	            + totalCost);
	}

	static void ex_5_10() {
		double number = 0;
		int count = 0;
		for (int i = 100; i < 1000; i++) {
			if (i % 5 == 0 && i % 6 == 0) {
				System.out.print(i + " ");
				count += 1;
				if (count == 10 || count == 20) {
					System.out.println("");
				}
			}
		}
	}
	
	static void ex_5_12() {
		int i = 0;
		for (i = 0; i < Math.sqrt(12000); i ++) {
		}
		System.out.println(i + " x " + i + " = " + (i * i)); 

	}
	
	static void ex_5_13() {
		int i = 0;
		for (i = 12000; i > Math.cbrt(12000); i --) {
		}
		System.out.println(i + " x " + i + " x " + i + " = " + (i * i * i)); 
	}

	static void ex_5_30() {
		Scanner input = new Scanner (System.in);
		System.out.print("Recurring investment: ");
		int investment = input.nextInt();
		System.out.print("Annual interest rate: ");
		double interest = input.nextDouble();
		double monthInterest = interest / 12;
		System.out.print("Number of months: ");
		int months = input.nextInt();
		double compound = 0;
		double initial = 0;
		for (int i = 0; i < months; i ++) {
			initial = (investment + initial) * (1 + monthInterest);
		}
		compound = initial;
		System.out.print("Compound savings = " + compound);

	}
	
	static void ex_5_41() {
		Scanner input = new Scanner(System.in);
		int largest = 0;
		int occurrence = 0;
		int number;

		System.out.print("Enter numbers: ");
		do {
			number = input.nextInt();
			if (number > largest) {
				occurrence = 0;
				largest = number;
			}
			if (number == largest) {
				occurrence++;
			}

		} while (number != 0);

		System.out.println("The largest number is " + largest);
		System.out.println("The occurrence count of the largest number is " + occurrence);
	}

	static void ex_5_43() {
		int counter = 0;
        for (int i = 1; i < 8; i++){
            for (int j = i + 1; j < 8; j++) {
                System.out.println(i + " " + j);
                counter++;
            }
        }
        System.out.println("The total number of all is " + counter);
    }
}
