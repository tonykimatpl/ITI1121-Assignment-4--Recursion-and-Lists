/*Test.java
Noël Khalaf, Tony Kim
300079144, 300087407
ITI1121
*/
/*Test class contains methods that give a return based on the values in a given array and tests said methods in a main method*/
public class Test{
	/*Main method executes and tests each method in the test class*/
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5,6};
		System.out.println("Sum of odd numbers is: "+sumOdd(a));
		System.out.println("Last occurance of 4 is: "+lastOccureance(a,4));
		int[] subset = sumArray(a,10);
		System.out.println("Subset to add up to sum of 10:");
		System.out.print("{ ");
		for(int i=0;i<subset.length;i++){
			System.out.print(subset[i]+" ");	 		 //Prints each element in the subset array
		}		
		System.out.print("}");
		System.out.println();
	}
	/*sumOdd returns the sum of all odd values in a given array*/
	public static int sumOdd(int[] t){
		if(t.length == 0){
			return 0;
		}
		else{
			return sumOdd(t,0);	 		 //Calls recursive method sumOdd with the array and initial index 0
		}
	}
	/*sumOdd recursively calculates the sum of all odd values in a given array and returns it to its inital method call*/
	private static int sumOdd(int[] t, int i){
		if(i == t.length){
			return 0;								//Breaks recursion
		}
		else{
			if(t[i]%2 == 1){
				return sumOdd(t,i+1) + t[i]; 		 //Adds current element to sum if it is odd and goes to next element
			}
			else{
				return sumOdd(t,i+1);				//Goes to next element in array
			}
		}
	}
	/*Returns index of last occurance of a given element in a given array*/
	public static int lastOccureance(int[] t, int n){
		if(t.length == 0){
			System.out.println("Array is Empty and does not contain "+n);
			return -1;
		}
		else{
			return lastOccureance(t,n,t.length-1);		//Calls recursive method lastOccureance with the array, the value, and index of last element in array
		}
	}
	/*recursively searches for last occurance of given element in array by starting from last element*/
	private static int lastOccureance(int[] t, int n, int i){
		if(i == -1){
			return -1;					//value not found in array, breaks recursion
		}
		else if(t[i] == n){
			return i;				//value found in array, breaks recursion
		}
		else{
			return lastOccureance(t,n,i-1);			//value does not equal current element, cycles to next element in array
		}
	}
	/*returns subset of given array with elements adding up to given value*/
	public static int[] sumArray(int[] t, int value){
		for(int i=0;i<t.length;i++){					//Cycles through all elements in array
			for(int j=0;j<t.length;j++){					//Cycles through all elements in array again to find a matching subset adding up to given value
				if(t[i]+t[j] == value){
					return new int[]{t[i],t[j]};				//returns found subset as an array
				}
			}
		}
		return null;								//did not find suitable subset
	}
}