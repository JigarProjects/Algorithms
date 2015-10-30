package com.ds;

import com.greedy.Node;

public class Tree {
	
	static int count=0;
	Node root = new Node();
	public Node insert(Node leftNode, Node rightNode){
		root.setLeft(leftNode);
		root.setRight(rightNode);
		root.setCharacter("Tree"+count);
		root.setFrequency(leftNode.getFrequency()+rightNode.getFrequency());
		System.out.println(" joining "+leftNode+" "+rightNode+" in "+root.getCharacter()+" "+root.getFrequency()+" : ");
		count++;
		return root;
	}
	
	/*void insertNode(Node current, int value){
		System.out.println("inserting "+value+" checking against "+current.getValue());
		if(value<current.getValue()){
			if(current.getLeft()==null){
				Node newNode= new Node();
				newNode.setValue(value);
				current.setLeft(newNode);
			}else{
				insertNode(current.getLeft(), value);
			}
		}else{
			if(current.getRight()==null){
				Node newNode= new Node();
				newNode.setValue(value);
				current.setRight(newNode);
			}else{
				insertNode(current.getRight(), value);
			}
		}
	}*/
	public void preorder(Node node){
		if(node!=null){
			System.out.println(node.getCharacter()+" "+node.getFrequency()+" : ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	@Override
	public String toString() {
		String output= new String();
		if(root!=null){
			preorder(root);
		}else{
			output="Root is not intialized";
		}
		
		return output;
	}
}
