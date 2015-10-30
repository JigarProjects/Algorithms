package com.greedy;

import java.util.ArrayList;
import java.util.Collections;

import com.ds.Tree;

public class HuffmanEncodign {

	public static void main(String[] args) {
		ArrayList<Node> inputlist= new ArrayList<Node>();
		String[] inputChar={"a","e","i","8","t","sp","nl"};
		int[] frequency={10,15,12,3,4,13,1};
		
		
		
		for(int i=0;i<frequency.length;i++){
			Node newNode= new Node(inputChar[i],frequency[i]);
			inputlist.add(newNode);
		}
		System.out.println("----prepared input list-----");
		
		
		Collections.sort(inputlist);
		while( !(inputlist.size()==1) ){
			Tree intermediateTree = new Tree();
			inputlist.add( intermediateTree.insert( inputlist.get(0),inputlist.get(1) ) );
			inputlist.remove(1);
			inputlist.remove(0);
			
			System.out.println(inputlist);
		}
		
		System.out.println(inputlist.get(0));
		
		
	}
}
