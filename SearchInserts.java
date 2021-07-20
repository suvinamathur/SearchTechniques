package com.test.search.binarySearch;

import java.util.Arrays;
import java.util.List;

/*
 * Problem Description

Given a sorted array A and a target value B, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

**Problem Constraints**
1 <= |A| <= 100000
1 <= B <= 109

**Input Format**
First argument is array A.
Second argument is integer B.

**Output Format**
Return an integer, the answer to the problem.

**Example Input**
Input 1:

 A = [1, 3, 5, 6]
B = 5
Input 2:

 A = [1, 3, 5, 6]
B = 2


**Example Output**
Output 1:

 2
Output 2:

 1


**Example Explanation**
Explanation 1:

 5 is found at index 2.
Explanation 2:

 2 will be inserted at index 1.
 */

public class SearchInserts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInserts s = new SearchInserts();
		System.out.print(s.searchInsert(Arrays.asList(1, 3, 5, 6), 2));
	}
	
	public int searchInsert(List<Integer> a, int b) {
        int l =0, h= a.size()-1;
        int ans = -1;
        if(a.get(l) > b)
            return 0;
        if(a.get(h) < b){
            return a.size();
        }
        while(l<=h){
            int m = l +(h-l)/2;
            if(a.get(m) == b)
                return m;
            else if(a.get(m) > b){
                ans = m;
                h=m-1;
            }else if(a.get(m) <b){
                l=m+1;
            }
        }
        return ans;
	}

}
