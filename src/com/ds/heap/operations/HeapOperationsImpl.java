package com.ds.heap.operations;

import com.ds.heap.Heap;

/**
 * @author SharmaU1
 *
 * @param <T>
 */
public class HeapOperationsImpl<T> implements HeapOperations<T> {
	
	HeapElementComparator<T> heapElementComparator = new HeapElementComparator<T>();
	
	public int getParent(Heap<T> heap, int i) {
		if (i <= 0 || i >= heap.getCount()) {
			return -1;
		}
		return (i - 1) / 2;
	}

	
	/**
	 * To get the index of left child of heap element passing the index of that element
	 */
	public int leftChild(Heap<T> heap, int index) {
		int left = 2 * index + 1;
		if (left >= heap.getCount()) {
			return -1;
		}
		return left;
	}

	/**
	 * To get the index of right child of heap element passing the index of that element
	 */
	public int rightChild(Heap<T> heap, int index) {
		int right = 2 * index + 2;
		if (right >= heap.getCount()) {
			return -1;
		}
		return right;
	}

	/**
	 * To create a heap using capacity and heap type either MIN_HEAP or MAX_HEAP
	 */
	public Heap<T> createHeap(int capacity,Heap.HeapType heapType) {
		Heap<T> heap = new Heap<T>();
		heap.setHeapType(heapType);
		heap.setCapacity(capacity);
		T[] array = (T[])new Object[capacity];
		heap.setArray(array);
		return heap;
	}

	
	public void percolateDown(Heap<T> heap, int i) {
		int l, r, max;
		T temp;
		l = leftChild(heap, i);
		r = rightChild(heap, i);

		if (l != -1 && heapElementComparator.compare(heap.getArray()[l], heap.getArray()[i]) > 0) {
			max = l;
		} 
		else
			max = i;
		if (r != -1 && heapElementComparator.compare(heap.getArray()[r], heap.getArray()[i]) > 0) {
			max = r;
		}
		if (max != i) {
			// swap ith element with max
			temp = heap.getArray()[i];
			heap.getArray()[i] = heap.getArray()[max];
			heap.getArray()[max] = temp;
		}
		percolateDown(heap, max);
	}


	public T deleteMax(Heap<T> heap) {
		T data;
		if (heap.getCount() == 0)
			return null;
		data = heap.getArray()[0];
		heap.getArray()[0] = heap.getArray()[heap.getCount() - 1];
		heap.setCount(heap.getCount() - 1);
		percolateDown(heap, 0);
		return data;
		
	}
	
	
	
	public void insert(Heap<T> heap,T data) {
		int i;
		if (heap.getCount() == 0) {
			heap.getArray()[0] = data;
			heap.setCount(heap.getCount()+1);
			return ;
		}

		if (heap.getCount() == heap.getCapacity()) {
			resizeHeap(heap);
		}
		heap.setCount(heap.getCount() + 1);
		i = heap.getCount() - 1;

		while (i > 0 && heapElementComparator.compare(data, heap.getArray()[(i - 1) / 2]) > 0) {
			heap.getArray()[i] = heap.getArray()[(i - 1) / 2];
			i = (i - 1) / 2;
		}
		heap.getArray()[i] = data;
	}

	private void resizeHeap(Heap<T> heap) {
		T[] arrayOld = heap.getArray();
		T [] newArray = (T[])new Object[arrayOld.length*2];
		for(int counter=0;counter<heap.getCapacity();counter++) {
			newArray[counter] = arrayOld[counter]; 
		}
		heap.setCapacity(heap.getCapacity()*2);
		heap.setArray(newArray);
	}
	
}
