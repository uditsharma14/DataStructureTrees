package com.ds.trees.traversal;

import java.util.Stack;

public class PreorderTraversal {

	public static <T> void preOrderTraversalWithRecursion(Node<T> node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.getData() + " ");
			preOrderTraversalWithRecursion(node.getLeft());
			preOrderTraversalWithRecursion(node.getRight());
		}
	}

	
	public static <T> void preOrderTraversalWithoutRecursion(Node<T> root) {
		Stack<Node<T>> stack = new Stack<Node<T>>();
		while (true) {
			while (root != null) {
				System.out.print(root.getData()+" ");
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.isEmpty()) {
				return ;
			}
			
			root = stack.pop();
			root = root.getRight();
		}
	}
}
