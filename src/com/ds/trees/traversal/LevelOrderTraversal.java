package com.ds.trees.traversal;

import java.util.LinkedList;

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
}
