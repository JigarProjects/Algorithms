package com.bt;

public class MatrixCell {
	int value;
	int rootNode;
	
	public MatrixCell(int value, int rootNode) {
		super();
		this.value = value;
		this.rootNode = rootNode;
	}
	public int getValue() {
		return value;
	}
	public int getRootNode() {
		return rootNode;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.value+" ("+this.rootNode+")";
	}
}
