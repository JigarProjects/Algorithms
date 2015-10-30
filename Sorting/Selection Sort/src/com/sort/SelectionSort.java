package com.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] inta = new int[args.length];
		for(int i=0;i<args.length;i++){
			inta[i]= Integer.parseInt(args[i]);
		}*/
		
		for (int i = 0; i < 10; i++) {
			int[] input = {9, 8, 7, 6, 5, 0, 1, 2, 3, 4};
			System.out.print(select(input, i));
			if (i < 9) System.out.print(", ");
		}
		
	}
	/*private static int myselect(int[] a, int position){
		int kthElement=0;
		if(kthElement >a.length){
			return -1;
		}
		else if(a.length == 1){
			return a[0];
		}
		
		return kthElement;
	}*/
	
	
	private static int partition(int[] arr, int left, int right, int pivot) {
		int pivotVal = arr[pivot];
		swap(arr, pivot, right);
		int storeIndex = left;
		for (int i = left; i < right; i++) {
			
/*			Integer midint = new Integer(arr[i]);
			if (midint.compareTo(pivotVal) < 0) {
*/			if(arr[i]<pivotVal){
				swap(arr, i, storeIndex);
				storeIndex++;
			}
		}
		swap(arr, right, storeIndex);
		return storeIndex;
	}
 
	private static int select (int[] arr, int n) {
		System.out.println("select called for position "+n+ " "+Arrays.toString(arr));
		int left = 0;
		int right = arr.length - 1;
		Random rand = new Random();
		while (right >= left) {
			int middle = left + (right - left) / 2;
			//int pivot = arr[middle];
			//int temporary = rand.nextInt(right - left + 1) + left;
			System.out.println("pivot position "+middle);
			int pivotIndex = partition(arr, left, right, middle);
			if (pivotIndex == n) {
				return arr[pivotIndex];
			} else if (pivotIndex < n) {
				left = pivotIndex + 1;
			} else {
				right = pivotIndex - 1;
			}
		}
		return -1;
	}
 
	private static void swap(int[] arr, int i1, int i2) {
		if (i1 != i2) {
			int temp = arr[i1];
			arr[i1] = arr[i2];
			arr[i2] = temp;
		}
	}

}
