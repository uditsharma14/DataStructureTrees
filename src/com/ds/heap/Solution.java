package com.ds.heap;

public class Solution {
	
	public static void main(String []args) {
		int ar[] = {4,3,4,3,2};
		System.out.println(lastStoneWeight(ar));
	}
    public static int lastStoneWeight(int[] stones) {
        HeapA HeapA = createHeapA(stones.length);
        for(int counter=0;counter<stones.length;counter++){
            insert(HeapA, stones[counter]);
        }
        
        while(HeapA.getCount()>1) {
			int x = deleteMax(HeapA);
			int y = deleteMax(HeapA);
			int sum = x-y;
			insert(HeapA, sum);
			
			
		}
        return HeapA.getArray()[0];
    }
    
    public static Integer deleteMax(HeapA HeapA) {
		Integer data;
		if (HeapA.getCount() == 0)
			return null;
		data = HeapA.getArray()[0];
		HeapA.getArray()[0] = HeapA.getArray()[HeapA.getCount() - 1];
		HeapA.setCount(HeapA.getCount() - 1);
		percolateDown(HeapA, 0);
		return data;
	}
    
    private static void resizeHeapA(HeapA HeapA) {
		Integer[] arrayOld = HeapA.getArray();
		Integer [] newArray = new Integer[arrayOld.length*2];
		for(int counter=0;counter<HeapA.getCapacity();counter++) {
			newArray[counter] = arrayOld[counter]; 
		}
		HeapA.setCapacity(HeapA.getCapacity()*2);
		HeapA.setArray(newArray);
	}
    
    public static void insert(HeapA HeapA,Integer data) {
		int i;
		if (HeapA.getCount() == 0) {
			HeapA.getArray()[0] = data;
			HeapA.setCount(HeapA.getCount()+1);
			return ;
		}

		if (HeapA.getCount() == HeapA.getCapacity()) {
			resizeHeapA(HeapA);
		}
		HeapA.setCount(HeapA.getCount() + 1);
		i = HeapA.getCount() - 1;
		while (i > 0 && data > HeapA.getArray()[(i- 1) / 2]) {
			HeapA.getArray()[i] = HeapA.getArray()[(i- 1) / 2];
			i = (i- 1)/ 2;
		}
		HeapA.getArray()[i] = data;
	}
    
    /**
	 * To create a HeapA using capacity and HeapA type either MIN_HeapA or MAX_HeapA
	 */
	public static HeapA createHeapA(int capacity) {
		HeapA  HeapA = new HeapA();
		HeapA.setCapacity(capacity);
		Integer[] array = new Integer[capacity];
		HeapA.setArray(array);
		return HeapA;
	}
    
    public static void percolateDown(HeapA HeapA, int i) {
		int l, r, max;
		Integer temp;
		l = leftChild(HeapA, i);
		r = rightChild(HeapA, i);

		if (l != -1 && HeapA.getArray()[l]> HeapA.getArray()[i]) {
			max = l;
		} 
		else
			max = i;
		if (r != -1 && HeapA.getArray()[r] > HeapA.getArray()[max]) {
			max = r;
		}
		if (max != i) {
			// swap ith element with max
			temp = HeapA.getArray()[i];
			HeapA.getArray()[i] = HeapA.getArray()[max];
			HeapA.getArray()[max] = temp;
			percolateDown(HeapA, max);
		}
		
	}
    
    	/**
	 * To get the index of left child of HeapA element passing the index of that element
	 */
	public  static int leftChild(HeapA HeapA, int index) {
		int left = 2 * index + 1;
		if (left >= HeapA.getCount()) {
			return -1;
		}
		return left;
	}

	/**
	 * To get the index of right child of HeapA element passing the index of that element
	 */
	public static int rightChild(HeapA HeapA, int index) {
		int right = 2 * index + 2;
		if (right >= HeapA.getCount()) {
			return -1;
		}
		return right;
	}
    
}

class HeapA {
	Integer array[];
	int count;
	int capacity;
	
	public Integer[] getArray() {
		return array;
	}

	public void setArray(Integer[] array) {
		this.array = array;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
