import java.util.*;

public class Main {

	

	public static void main(String[] args) {

		

	}
	static int[] randomDigitArray(int k) {
		int[] a = new int[k];
		for(int i = 0; i < k; i++) {
			a[i] = (int)(Math.random() * 10);
		}
		return a;
	}

	

	static int linearSearch(int[] array, int element) {
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] == element) {
				return i;
			}
		}
		return -1;
	}

	static int sum(int[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			}
		return sum;
	}
	
	static void reverse(int[] array) {
		for(int i = 0; i < array.length / 2; i++)
		{
		    int temp = array[i];
		    array[i] = array[array.length - i - 1];
		    array[array.length - i - 1] = temp;
		}
	}

	

	static int mostFrequentElement(int[] array) {
		int count = 1, tempCount;
		int pop = array[array.length - 1];
		int temp = 0;
		for (int i = (array.length - 1); i > 0; i--)
		{
			temp = array[i];
			tempCount = 0;
			for (int j = 0; j < array.length; j++)
			{
				if(temp == array[j])
					tempCount++;
			}
			if (tempCount >= count)
			{
				pop = temp;
				count = tempCount;
			}
		}
		return pop;
	}

	

	static int[] countSingleDigits(int n) {
		int array[] = new int[10];
		while(n != 0) {
			int x = n % 10;
			array[x]++;
			n /= 10;
		}
		return array;
	}

	static void ex_7_6() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int num = reader.nextInt();
		int[] array = new int[countSingleDigits(num).length];
		for (int i = 0; i < 10; i++) {
			int counter = 0;
			for(int j = 0; j < countSingleDigits(num).length; j++) {
				if(array[j] == i) {
					counter++;
				}
			}

			System.out.println(i + " occurs " + counter + " times");
		}
		reader.close();
	}
	
	static final int SIZE = 10;
    public static double deviation(double[] x) {
        double mean = mean(x);
        double deviation = 0;
        for (int i = 0; i < x.length; i++) {
            deviation += Math.pow(x[i] - mean, 2);
        }
        return Math.sqrt(deviation / (x.length - 1));
    }
    public static double mean(double[] x) {
        double total = 0;
        for (int i = 0; i < x.length; i++) {
            total += x[i];
        }
        System.out.println(total);
        return total / x.length;
    }
    
    static void sortStudentsByTestScore(String[] students, double[] scores) {
	       for (int i = 0; i < scores.length - 1; i++) {
	           double currentMin = scores[i];
	           int currentMinIndex = i;
	           String currentStu = students[i];
	           for (int j = i + 1; j < scores.length; j++) {
	               if (currentMin < scores[j]) {
	                   currentMin = scores[j];
	                   currentStu = students[j];
	                   currentMinIndex = j;
	               }
	           }
	           if (currentMinIndex != i) {
	               scores[currentMinIndex] = scores[i];
	               students[currentMinIndex] = students[i];
	               scores[i] = currentMin;
	               students[i] = currentStu;
	           }
	       }
	   }



    public static boolean isSorted(int[] array) {
        if(isAscending(array) == true || isDescending(array) == true) {
        		return true;
        } else {
        		return false;
        }
    }

    static boolean isAscending(int[] array) {
    			if(array.length == 0 || array.length == 1) {
    				return true;
    				}else {
    			for (int i = 0; i < array.length - 1; i++) {
    				if (array[i] <= array[i + 1]) {
    					return true;
    				}
    			}
    			return false;
    				}
    }

    static boolean isDescending(int[] array) {
    	if(array.length == 0 || array.length == 1) {
    	return true;
    }else {
    	for (int i = 0; i < array.length - 1; i++) {
			if (array[i] >= array[i + 1]) {
				return true;
			}
		}
    	return false;
    }
    }

    static int indexOfSmallestElement(double[] array) {
    		int index = array.length - 1;
    		double smallest = array[array.length-1];
    		for(int i = array.length - 1; i >= 0; i--) {
    			if(array[i] <= smallest) {
    				smallest = array[i];
    				index = i;
    			}
    		}
    		return index;
    }

    static double[] removeSmallestElement(double[] array) {
		double newArray[] = new double[array.length-1];
		int index = indexOfSmallestElement(array);
		for(int i = 0; i < index; i++) {
				newArray[i] = array[i];
		}
		for(int i = index + 1; i < array.length; i++) {
			newArray[i-1] = array[i];
		}
	return newArray;

}

    static int indexOfBalancedSums(int a[]) {
    	  int leftsum, rightsum;
    	  for (int i = 0; i < a.length; i++)
    	  {
    	    leftsum = 0;  
    	    rightsum = 0;
    	    for (int j = 0; j < i; j++) {
    	      leftsum  += a[j];
    	    }
    	    
    	    for(int j = i+1; j < a.length; j++) {
    	      rightsum += a[j];
    	    }
    	    
    	    if (leftsum == rightsum) {
    	      return i;
    	    }
    	  }
    		return -1;
 } 

    static int[] zip(int[] a, int[] b) {

    		int[] array = new int[a.length + b.length];
    		int index = 0;
    		int minLength = Math.min(a.length, b.length);
    			for (int i = 0; i < minLength; i++) {
    				array[index++] = a[i];
    				array[index++] = b[i];
    			}
    			
    			if(a.length > minLength) {
    				for(int i = minLength; i < a.length; i++) {
    					array[i] = a[i];
    				}
    			} else if(b.length > minLength) {
    				for(int i = minLength; i < b.length; i++) {
    					array[i + a.length] = b[i];
    				}
    			}
    			return array;

    }

}