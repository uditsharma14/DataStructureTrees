package com.ds.heap.operations;

import com.ds.heap.Heap;
import com.ds.heap.Heap.HeapType;

public class HeapMain {
	
	public static void main(String args[]) {	
		HeapOperationsImpl<Integer> heapOperationsImpl = new HeapOperationsImpl<Integer>();
		Heap<Integer> heap = heapOperationsImpl.createHeap(10, HeapType.MAX_HEAP);
		System.out.println(heap);
		heapOperationsImpl.insert(heap, 10);
		heapOperationsImpl.insert(heap, 34);
		heapOperationsImpl.insert(heap, 78);
		heapOperationsImpl.insert(heap, 35);
		heapOperationsImpl.insert(heap, 25);
		heapOperationsImpl.leftChild(heap, 1);
		heapOperationsImpl.rightChild(heap, 1);
		System.out.println(heap);
	}
	
}
