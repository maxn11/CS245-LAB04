//Maximus Nie
//3/10/2022
//CS245 Lab04: List All Possible Factorial Combinations

//import org.junit.jupiter.params.provider.Arguments;
import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

public class Lab04 {
	
	// Do not create a global variable for this lab
	/** Creates a new arraylist called arrList that holds lists of integers.
	  * Then it calls the findFactors and passes in arrList, input n, and the current iteration 1.
	  * @param integer n which is the number to be factored
	  * @return arrList after its gone through findFactors.
	  **/
	public static List<List<Integer>> multiSum(int n){
		//[TODO]
		List<List<Integer>> arrList = new ArrayList<List<Integer>>();
		findFactors(arrList, n , 1);
		return arrList;
	}
	
	/**
	 * Establish base case of when i becomes equal to input n
	 * @param arrList of arraylist integer type to store factors
	 * @param integer n is the input
	 * @param i gives current position and changes in recursion
	 * @return n for base case or recurse with i + 1
	 */
	public static int findFactors(List<List<Integer>> arrList, int n, int i) {
		//base case
		if(i == n || i == 0) {
			return n;
		}
		//check if i is still less than n
		if(i < n) {
			if(n % i == 0) {
				//create new arraylist called subList that will hold a set of factors
				//to add into the larger arrList.
				ArrayList<Integer> subList = new ArrayList<Integer>();
				subList.add(i);
				//check if i == 2 to print 2's out and prevent repetition
				if(i == 2) {
					//temp = 1 and iterate until temp is equal to the amount of 2's in the subList
					for(int temp = 1; temp < (Math.log(n) / Math.log(2)); temp ++) {
						subList.add(i);
					}
				} else {
					//add other factorial
					subList.add(n / i);
	            }
				//add into the larger arrList
				arrList.add(subList);
				
				//for 2,2,4 type sets
				if(i == 2 && Math.log(n) / Math.log(2) >= 4) {
					//create new arraylist called subList2
					ArrayList<Integer> subList2 = new ArrayList<Integer>();
					subList2.add(i);
					//check how many 2's are needed
					if(Math.log(n) / Math.log(2) % 2 == 0) {
						subList2.add(i);
					}
					//adds 4
					subList2.add(i * i);
					//check how many fours can be in the set
					for(int fourCounter = 0; fourCounter < (Math.log(n) / Math.log(2)) - 4; fourCounter++) {
						subList2.add(i * i);
					}
					//add to the arrList
					arrList.add(subList2);
				}	
			}
		}
		//recurse with i + 1
		return(findFactors(arrList, n, i + 1));
	}
	
	/** main method for testing
	  **/
	public static void main(String[] args){
		//alter n for testing
	    int n = 16;
	    System.out.print("Expected result for " + n + ":\n" + " [[1,16], [2,8], [2,2,4], [2,2,2,2], [4,4]]\n");
	    System.out.print("A total number of unique results found: 5\n");
	    System.out.print("------------------------\n");
	    System.out.print("Actual result for " + n + ": " + multiSum(n));
	  }

}
