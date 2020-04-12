package com.ds.trees.traversal;

import java.util.Stack;

public class InOrderTraversal {

	public static <T> void inOrderTraversalWithRecursion(Node<T> node) {
		if(node == null) {
			return;
		}
		else {
			inOrderTraversalWithRecursion(node.getLeft());
			System.out.print(node.getData()+ " ");
			inOrderTraversalWithRecursion(node.getRight());
		}
	}
	
	
	public static <T> void inOrderTraversalWithoutRecursion(Node<T> root) {
		Stack<Node<T>> stack = new Stack<Node<T>>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			
			if(stack.isEmpty()) {
				return ;
			}
			
			root = stack.pop();
			System.out.print(root.getData()+" ");
			root = root.getRight();
		}
	}
	
}
