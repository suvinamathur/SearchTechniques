/**
 * 
 * @author Suvina.Mathur
 * Given an integer A.
 * Compute and return the square root of A. 
 * If A is not a perfect square, return floor(sqrt(A)). 
 * Constraints 
 * 1 <= A <= 10^9
 */
public class SquareRoot {

	public static void main(String[] args) {

		SquareRoot s = new SquareRoot();
		int num = 11242434;
		System.out.println("Square root : " + s.sqrt(num));
		System.out.println("Square root(Func) : " + Math.floor(Math.sqrt(num)));
		
	}

	public int sqrt(int a) {
		if(a == 0 || a == 1)
			return a;
		long low = 0, high = a/2;
		while(low <= high) {
			long mid = (low + high)/2;
			if( mid*mid == a)
				return (int)mid;
			else if (mid*mid < a) {
				low = mid+1;
			} else {
				high = mid -1;
			}
		}
		return (int) high;
	}
}
