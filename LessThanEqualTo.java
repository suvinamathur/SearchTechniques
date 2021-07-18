package com.test.search.binarySearch;

import java.util.Arrays;
import java.util.List;

public class LessThanEqualTo {

	public static void main(String[] args) {
		LessThanEqualTo l = new LessThanEqualTo();
		List<Integer> a = Arrays.asList(1, 3, 4, 4, 6 );
		int n = 7;
		System.out.print(l.solve(a,n));

	}
	
    public int solve(List<Integer> A, int B) {
        int l = 0, h= A.size()-1;
        int count= 0;
       if(A.get(h) <= B) {
    	   return A.size();
       }
       if(A.get(l) > B) {
    	   return 0;
       }
        while(l<=h){
            int m = l+(h-l)/2;
            System.out.println(l+ " "+h+ " "+m);
            if(A.get(m) <= B){
                l=m+1;
                
            }else if(A.get(m) > B){
                h=m-1;
                count=m;
            }
        }
        return count;
    }

}
