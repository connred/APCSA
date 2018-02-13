import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//ex_6_1();
		//ex_6_2();
		//ex_6_3();
		//ex_6_18();
		//ex_6_31();
		//ex_6_36();
	}
	
	
	
	
	
	
	
	
	// ################################################
	//				EXERCISE 6.1
	// ################################################
	static void ex_6_1() {
		        System.out.println("The first 100 pentagonal number are:");
		        for (int i = 1; i < 101; i++){
		            System.out.printf("%7d ", getPentagonalNumber(i));
		            if (i % 10 == 0)
		                System.out.println();
		        }
	}
	 public static int getPentagonalNumber(int n){
	        return (n * (3 * n - 1)) / 2;
	 }
	// ################################################
	//				EXERCISE 6.2
	// ################################################
	static void ex_6_2() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter an integer to sum the digits of: ");
        long value = in.nextLong();
        System.out.println("The sum of all digits is: " + sumDigits(value));
	}
    public static int sumDigits(long n){
        int temp = (int)Math.abs(n);
        int sum = 0;
        
        while(temp != 0){
            sum += (temp % 10);
            temp = temp / 10;
        }

        return sum;
    }  	
	
	// ################################################
	//				EXERCISE 6.3
	// ################################################
	static void ex_6_3() {
		Scanner input = new Scanner(System.in);
		 
		  System.out.print("Enter an integer:");
		  int number = input.nextInt();
		 
		  if (isPalindrome(number)) {
		   System.out.print(number + " is a palindrome");
		  } else {
		   System.out.print(number + " is not a palindrome");
		  }
		 
		 }
		 
		 public static int reverse(int number) {
		  int reverse = 0;
		  int digit;
		 
		  do {
		   digit = number % 10;
		   reverse = reverse * 10 + digit;
		   number /= 10;
		  } while (number != 0);
		 
		  return reverse;
		 }
		 
		 public static boolean isPalindrome(int number) {
		 
		  return (number == reverse(number));
		 
		 }
	// ################################################
	//				EXERCISE 6.18
	// ################################################
	static void ex_6_18() {
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter a password: ");
		String password = input.nextLine();
		System.out.println(
			(isValidPassword(password) ? "Valid " : "Invalid ") + "Password");
	}	
	public static boolean isValidPassword(String password) {
		final int LENGTH_OF_VALID_PASSWORD = 8;
	   final int MINIMUM_NUMBER_OF_DIGITS = 2;
		boolean validPassword = 
			isLengthValid(password, LENGTH_OF_VALID_PASSWORD) && 
			isOnlyLettersAndDigits(password) &&
			hasNDigits(password, MINIMUM_NUMBER_OF_DIGITS);
		return validPassword;
	}
	public static boolean isLengthValid(String password, int validLength) {
		return password.length() >= validLength;
	}
	public static boolean isOnlyLettersAndDigits(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isLetterOrDigit(password.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	public static boolean hasNDigits(String password, int n) {
		int numberOfDigits = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				numberOfDigits++;
			}
			if (numberOfDigits >= n) {
				return true;
			}
		}
		return false;
	}
	
	
	// ################################################
	//				EXERCISE 6.31
	// ################################################
	static void ex_6_31() {
		System.out.println(isValid(5105105105105100L));
	}

	
	public static int getDigit(int number) {
		if (number < 9)
			return number;
		else
			return number / 10 + number % 10;
	}
	
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		String num = number + "";
		for (int i = getSize(number) - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(num.charAt(i) + "");
		}
		return sum;
	}
	
	public static boolean prefixMatched(long number, int d) {
		return getPrefix(number, getSize(d)) == d;
	}
	
	public static int getSize(long d) {
		String num = d + "";
		return num.length();
	}
	
	public static long getPrefix(long number, int k) {
		if (getSize(number) >= k && k != 0)  {
			String num = number + "";
			return  Long.parseLong(num.substring(0, k));
		}
		return number;
	}
	
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		String num = number + "";
		for (int i = getSize(number) - 2; i >= 0; i -= 2) {
			sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
		}
		return sum;
	}

	public static boolean isValid(long num) {
		String stringNum = num + "";
		int length = stringNum.length();
		boolean valid =
				(getSize(num) >= 13 && getSize(num) <= 16) &&
				(prefixMatched(num, 4) || prefixMatched(num, 5) ||
				prefixMatched(num, 37) || prefixMatched(num, 6)) &&
				((sumOfDoubleEvenPlace(num) + sumOfOddPlace(num)) % 10 == 0);

			return valid;
	}

	// ################################################
	//				EXERCISE 6.36
	// ################################################
	static void ex_6_36() {
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter the number of sides: ");
		int n = input.nextInt();
		System.out.print("Enter the side: ");
		double side = input.nextDouble();
		System.out.println("The area of the polygon is " + area(n, side));
	}
	public static double area(int n, double side) {
		return (n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n)));
	}
}
