package com.ds.trees.traversal;

import com.ds.trees.problems.Miscellaneous;

public class ClassTreeOperations{
	public static void main(String []args) {
		Node<Integer> topNoderoot = new Node<Integer>(1);
		Node<Integer> secondNode = new Node<Integer>(2);
		Node<Integer> thirdNode = new Node<Integer>(3);
		Node<Integer> fourthNode = new Node<Integer>(4);
		Node<Integer> fifthNode = new Node<Integer>(5);
		Node<Integer> sixthdNode = new Node<Integer>(6);
		Node<Integer> sevenNode = new Node<Integer>(7);
		secondNode.setLeft(fourthNode);
		secondNode.setRight(fifthNode);
		thirdNode.setLeft(sixthdNode);
		thirdNode.setRight(sevenNode);
		topNoderoot.setLeft(secondNode);
		topNoderoot.setRight(thirdNode);
		
		// in oder traversal
		System.out.println("in order traversal");
		InOrderTraversal.inOrderTraversalWithRecursion(topNoderoot);
		System.out.println("");
		
		// in oder traversal without recursion
		System.out.println("in oder traversal without recursion");
		InOrderTraversal.inOrderTraversalWithoutRecursion(topNoderoot);
		System.out.println("");
		
		// pre oder traversal
		System.out.println("pre order traversal with recursion");
		PreorderTraversal.preOrderTraversalWithRecursion(topNoderoot);
		System.out.println("");
		
		
		// pre oder traversal
		System.out.println("pre order traversal without recursion");
		PreorderTraversal.preOrderTraversalWithoutRecursion(topNoderoot);
		System.out.println("");
		
		
		// post oder traversal
		System.out.println("post order traversal");
		PostOrderTraversal.postOrderTraversalWithRecursion(topNoderoot);
		System.out.println("");
		
		
		// post oder traversal
		System.out.println("post order traversal without recursion");
		PostOrderTraversal.postOrderTraversalWithOutRecursion(topNoderoot);
		System.out.println("");
		
		// level oder traversal
		System.out.println("level order traversal");
		LevelOrderTraversal.levelOrderTraversal(topNoderoot);
		System.out.println("");
		
		// level oder traversal in reverse order
		System.out.println("level order traversal");
		LevelOrderTraversal.levelOrderTraversalInReverseOrder(topNoderoot);
	    System.out.println("");
	    
	    // deleting the tree
	   // System.out.println("deleting the tree");
		//Miscellaneous.deleteTree(topNoderoot);
	   // System.out.println(topNoderoot);
	    
	    
	    //adding the node
	    System.out.println("deleting the tree");
		Miscellaneous.addANode(topNoderoot,new Node<Integer>(30));
		PreorderTraversal.preOrderTraversalWithRecursion(topNoderoot);
		System.out.println("");
		LevelOrderTraversal.levelOrderTraversal(topNoderoot);
	    //System.out.println(topNoderoot);
	}

}
