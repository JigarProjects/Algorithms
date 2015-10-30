package com.dynamic;

public class RecursiveKnapsack {
	
	static int val[] = {1,2,3};
	static int wt[] = {2,3,5};
	static int W =8;
	static int length= val.length;
	static int V[][]= new int[length+1][W+1];
	
	
	public static void main(String[] args) {
		for(int i=0;i<length+1; i++){
			for(int j=0;j<W+1;j++){
				V[i][j]=-1;
			}
		}
		recurKnap( length, W );
		
		for(int i=0;i<length+1; i++){
			for(int j=0;j<W+1;j++){
				System.out.print(V[i][j]+" ");
			}
			System.out.println("");
		}
		
	}
	public static int recurKnap(int numberOfitem, int currentMaxWeight){
		int calculatedProfit=0;
		int weightOfnoItem=0;
		int valueOfnoItem= 0;
		if(numberOfitem!=0){
			weightOfnoItem=wt[numberOfitem-1];
			valueOfnoItem= val[numberOfitem-1];
		}
		System.out.println("calculating for {"+numberOfitem+" , "+currentMaxWeight+" } +value and weight of item "+numberOfitem +" - "+valueOfnoItem+" : "+weightOfnoItem+"  "+V[numberOfitem][currentMaxWeight]);
		if(V[numberOfitem][currentMaxWeight]==-1){
			if(numberOfitem<=0|| currentMaxWeight<=0){
				calculatedProfit=0;
			}else{
				
				
				if(weightOfnoItem > currentMaxWeight){
					calculatedProfit= recurKnap(numberOfitem-1, currentMaxWeight);
				}
				else{
					calculatedProfit= RecursiveKnapsack.maximum(recurKnap(numberOfitem-1, currentMaxWeight-weightOfnoItem)+valueOfnoItem, recurKnap(numberOfitem-1,currentMaxWeight));
				}
			}
			V[numberOfitem][currentMaxWeight]=calculatedProfit;
			System.out.println("calculated profit for "+numberOfitem+","+currentMaxWeight+" is "+calculatedProfit);
		}else{
			calculatedProfit=V[numberOfitem][currentMaxWeight];
			
		}
		return calculatedProfit;
	}
	private static int maximum (int a , int b){
		int max=0;
		if(a>b){
			max=a;
		//	System.out.println(a+" is bigger ");
		}
		else {
			max=b;
		//	System.out.println(b+" is bigger");
		}
		return max;
	}
}
