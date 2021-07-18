package com.test.search.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitonicArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitonicArraySearch b = new BitonicArraySearch();
		List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 );
		int n = 12;
		System.out.print(b.solve(a,n));
	}
	
	public int solve(List<Integer> a, int b) {
		int bitonicElementIndex = findBitonicElementIndex(a);
		System.out.println(bitonicElementIndex + " "+a.get(bitonicElementIndex));
		if(bitonicElementIndex == -1 || a.get(bitonicElementIndex)<b) {
			return -1;
		}else {
			if(a.get(bitonicElementIndex) == b)
				return bitonicElementIndex;
			else {
				//search in first half
				int index = binarySearch(a, 0, bitonicElementIndex-1, b);
				if(index == -1) {
					//search in second half
					index  = binarySearchDesc(a, bitonicElementIndex+1,a.size()-1, b);
				}
				return index;
			}
		}
		
	}
	
	private int findBitonicElementIndex(List<Integer> a) {
		
		int l = 0, h = a.size()-1;
		while(l<=h) {
			int m = l + (h-l)/2;
			if(a.get(m) > a.get(m-1) && a.get(m) > a.get(m+1))
				return m;
			else if(a.get(m)<a.get(m+1))
				l=m+1;
			else if(a.get(m) >a.get(m+1))
				h =m-1;
		}
		return -1;
	}
	
	private int binarySearch(List<Integer> a, int l, int h,int b) {
		
		while(l <=h ) {
			int m = l + (h-l)/2;
			System.out.println(l+ " "+h+ " "+m);
			if(a.get(m) == b) {
				return m;
			}else if (a.get(m) > b)
				h=m-1;
			else
				l=m+1;
		}
		return -1;
	}
	private int binarySearchDesc(List<Integer> a, int l, int h,int b) {
		
		while(l <=h ) {
			int m = l + (h-l)/2;
			System.out.println(l+ " "+h+ " "+m);
			if(a.get(m) == b) {
				return m;
			}else if (a.get(m) > b)
				l=m+1;
			else
				h=m-1;
		}
		return -1;
	}

}
