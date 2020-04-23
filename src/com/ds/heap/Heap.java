package com.ds.heap;

public class Heap<T> {
	
	T array[];
	int count;
	int capacity;
	HeapType heapType;
	
	public enum HeapType{
		MIN_HEAP,MAX_HEAP;
	}

	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
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

	public HeapType getHeapType() {
		return heapType;
	}

	public void setHeapType(HeapType heapType) {
		this.heapType = heapType;
	}
	
}
