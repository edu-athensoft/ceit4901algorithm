package com.athensoft.adt.tree.binarytree;

public class Node {
	private int value;
	private Node left;
	private Node right;
	
	private int level;
	private Node parent;
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
		left.setParent(this);
		right.setParent(this);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
	public String toString() {
		return value+"("+level+")";
	}	
}
