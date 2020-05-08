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
	
	
	public boolean backspaceCompare(String S, String T) {
	       Stack<Character> stack = new Stack<Character>();
	       Stack<Character> stack2 = new Stack<Character>();
	       
	        for(int count1=0;count1<S.length();count1++){
	            if(S.charAt(count1) == '#' && !stack.isEmpty()){
	                stack.pop();
	            }
	            else{
	                stack.push(S.charAt(count1));
	            }
	        }
	        
	         for(int count2=0;count2<T.length();count2++){
	            if(T.charAt(count2) == '#'){
	                stack2.pop();
	            }
	            else{
	                stack2.push(T.charAt(count2));
	            }
	        }
	        if(stack.size() !=stack2.size()) {
	        	return false;
	        }
	        else {
	        	while(!stack.isEmpty() && !stack2.isEmpty()) {
	        		Character firstElement = stack.pop();
	        		Character secondElement = stack2.pop();
	        		if(firstElement!= secondElement) {
	        			return false;
	        		}
	        	}
	        	 return true;
	        }
	    }
}
