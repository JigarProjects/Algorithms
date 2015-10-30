package com.sort;


public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inta = new int[args.length];
		for(int i=0;i<args.length;i++){
			inta[i]= Integer.parseInt(args[i]);
		}
		sort_bubble(inta);
		
	}
	public static void sort_bubble(int[] a) {
		// TODO Auto-generated constructor stub
		int temp=0;
		System.out.println("length is "+a.length);
		int le= a.length-1;
		for(int i =0; i <le ; i++){
			System.out.println("checking for i>> "+i);
			for(int j=le;j>i+1;j--){
				System.out.println("checking for j "+j);
				if(a[j-1]>a[j]){
					temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> "+a[j]+" "+a[j-1]);
				}
			}
		}
		
		
		for(int i : a){
			System.out.print(" "+i);
		}
	}
}
