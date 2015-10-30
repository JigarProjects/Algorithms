package com.branchbound;

import java.util.ArrayList;
import java.util.Collections;

public class DistSet {
	static ArrayList<Integer> distancelist = new ArrayList<Integer>();
	
	
	public int deleteMax() {
		//System.out.println("before : "+this.toString());
		int maximum = Collections.max(distancelist);
		this.remove(maximum);
		//System.out.println("deletemax called : "+maximum+": "+ this.toString());
		return maximum;
	}
	public void addElement(int a){
		distancelist.add(a);
	}
	
	public boolean hasElement(int i) {
		boolean containsElement= false;
		if(distancelist.contains(i)){
			containsElement=true;
		}
		return containsElement;
	}
	
	@Override
	public String toString() {
		StringBuffer outputString = new StringBuffer();
		for(int i=0;i<distancelist.size();i++){
			outputString.append(distancelist.get(i)).append(" - ");
		}
		
		return outputString.toString();
	}
	public void remove(int i) {
		System.out.println("going to remove "+i);
		distancelist.remove( distancelist.indexOf(i) );
	}
	public boolean isEmpty() {
		boolean listIsEmpty=false;
		int sizeOfList = distancelist.size();
		if(sizeOfList==0){
			listIsEmpty= true;
		}
		return listIsEmpty;
	}
	public int findMax() {
		// TODO Auto-generated method stub
		return Collections.max(distancelist);
	}
	
}
