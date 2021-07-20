package com.test.search.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchForRange s = new SearchForRange();
		List<Integer> l = Arrays.asList(5);
		System.out.print(s.searchRange(l,5));
//		System.out.println("First Occurence : " +s.fOccurence(l, 10));
//		System.out.println("Last Occurence : " +s.lOccurence(l, 10));
		

	}
	
	public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
		ArrayList<Integer> l = new ArrayList<>();
		if(A.size() <1) {
			l.add(-1);
			l.add(-1);
			return l;
		}
		
		l.add(fOccurence(A, B));
		l.add(lOccurence(A, B));
		return l;
   }
	
	private int fOccurence(List<Integer> A , int b) {
		int l =0, h= A.size()-1;
		int index = -1;
		while(l<=h) {
			int m = l + (h-l)/2;
			System.out.println(l+ " "+h+ " "+m);
			if(A.get(m) >= b) {
				h=m-1;
				if(A.get(m) == b)
					index = m;
			}else if(A.get(m) < b) {
				l=m+1;
			}
		}
		return index;
	}
	
	private int lOccurence(List<Integer> A , int b) {
		int index =-1;
		int l =0, h = A.size()-1;
		
		while(l<=h) {
			int m = l+(h-l)/2;
			System.out.println(l+ " "+h+ " "+m);
			if(A.get(m)<=b) {
				l=m+1;
				if(A.get(m) == b)
					index = m;
			}else if(A.get(m)>b) {
				h=m-1;
			}
		}
		return index;
		
	}

}
