package com.ds.trees.traversal;

import java.util.LinkedList;
import java.util.Stack;

public class LevelOrderTraversal {

	public static <T> void levelOrderTraversal(Node<T> node) {
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		if (node == null) {
			return;
		}
		queue.add(node);
		while (!queue.isEmpty()) {
			Node<T> frontNode = (Node<T>) queue.pop();
			if(frontNode.getLeft()!=null) {
				queue.add(frontNode.getLeft());	
			}
			if(frontNode.getRight()!=null) {
				queue.add(frontNode.getRight());	
			}
			System.out.print(frontNode.getData()+ " ");
		}
	}
	
	
	public static <T> void levelOrderTraversalInReverseOrder(Node<T> node) {
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		Stack<Node<T>> stack = new Stack<Node<T>>();
		if (node == null) {
			return;
		}
		queue.add(node);
		while (!queue.isEmpty()) {
			Node<T> frontNode = (Node<T>) queue.pop();
			if(frontNode.getLeft()!=null) {
				queue.add(frontNode.getLeft());	
			}
			if(frontNode.getRight()!=null) {
				queue.add(frontNode.getRight());	
			}
			stack.push(frontNode);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().getData()+ " ");
		}
	}
	
}
