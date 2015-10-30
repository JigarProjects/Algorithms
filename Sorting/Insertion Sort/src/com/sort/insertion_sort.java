package com.sort;

public class insertion_sort {
	public static void main(String[] args) {
		int[] inta = new int[args.length];
		for(int i=0;i<args.length;i++){
			inta[i]= Integer.parseInt(args[i]);
		}
		sort_insert(inta);
		
	}

	private static void sort_insert(int[] inta) {
		// TODO Auto-generated method stub
		System.out.println(" length "+inta.length);
		int n= inta.length;
		for (int i = 1; i < n; i++) {
			int key = inta[i];
			System.out.println(i+" "+key);
            
            int j = i-1;
            while ( (j > -1) && ( inta [j] > key ) ) {
            	System.out.println(j+" exchang "+inta[j+1]+" "+inta[j]+" key "+key);
            	inta [j+1] = inta [j];
            	j--;
            }
            for(int x : inta){
    			System.out.print(" "+x);
    		}
            System.out.println("\n");
            inta[j+1] = key;
            for(int x : inta){
    			System.out.print(" "+x);
    		}
            System.out.println("\n");
        }
		/*
		System.out.println("print");
		for(int i : inta){
			System.out.print(" "+i);
		}*/
	}
	
}
