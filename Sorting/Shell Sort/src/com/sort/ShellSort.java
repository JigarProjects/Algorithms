package com.sort;

public class ShellSort {
	public static void main(String[] args) {
		int[] inta = new int[args.length];
		for(int i=0;i<args.length;i++){
			inta[i]= Integer.parseInt(args[i]);
		}
		shell(inta);
	}
	public static void shell(int[] a) {
		int increment = a.length / 2;
		while (increment > 0) {
			System.out.println("increment "+increment);
			for (int i = increment; i < a.length; i++) {
				System.out.println("i is "+i);
				int j = i;
				int temp = a[i];
				while (j >= increment && a[j - increment] > temp) {
					System.out.println("J is "+a[j]+" "+a[j-increment]);
					a[j] = a[j - increment];
					j = j - increment;
				}
				a[j] = temp;
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment *= (5.0 / 11);
			}
		}
		
		for(int i : a){
			System.out.print(" "+i);
		}
	}
}
