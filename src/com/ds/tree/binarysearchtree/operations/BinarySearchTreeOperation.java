package com.ds.tree.binarysearchtree.operations;

import java.util.Optional;

import com.ds.trees.traversal.Node;

public class BinarySearchTreeOperation {
	public static void main(String[] args) {
		Node<Integer> binarySearchTree = initializeTree();
		// finding element in binary tree
		Optional<Node> searchedNode = findElementBinaryTree(binarySearchTree, 3);
		if (searchedNode.isPresent()) {
			System.out.println(searchedNode.get().getData());
		}

		// finding minimum in binary tree
		Optional<Node> minimum = findMinimum(binarySearchTree);
		if (minimum.isPresent()) {
			System.out.println(minimum.get().getData());
		}

		// finding maximum in binary tree
		Optional<Node> maximum = findMaximum(binarySearchTree);
		if (maximum.isPresent()) {
			System.out.println(maximum.get().getData());
			
			
		insertElement(binarySearchTree,15);
		System.out.println(binarySearchTree);
		
		deleteNode(binarySearchTree, 15);
		System.out.println(binarySearchTree);
		
		System.out.println(findLCA(binarySearchTree, 30, 50));
		}
	}

	private static Node<Integer> initializeTree() {
		Node<Integer> node = new Node<Integer>(10);
		Node<Integer> node1 = new Node<Integer>(20);
		Node<Integer> node2 = new Node<Integer>(30);
		Node<Integer> node3 = new Node<Integer>(40);
		Node<Integer> node4 = new Node<Integer>(50);
		Node<Integer> node5 = new Node<Integer>(60);
		Node<Integer> node6 = new Node<Integer>(70);
		Node<Integer> node7 = new Node<Integer>(80);
		node7.setLeft(node6);
		node5.setRight(node7);
		node5.setLeft(node3);
		node3.setRight(node4);
		node3.setLeft(node2);
		node2.setLeft(node1);
		node1.setLeft(node);
		return node5;
	}

	public static Optional<Node> findElementBinaryTree(Node<Integer> node, int data) {
		if (node != null) {
			if (node.getData() == data) {
				return Optional.of(node);
			} else if (node.getData() < data) {
				return findElementBinaryTree(node.getRight(), data);

			} else {
				return findElementBinaryTree(node.getLeft(), data);
			}
		} else {
			return Optional.ofNullable(null);
		}
	}

	public static Optional<Node> findMinimum(Node<Integer> node) {
		if (node != null) {
			if (node.getLeft() == null) {
				return Optional.of(node);
			} else {
				return findMinimum(node.getLeft());
			}
		} else {
			return Optional.ofNullable(null);
		}
	}

	public static Optional<Node> findMaximum(Node<Integer> node) {
		if (node != null) {
			if (node.getRight() == null) {
				return Optional.of(node);
			} else {
				return findMaximum(node.getRight());
			}
		} else {
			return Optional.ofNullable(null);
		}
	}
	
	public static void insertElement(Node<Integer> node, Integer data) {
		if (node != null) {
			if (node.getData() < data) {
				if (node.getRight() != null) {
					insertElement(node.getRight(), data);
				} else {
					node.setRight(new Node<Integer>(data));
					return;
				}

			} else {
				if (node.getLeft() != null) {
					insertElement(node.getLeft(), data);
				} else {
					node.setLeft(new Node<Integer>(data));
					return;
				}
			}
		} else {
			return;
		}
	}
	
	
	public static Node<Integer> deleteNode(Node<Integer> node, Integer data) {
		if(node == null) {
			return null;
		}
		// when data is less than the node
		if (data < node.getData()) {
			Node<Integer> temp = deleteNode(node.getLeft(), data);
			node.setLeft(temp);
		}// when data is greater than the node 
		else if (data > node.getData()) {
			Node<Integer> temp = deleteNode(node.getRight(), data);
			node.setRight(temp);
		} 
		// when data matched with the node  
		else {
			if (node.getRight() != null && node.getLeft() != null) {
				node.setData((Integer) findMaximum(node.getLeft()).get().getData());
				Node<Integer> temp1 = deleteNode(node.getLeft(), node.getData());
				node.setLeft(temp1); 
			}
			// when one child is present either left or right
			else {
				if (node.getLeft() == null) {
					return node.getRight();
				}
				if (node.getRight() == null) {
					return node.getRight();
				}
			}
		}
		return node;
	}
	
	public static Node<Integer> findLCA(Node<Integer> node,Integer value1, Integer value2){
		if((value1> node.getData() && value2<node.getData()) ||(value2 > node.getData() && value1 < node.getData())) {
			return node;
		}
		else if(value1 > node.getData()) {
			return findLCA(node.getRight(), value1, value2);
		}
		else {
			return findLCA(node.getLeft(), value1, value2);
		}
	}

}
