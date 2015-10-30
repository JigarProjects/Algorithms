package com.sort;

import java.util.Arrays;

public class QuickSort {

	
	public static void main(String[] args) {
		int[] inta = new int[args.length];
		for(int i=0;i<args.length;i++){
			inta[i]= Integer.parseInt(args[i]);
		}
		int low = 0;
		int high = inta.length - 1;
		 
		
		quickSort(inta, low, high);
		System.out.println(Arrays.toString(inta));
	}
	public static void quickSort(int[] arr, int low, int high) {
		
		System.out.println("pivot is on position "+ "::low "+low+" high "+high);
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		//int middle = low + (high - low) / 2;
		int middle= high;
		int pivot = arr[middle];
		System.out.println("pivot is on position "+middle+" pivot "+pivot+ "::low "+low+" high "+high);
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				System.out.println("exchanging "+arr[i]+" "+arr[j]);
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("PIVOTED   "+Arrays.toString(arr));
		System.out.println("========================"+low+" "+j+"=="+i+" "+high);
		
		//j-pivot-i
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
		
		
	}
}
