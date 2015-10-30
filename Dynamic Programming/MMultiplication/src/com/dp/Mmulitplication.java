package com.dp;

public class Mmulitplication {
	
	public static void main(String[] args) {
		
		int[] inta = new int[args.length];
		for(int i=0;i<args.length;i++){
			inta[i]= Integer.parseInt(args[i]);
			System.out.print(inta[i]);
		}
		// to accomodate 0th row and column
		int[][] matrix = new int[inta.length][inta.length];
		
		int minmum = optimalMultiplication(inta, matrix );
		System.out.println("minimum "+minmum);
		
		for(int i=0;i<inta.length;i++){
			for(int j=0;j<inta.length;j++){
				System.out.print(matrix[i][j]+" : ");
			}
			System.out.println();
		}
	}

	private static int optimalMultiplication(int[] inta, int[][] matrix) {
		int n= inta.length;
		int r =0;
		int x= 9999;
		int mat1=0;
		int mat2=0;
		System.out.println("print+ "+n);
		int numberofMatrix= n-1;
		for(int size= 2; size<=numberofMatrix; size++){
			System.out.println("\nsize ="+size);
			for(int l = 1 ; l<n-size+1; l++){
				r=(l+size-1);
				System.out.println("l-r "+l+"-"+r);
				matrix[l][r]=999;
				for(int i =l ; i <= r-1;i++){
					
					mat1= matrix[l][i];
					mat2= matrix[i+1][r];
					x=  mat1+mat2+(inta[l-1]*inta[i]*inta[r]);
					if(x<matrix[l][r])
						matrix[l][r]= x;
					
					System.out.println(" i "+i+"  "+x
							//+ ""+inta[l-1]+inta[i]+inta[r]+" "+matrix[l][i]+" "+matrix[i+1][r]
							//+" "+(r)
							);
				}
			}
		}
			//System.out.println("");
		//}
		
		return 0;
	}
}
