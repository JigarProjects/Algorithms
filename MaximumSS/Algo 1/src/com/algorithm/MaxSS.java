package com.algorithm;

public class MaxSS {
	public static void main(String[] args) {
		System.out.println("input size is "+args.length);
		int length= args.length;
		
		int current_sum;
		int max_sum=0;
		for(int i=0;i<=length-1;i++){
			for(int j=0;j<=length-1;j++){
				current_sum=0;
				System.out.println("start ------------"+ j + i);
				for(int k=i;k<=j;k++){
					System.out.println(current_sum +" + "+Integer.parseInt(args[k]));
					current_sum= current_sum + Integer.parseInt(args[k]);
				}
				
				if(current_sum>max_sum){
					max_sum=current_sum;
					System.out.println("found new maximum "+max_sum);
				}
				System.out.println("end ------------");
			}
		}
		System.out.println(max_sum);
	}
}
