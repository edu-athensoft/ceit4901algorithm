package com.athensoft.adt.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
	
	private static List<Node> traversePath = new ArrayList<Node>();
	
//	private static int level = 0;
	
	public static void main(String[] args) {
		Node myTreeRoot = createBinaryTree();
		
		preOrder(myTreeRoot);
		printTraversePath();
		
		
	}
	
	public static void preOrder(Node root) {
		if (root != null) {
			traversePath.add(root);
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	public static void printTraversePath() {
		for(Node node : traversePath) {
//			node.setLevel(getLevel(node));
			System.out.print(node+"\t");
		}
	}
	
	
	public static int getLevel(Node node) {
		int distance = 0;
		while(node.getParent()!=null) {
			distance++;
		}
		return distance;
	}
	
	public static Node createBinaryTree() {
		//leaf
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		//regular
		Node n2 = new Node(2, n1, n3);
		Node n5 = new Node(5, n6, n7);
		
		//root
		Node n4 = new Node(4, n2, n5);
		
		System.out.println(n2.getParent());
		System.out.println(n5.getParent());
		System.out.println(n1.getParent());
		System.out.println(n3.getParent());
		
		return n4;
	}
}
