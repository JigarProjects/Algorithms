package com.greedy;

public class Node implements Comparable<Node>{
	String character;
	int frequency;
	Node left;
	Node right;
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Node(String character, int frequency) {
		super();
		this.character = character;
		this.frequency = frequency;
	}
	
	
	public String getCharacter() {
		return character;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	
	
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	
	@Override
	public int compareTo(Node current) {
		
		return ((Integer)frequency).compareTo(current.frequency);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Node "+character+" with frequency "+frequency;
	}
	
}
