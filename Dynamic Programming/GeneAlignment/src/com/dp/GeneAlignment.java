package com.dp;

public class GeneAlignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="AAAC";
		String s2="AGC";
		
		int numberOfRow=s1.length();
		int numberOfColumn=s2.length();
		int[][] matchMatrix = new int[numberOfRow+1][numberOfColumn+1];
		
		
		bestScoreCalculation(matchMatrix,s1,s2);
		
		
		for(int i=0;i< (numberOfRow+1); i++){
			for(int j=0;j< (numberOfColumn+1);j++){
				System.out.format("%4d",matchMatrix[i][j] );
			}
			System.out.println();
		}
	}

	private static void bestScoreCalculation(int[][] matchMatrix, String s1, String s2) {
		char[] s1array= s1.toCharArray();
		char[] s2array= s2.toCharArray();
		int numberOfRow=s1.length();
		int numberOfColumn=s2.length();
		int maximum=0;
		for(int row=1;row< (numberOfRow+1) ;row++){
			matchMatrix[row][0]=matchMatrix[row-1][0]-2;
			//System.out.println(" "+matchMatrix[i][0]);
		}
		
		
		for(int column=1;column< (numberOfColumn+1) ;column++){
			matchMatrix[0][column]=matchMatrix[0][column-1]-2;
			//System.out.println(" "+matchMatrix[i][0]);
		}
		int s1WithSpace,spaceWithS2,s1withS2;
		
		for(int i=1;i< (numberOfRow+1); i++){
			for(int j=1;j< (numberOfColumn+1);j++){
				int value=0;
				if(s1array[i-1] == s2array[j-1] ){
					value=1;
				}else{
					value=-1;
				}
				s1WithSpace = matchMatrix[i][j-1]-2;
				spaceWithS2 = matchMatrix[i-1][j-1]+value;
				s1withS2	= matchMatrix[i-1][j]-2;
				
				
				maximum = (s1WithSpace > spaceWithS2 ) ? ( (s1withS2 > s1WithSpace) ? s1withS2 : s1WithSpace ) 
						: ( (s1withS2 > spaceWithS2) ? s1withS2 : spaceWithS2 );
				
				System.out.println("   ij :"+i+j+" :"+maximum+" :::: "+s1WithSpace+" "+spaceWithS2+" "+s1withS2);
				matchMatrix[i][j]=maximum;
				
			}
		}
		
	}

}
