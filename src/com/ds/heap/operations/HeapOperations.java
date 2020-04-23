package com.ds.heap.operations;

import com.ds.heap.Heap;

public interface HeapOperations<T> {
	public int getParent(Heap<T> heap, int i);

	public int leftChild(Heap<T> heap, int i);

	public int rightChild(Heap<T> heap, int i);

	public Heap<T> createHeap(int capacity, Heap.HeapType heapType);
	
	public void percolateDown(Heap<T> heap, int i);
	
	public T deleteMax(Heap<T> heap);
	
	
}
