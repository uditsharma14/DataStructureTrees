package com.ds.trees.traversal;

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

}
