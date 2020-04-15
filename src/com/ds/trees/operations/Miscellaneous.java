package com.ds.trees.operations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.ds.trees.traversal.Node;

public class Miscellaneous {
	// to get the height of binary tree
	public static <T> int heightOfBinaryTree(Node<T> root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = heightOfBinaryTree(root.getLeft());
		int rightHeight = heightOfBinaryTree(root.getRight());

		if (leftHeight > rightHeight) {
			return (leftHeight + 1);
		} else {
			return (rightHeight + 1);
		}

	}

	// to get the height of binary tree
	public static <T> int heightOfBinaryTreeWithoutRecursion(Node<T> root) {
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		int level = -1;
		if (root == null) {
			return level;
		} else {
			queue.push(root);
			queue.push(null);
			while (!queue.isEmpty()) {
				root = queue.pop();
				if (root == null) {
					if (!queue.isEmpty()) {
						queue.add(null);
					}
					level++;
				} else {
					if (root.getLeft() != null) {
						queue.add(root.getLeft());
					}
					if (root.getRight() != null) {
						queue.add(root.getRight());
					}
				}
			}
		}
		return level;
	}

	// to get the height of binary tree
	public static <T> Node<T> findTheDeepestNode(Node<T> root) {
		Node<T> temp = null;
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		queue.push(root);
		while (!queue.isEmpty()) {
			temp = queue.pop();
			if (null != temp.getRight()) {
				queue.push(temp.getRight());
			}
			if (null != temp.getLeft()) {
				queue.push(temp.getLeft());
			}
		}
		return temp;
	}

	public static <T> void removeTheDeepestNodefromTree(Node<T> root, Node<T> deepestNode) {
		Node<T> temp = null;
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		queue.push(root);
		while (!queue.isEmpty()) {
			temp = queue.pop();
			if (null != temp.getRight()) {
				if (temp.getRight() == deepestNode) {
					temp.setRight(null);
					return;
				}
				queue.add(temp.getRight());
			}

			if (null != temp.getLeft()) {
				if (temp.getLeft() == deepestNode) {
					temp.setLeft(null);
					return;
				}
				queue.add(temp.getLeft());
			}
		}
		return;
	}

	
	public static <T> int numberOfLeafNodes(Node<T> root) {
		Node<T> temp = null;
		int numberOfLeavesNode=0;
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		queue.push(root);
		while (!queue.isEmpty()) {
			temp = queue.pop();
			if (null != temp.getRight()) {
				queue.add(temp.getRight());
			}
			if (null != temp.getLeft()) {
				queue.add(temp.getLeft());
			}
			if(null== temp.getRight() && null == temp.getLeft()) {
				numberOfLeavesNode++;
			}
		}
		return numberOfLeavesNode;
	}
	
	public static <T> int numberOfFullNodes(Node<T> root) {
		Node<T> temp = null;
		int numberOfFullNodes=0;
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		queue.push(root);
		while (!queue.isEmpty()) {
			temp = queue.pop();
			if (null != temp.getRight()) {
				queue.add(temp.getRight());
			}
			if (null != temp.getLeft()) {
				queue.add(temp.getLeft());
			}
			if(null != temp.getRight() && null != temp.getLeft()) {
				numberOfFullNodes++;
			}
		}
		return numberOfFullNodes;
	}
}
