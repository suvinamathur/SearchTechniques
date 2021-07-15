/**
 * 
 * @author Suvina.Mathur
 * mid = (low+high)/2; -- it fails for larger values of int variables low and high. 
 * Specifically, it fails if the sum of low and high is greater than the maximum positive int value(2^31 – 1 ).
 * The sum overflows to a negative value and the value stays negative when divided by 2. 
 * It throws ArrayIndexOutOfBoundException.
 * Time Complexity : O(logn) ; Space Complexity : O(1)
 */

public class BinarySearch {

	public static void main(String[] args) {

		BinarySearch b = new BinarySearch();
		int[] arr = {1,3,5,6,7,8,11};
		int k = 13;
		int result = b.binarySearch(arr, k);
		if(result  == -1) {
			System.out.println(k + " not found");
		} else 
			System.out.println(k + " found at position " + result);
		
		result = b.binarySearchRecursive(arr, k,0,arr.length-1);
		if(result  == -1) {
			System.out.println(k + " not found");
		} else 
		System.out.println(k + " found at position (recursive) " + result);
	}
	
	public int binarySearch(int[] arr, int k) {
		
		int low = 0 , high = arr.length -1;
		int mid = -1;
		while(low <=high) {
			mid = low + (high-low)/2; 
			if(arr[mid] == k)
				return mid;
			else if(arr[mid] < k) {
				low=mid+1;
			}else if(arr[mid] > k) {
				high = mid -1;
			}
			
		}
		
		return -1;
	}
	
	/**
	 * 1. Recursion can be slower due to the overhead of maintaining a stack and usually takes up more memory
	 * 2. Recursion is not stack-friendly. It may cause StackOverflowException when processing big data sets
	 * 3. Recursion adds clarity to the code as it makes it shorter in comparison to the iterative approach
	 * @param arr  - Sorted Array
	 * @param k - number to search
	 * @param low - initially 0
	 * @param high - initially arr.length-1
	 * @return if found - mid else -1
	 */
	/**
	 * @param arr
	 * @param k
	 * @param low
	 * @param high
	 * @return
	 */
	public int binarySearchRecursive(int[] arr, int k, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			System.out.println("Low  = " + low + " Mid = "+ mid + " High = " + high );
			if (arr[mid] == k) {
				return mid;
			}
			else if (arr[mid] < k) {
				System.out.println("binarySearchRecursive(arr,"+ k+ ", "+ (mid + 1)+ " ,"+ high + ")");
				return binarySearchRecursive(arr, k, mid + 1, high);
			} else {
				System.out.println("binarySearchRecursive(arr,"+ k+ ", "+ low+ " ,"+ (mid-1)+ ")");
				return binarySearchRecursive(arr, k, low, mid - 1);
			}
		}
		return -1;
	}

}
