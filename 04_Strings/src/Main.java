import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ex_4_15();
		ex_4_20();
		ex_4_22();
		ex_4_23();
		ex_4_26();
	}
	
	static void ex_4_15() {
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter a letter: ");
		String x = input.nextLine();
		char c = x.charAt(0);
		c = Character.toUpperCase(c);
		int number = 0;
		if (Character.isLetter(c))
		{
			if (c >= 'W')
				number = 9;
			else if (c >= 'T')
				number = 8;
			else if (c >= 'P')
				number = 7;
			else if (c >= 'M')
				number = 6;
			else if (c >= 'J')
				number = 5;
			else if (c >= 'G')
				number = 4;
			else if (c >= 'D')
				number = 3;
			else if (c >= 'A')
				number = 2;
			System.out.println("The corresponding number is " + number);
		}
		else
			System.out.println(c + " is an invalid input");
		
		
	}
	
	static void ex_4_20() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter a String: ");
		String x = in.nextLine();
		x.trim();
		int y = x.length();
		char z = x.charAt(0);
		System.out.print("Length = " + y + ", ");
		System.out.print("Character = " + z);
	}

	static void ex_4_22() {
		Scanner in = new Scanner(System.in);
		 
		  System.out.print("\nEnter String 1: ");
		  String s1 = in.nextLine();
		  System.out.print("Enter String 2: ");
		  String s2 = in.nextLine();
		 
		  if (s1.contains(s2)) {
		   System.out.println("String 2 is a substring of String 1.");
		  } else {
		   System.out.println("String 2 is not a substring of String 1.");
		  }
	}
	
	static void ex_4_23() {
		Scanner in = new Scanner(System.in);
		  System.out.print("Employee name:");
		  String name = in.nextLine();
		 
		  System.out.print(" Hours worked this week:");
		  double hours = in.nextDouble();
		 
		  System.out.print(" Hourly pay rate:");
		  double rate = in.nextDouble();
		 
		  System.out.print(" Federal tax rate:");
		  double ftax = in.nextDouble();
		 
		  System.out.print(" State tax rate: ");
		  double stax = in.nextDouble();
		 
		  System.out.println("\nEmployee Name: " + name);
		  System.out.println("Hours Worked: " + hours);
		  System.out.println("Pay Rate: $" + rate);
		  System.out.println("Gross Pay: $" + rate * hours);
		  System.out.println("Deductions:");
		  System.out.printf("  Federal Withholding (%.1f%%): $%.1f\n", ftax * 100,
		    ftax * rate * hours);
		  System.out.printf("  State Withholding (%.1f%%): $%.3f\n", stax * 100,
		    stax * rate * hours);
		  System.out.printf("  Total Deduction: $%.3f\n", (stax + ftax) * rate
		    * hours);
		  System.out.printf("Net Pay: $%.3f\n", (1 - stax - ftax) * rate * hours);
	}
	static void ex_4_26() {
	    Scanner in = new Scanner(System.in);
	    System.out.print(
	      "Enter a dollar amount in double, for example 11.56:");
	    String amount = in.next();
	    int numberOfOneDollars = 0;
	    int numberOfCents = 0;
	    int test = amount.indexOf('.');
	    //System.out.print(test);
	    if (test == -1) {
			numberOfOneDollars = Integer.parseInt(amount);
			numberOfCents = 0;
	    } else if(test == 0){
	    		numberOfOneDollars = -1;
	    		numberOfCents = Integer.parseInt(amount.substring(amount.indexOf('.')+1));
	    } else {
	 		numberOfOneDollars = Integer.parseInt(amount.substring(0, amount.indexOf('.')));
	 		numberOfCents = Integer.parseInt(amount.substring(amount.indexOf('.')+1));
	    }
	   
	    if (numberOfOneDollars > 0 && numberOfOneDollars <= 1 && test != -1) {
	    		if (numberOfCents == 0) {
	    			System.out.print(" " + numberOfOneDollars + " dollar");
	    		} else {
		    		System.out.print(" " + numberOfOneDollars + " dollar,");
	    		}
	    }
	    if (numberOfOneDollars == 0) {
    			if (numberOfCents == 0) {
    				System.out.print(" " + numberOfOneDollars + " dollars");
    			} else {
    				System.out.print(" " + numberOfOneDollars + " dollars,");
    			}
	    }
	    if (numberOfOneDollars > 0 && numberOfOneDollars <= 1 && test == -1) {
	    		if (numberOfCents == 0) {
	    			System.out.print(" " + numberOfOneDollars + " dollar");
	    		} else {
	    			System.out.print(" " + numberOfOneDollars + " dollar,");
	    		}	
	    }
	    if (numberOfOneDollars > 0 && numberOfOneDollars >= 2) {
    			if (numberOfCents == 0) {
    				System.out.print(" " + numberOfOneDollars + " dollars");
    			} else {
    				System.out.print(" " + numberOfOneDollars + " dollars,");
    			}	
	    }
	    if (numberOfCents > 0 && numberOfCents <= 1 && numberOfOneDollars != -1) {
			System.out.print(" " + numberOfCents + " cent");
	    }
	    if (numberOfCents > 0 && numberOfCents >= 2) {
			System.out.print(" " + numberOfCents + " cents");
	    }
	    if (numberOfOneDollars == -1 && numberOfCents >= 2 && numberOfCents > 0) {
	    		System.out.print(" 0 dollars,");
	    		System.out.print(" " + numberOfCents + " cents");
	    }
	    if (numberOfOneDollars == -1 && numberOfCents <= 1 && numberOfCents > 0) {
    			System.out.print(" 0 dollars,");
    			System.out.print(" " + numberOfCents + " cent");
	    }
	    
	}
}
