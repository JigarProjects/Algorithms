package com.bt;

import java.util.HashMap;

public class OBTree {
	
	public static void main(String[] args) {
		int[] key = {1,2,3,4,5};
		int[] values= {7,10,5,8,4};
		
		int size = key.length;
		int[][] costMatrix= new int[size+1][size+1];
		int[][] nodeMatrix = new int[size+1][size+1];
		
		for(int i=0;i<size+1;i++){
			for(int j=0;j<size+1;j++){
				
				if(i!=0 && j!=0 && i<=j){
					costMatrix[i][j]=999;
				}
				//System.out.print(costMatrix[i][j]+" ");
				System.out.format(" %4d", costMatrix[i][j]);
			}
			System.out.println();
		}
		
		
		int minimum = optimalBinary(costMatrix,key,values, nodeMatrix);
		System.out.println("Afterwards : ");
		for(int i=0;i<size+1;i++){
			for(int j=0;j<size+1;j++){
				System.out.format(" %4d", costMatrix[i][j]);
			}
			System.out.println();
		}
		/*System.out.println("Node matrix ");
		for(int i=0;i<size+1;i++){
			for(int j=0;j<size+1;j++){
				System.out.format(" %4d", nodeMatrix[i][j]);
			}
			System.out.println();
		}*/
		System.out.println("find the optimal tree ");
		
		findOptimalTree(1,size,nodeMatrix);
		
	}

	private static void findOptimalTree(int i, int j, int[][] nodeMatrix) {
		// TODO Auto-generated method stub
		if(i!=j){
			int root = nodeMatrix[i][j];
			System.out.println(" root for "+i+" to "+j+" elements would be "+root);
			findOptimalTree(i, root-1, nodeMatrix);
			findOptimalTree(root+1, j, nodeMatrix);
		}
	}

	private static int optimalBinary(int[][] costMatrix, int[] key, int[] values, int[][] nodeMatrix) {
		// TODO Auto-generated method stub
		int min=0;
		int n= values.length;
		int r;
		int currentSum=0;
		
		for(int size=1;size<=n; size++){
			////System.out.println("size "+size);
			for(int l=1;l<=n-size+1;l++){
				currentSum=0;
				r=l+size-1;
				min = costMatrix[l][r];
				////System.out.println(""+l+r);
				int sum1=0;
				for(int k=l;k<=r;k++){
					sum1+=values[k-1];
				}
				
				if(l==r){
					min=values[l-1];
				}else{
					for(int k=l;k<=r;k++){
						////System.out.println("    :::: K which is root " +k+ " : " +l+ " " +(k-1)+ " "+ (k+1)+" "+ r +" : ");
						currentSum = sum1 + costMatrix[l][k-1]+ ( (k+1 <= n) ? costMatrix[k+1][r] : 0);
						
						if(currentSum<min){ 
							min=currentSum;
							nodeMatrix[l][r]=k;
						}
					}
				}
				costMatrix[l][r]= min;
			}
		}
		
		return min;
	}

}
