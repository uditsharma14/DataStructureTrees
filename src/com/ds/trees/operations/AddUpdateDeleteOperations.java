package com.ds.trees.operations;

import java.util.LinkedList;
import java.util.Stack;

import com.ds.trees.traversal.Node;

public class AddUpdateDeleteOperations {

	// add a node to binary tree
	public static <T> void addANode(Node<T> root, Node newnode) {
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		Stack<Node<T>> stack = new Stack<Node<T>>();
		if (root == null) {
			root = newnode;
		}
		if (newnode == null) {
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> frontNode = (Node<T>) queue.pop();
			if (frontNode.getLeft() != null) {
				queue.add(frontNode.getLeft());
			} else {
				frontNode.setLeft(newnode);
				return;
			}
			if (frontNode.getRight() != null) {
				queue.add(frontNode.getRight());
			} else {
				frontNode.setRight(newnode);
				return;
			}
			stack.push(frontNode);
		}
	}

	// delete a node to binary tree
	public static <T> void deleteTree(Node<T> root) {
		if (root == null) {
			return;
		}
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		root.setLeft(null);
		root.setRight(null);
		root.setData(null);
	}

	// to delete the given node of binary tree
	public static <T> Node<T> deletingTheGivenNode(Node<T> root, T nodeVal) {
		Node<T> temp = null;
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		Node<T> deepestNode = Miscellaneous.findTheDeepestNode(root);
		if (root.getData() == nodeVal) {
			Miscellaneous.removeTheDeepestNodefromTree(root, deepestNode);
			deepestNode.setLeft(root.getLeft());
			deepestNode.setRight(root.getRight());
			root.setLeft(null);
			root.setRight(null);
			root = deepestNode;
			return root;
		} else if (nodeVal == deepestNode.getData()) {
			Miscellaneous.removeTheDeepestNodefromTree(root, deepestNode);
		} else {
			queue.push(root);
			while (!queue.isEmpty()) {
				temp = queue.pop();
				if (null != temp.getRight()) {
					if (nodeVal == temp.getRight().getData()) {
						Miscellaneous.removeTheDeepestNodefromTree(root, deepestNode);
						deepestNode.setLeft(temp.getRight().getLeft());
						deepestNode.setRight(temp.getRight().getRight());
						temp.getRight().setLeft(null);
						temp.getRight().setRight(null);
						temp.setRight(deepestNode);
						return root;
					}
					queue.push(temp.getRight());
				}
				if (null != temp.getLeft()) {
					if (nodeVal == temp.getLeft().getData()) {
						Miscellaneous.removeTheDeepestNodefromTree(root, deepestNode);
						deepestNode.setLeft(temp.getLeft().getLeft());
						deepestNode.setRight(temp.getLeft().getRight());
						temp.getLeft().setLeft(null);
						temp.getLeft().setRight(null);
						temp.setLeft(deepestNode);
						return root;
					}
					queue.push(temp.getLeft());
				}
			}
		}
		return root;
	}

}
