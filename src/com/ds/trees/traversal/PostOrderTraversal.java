package com.ds.trees.traversal;

import java.util.Stack;

public class PostOrderTraversal {

	public static <T> void postOrderTraversalWithRecursion(Node<T> node) {
		if (node == null) {
			return;
		} else {
			postOrderTraversalWithRecursion(node.getLeft());
			postOrderTraversalWithRecursion(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}

	
	public static <T> void postOrderTraversalWithOutRecursion(Node<T> root) {
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node topNode = root;
		int rootVisits=0;
		while(true) {
			if(root != null) {
				stack.push(root);
				if (root == topNode){
					rootVisits++;
				}
				root = root.getLeft();
			}
			
			else{
				if(stack.isEmpty()) {
					return ;
				}			
				else if(stack.peek().getRight() == null || rootVisits>2) {
						Node<T> top = stack.pop();
						System.out.print(top.getData() +" ");
						if(!stack.isEmpty() && stack.peek().getRight() == top) {
							System.out.print(stack.pop().getData()+" ");
						}
					}
				if(!stack.isEmpty()) {
					if (stack.peek() == topNode){
						rootVisits++;
					}
					if(rootVisits<=2) {
						root = stack.peek().getRight();	
					}
				}
				
				else
					root = null;
				}
			
			}						
		}
	
}
