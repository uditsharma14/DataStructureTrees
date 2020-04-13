package com.ds.trees.problems;

import java.util.LinkedList;
import java.util.Stack;

import com.ds.trees.traversal.Node;

public class Miscellaneous{

	public static <T> void deleteTree(Node<T> root) {
	 if(root==null) {
		 return ;
	 }
	 deleteTree(root.getLeft());
	 deleteTree(root.getRight());
	 root.setLeft(null);
	 root.setRight(null);
	 root.setData(null);
	}
	
	
	public static <T> void addANode(Node<T> root,Node newnode) {
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		Stack<Node<T>> stack = new Stack<Node<T>>();
		
		if (root == null) {
			root = newnode;
		}
		if(newnode == null) {
			return ;
		}
		
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> frontNode = (Node<T>) queue.pop();
			if(frontNode.getLeft()!=null) {
				queue.add(frontNode.getLeft());	
			}
			else
			{
				frontNode.setLeft(newnode);
				return;
			}
			if(frontNode.getRight()!=null) {
				queue.add(frontNode.getRight());	
			}
			else {
				frontNode.setRight(newnode);
				return ;
			}
			stack.push(frontNode);
		 }
	   }	     
}
