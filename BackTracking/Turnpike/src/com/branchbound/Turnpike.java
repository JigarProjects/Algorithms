package com.branchbound;

import java.util.ArrayList;
import java.util.Iterator;

public class Turnpike {
	public static void main(String[] args) {
		int[] distance = {1,2,2,2,3,3,3,4,5,5,5,6,7,8,10};
		//int[] distance={2,3,5,5,8,10};
		int[] output= new int[6];
		int totalDistnace= distance.length;
		DistSet distset = new DistSet();
		for(int i=0;i<totalDistnace ;i++){
			distset.addElement(distance[i]);
		}
		System.out.println(distset.toString());
		turnpike(output,distset,output.length);
		
		System.out.println("\n\n--final output");
		/*for(int i=0;i<output.length;i++){
			System.out.print(output[i]+" - ");
		}*/
		printOutputArray(output);
		System.out.println("\n----");
	}
	
	private static void printOutputArray(int[] output) {
		// TODO Auto-generated method stub
		for(int i=0;i<output.length;i++){
			System.out.print(output[i]+" - ");
		}
		System.out.println("\n");
	}

	public static void turnpike( int[] output , DistSet d, int n){
		output[0]=0;
		output[n-1]=d.deleteMax();
		output[n-2]=d.deleteMax();
		if( d.hasElement(output[n-1]-output[n-2]) ){
			d.remove(output[n-1]-output[n-2]);
			System.out.println("n-3 is "+(n-3));
			Turnpike.place(output,d,n-1,1,n-3);
		}
	}

	private static boolean place(int[] output, DistSet d, int n, int left, int right) {
		boolean found=false;
		System.out.println("left : "+left+" right "+right);
		if(d.isEmpty()){
			return true;
		}
		
		int dmax=d.findMax();
		boolean canPutElementToRight=checkToIncludeElement(left,right,n,output,dmax,d,true);
		
		if(canPutElementToRight){
			output[right]=dmax;
			for(int j=0; j<=n;j++){
				if(j<left || right<j ){
					d.remove( Math.abs(output[j]-dmax) );
				}
			}
			found = place(output,d,n,left,right-1);
			//at some point of time if we find that we can not put element neither at left or right than we would backtrack the step by adding the elements that we removed
			if(!found){
				for(int j=0; j<=n;j++){
					if(j<left || right<j ){
						d.addElement( Math.abs(output[j]-dmax) );
					}
				}
			}
		}
		System.out.println("goting to left : ");
		Turnpike.printOutputArray(output);
		
		
		boolean canPutElementToLeft=checkToIncludeElement(left,right,n,output,dmax,d,false);
		if(!found && canPutElementToLeft){
			output[left]= output[n]-dmax;
			for(int j=0; j<=n;j++){
				if(j<left || right<j ){
					d.remove( Math.abs(output[n]-output[j]-dmax) );
				}
			}
			found = place(output,d,n,left+1,right);
			
			if(!found){
				for(int j=0; j<=n;j++){
					if(j<left || right<j ){
						d.addElement( Math.abs(output[n]-output[j]-dmax) );
					}
				}
			}
		}
		
		return found;
	}

	private static boolean checkToIncludeElement(int left, int right,int n,int[] output,int dmax, DistSet d,boolean isRight) {
		boolean includeElement=true;
		System.out.println("--check against---");
		for(int i=0;i<output.length;i++){
			System.out.print(output[i]+" ");
		}
		System.out.println("\n------");
		System.out.println("--distance are---");
		System.out.println(d.toString());
		System.out.println("\n------");
		
		ArrayList<Integer> intermediate = new ArrayList<Integer>();
		for(int j=0; j<=n;j++){
			if(j<left || right<j ){
				if(isRight){
					int diffrenece = Math.abs(output[j]-dmax);
					if(!( d.hasElement(diffrenece)) ){
						System.out.println("can not put element "+dmax+" to "+right+" position ");
						includeElement=false;
						break;
					}else{
						System.out.println("   check "+dmax+" with position "+j);
						intermediate.add(diffrenece);
						d.remove(diffrenece);
					}
				}else{
					int diffrenece = Math.abs(output[n]-dmax-output[j]);
					if(!( d.hasElement(diffrenece)) ){
						System.out.println("can not put element "+dmax+" to "+left+" position ");
						includeElement=false;
						break;
					}else{
						System.out.println("   check "+(output[n]-dmax)+" with position "+j);
						intermediate.add(diffrenece);
						d.remove(diffrenece);
					}
				}
			}
		}
		Iterator<Integer> interInterator = intermediate.iterator();
		while(interInterator.hasNext()){
			d.addElement(interInterator.next());
		}
		
		System.out.println("check completed");
		return includeElement;
	}
}
