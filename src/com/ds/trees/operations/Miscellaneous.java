package com.ds.trees.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.ds.trees.traversal.Node;
import com.ds.trees.utils.Counter;

public class Miscellaneous {
	
	static int  preIndex=0;
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
	
	
	public static <T> int numberOfHalfNodes(Node<T> root) {
		Node<T> temp = null;
		int numberOfHalfNodes=0;
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
			if ((null != temp.getRight() && null == temp.getLeft())
					|| (null == temp.getRight() && null != temp.getLeft())) {
				numberOfHalfNodes++;
			}
		}
		return numberOfHalfNodes;
	}
	
	public static <T> int widthOfTree(Node<T> root , Counter integerVal) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = widthOfTree(root.getLeft(), integerVal);
		int rightHeight = widthOfTree(root.getRight(), integerVal);
		
		if((leftHeight+rightHeight)>integerVal.getValue()) {
			integerVal.setValue(leftHeight+rightHeight);
		}
		return Math.max(leftHeight,rightHeight)+1;
		
	}
	
	
	public static <T> void mirrorBinaryTree(Node<T> root ) {
		if(root == null)
		{
			return ;
		}
		mirrorBinaryTree(root.getLeft());
		mirrorBinaryTree(root.getRight());
		Node<T> temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
	}
	
	
	public static <T> boolean checkBinaryTree(Node<T> root, Node<T> root2) {
		if (root == null && root2 == null) {
			return true;
		}
		if ((root == null  || root2 == null)) {
			return false;
		}
		if (root.getData() != root2.getData()) {
			return false;
		}
		return checkBinaryTree(root.getLeft(), root.getRight())
				&& checkBinaryTree(root.getLeft(), root.getRight());
	}
	
	
	public static List<List<String>> groupAnagrams(String[] strs) {
	     List<List<String>> sets = new ArrayList<List<String>>();
	     Map<Integer,Integer> anagramsSize= new HashMap<Integer, Integer>();
			for (int counter = 0; counter < strs.length; counter++) {
				boolean isAnagram = false;
				int size=getsize(strs[counter]);
				for (int counter1 = 0; counter1 < sets.size(); counter1++) {
					if (sets.get(counter1) != null) {
						List<String> anagrams = sets.get(counter1);
						String anagram = anagrams.get(0);
						if(anagramsSize.get(counter1)==null) {
							anagramsSize.put(counter1, getsize(anagram));
						}
						if((anagram.length() ==strs[counter].length()) && (anagramsSize.get(counter1)==size ) ) {
							Map<Character, Integer> map = new HashMap<Character, Integer>();
							for (int count = 0; count < anagram.length(); count++) {
								if (map.get(anagram.charAt(count)) != null) {
									int val = map.get(anagram.charAt(count));
									map.put(anagram.charAt(count), val + 1);
								} else {
									map.put(anagram.charAt(count), 1);
								}
							}
							for (int count1 = 0; count1 < strs[counter].length(); count1++) {
								if (map.get(strs[counter].charAt(count1)) != null
										&& map.get(strs[counter].charAt(count1)) > 1) {
									int value = map.get(strs[counter].charAt(count1));
									map.put(strs[counter].charAt(count1), value - 1);
								} else if (map.get(strs[counter].charAt(count1)) != null && map.get(strs[counter].charAt(count1)) == 1) {
									map.remove(strs[counter].charAt(count1));
								}
							}
							if ((map.size() == 0 && anagram.length()>0) || (anagram.equals(strs[counter]))) {
								anagrams.add(strs[counter]);
								isAnagram = true;
							}	
						}
					}
				}
				
				if(!isAnagram ||sets.size()==0) {
					List<String> list = new ArrayList<>();
					list.add(strs[counter]);
					sets.add(list);
				}
			}
			return sets;
	    }

	private static int getsize(String string) {
		int size = 0;
		for (int i = 0; i < string.length(); i++) {
			size = (int) string.charAt(i) + size;
		}
		return size;
	}
	
	
	 public int maxSubArray(int[] nums) {
	       int previousSum = Integer.MIN_VALUE; 
	       int sum =0;
	       for(int count=0;count<nums.length;count++) {
	    	   sum = sum + nums[count];
	    	   if(sum>previousSum) {
	    		  previousSum = sum; 
	    	   }
	    	   
	    	   if(sum<previousSum) {
	    		  previousSum = previousSum-nums[count];
	    	   }
	       }
	       return previousSum;
	    }
	 
	  public int getMin() {
		  Stack<Integer> stack = new Stack<Integer>();
		    Stack<Integer> tempStack = new Stack<Integer>();
		       int min = Integer.MAX_VALUE;
		       while(!stack.isEmpty()){
		           int element = stack.pop();
		           if(min>element){
		               min = element;
		           }
		           tempStack.push(element);
		       }
		        return min;
		    }
	  
	  
	/*
	 * public static Node buildBinaryTree(Node int []preoder , int [] inOrder, int
	 * start,int inEnd) {
	 * 
	 * }
	 */
}
