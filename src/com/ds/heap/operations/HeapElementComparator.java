package com.ds.heap.operations;

import java.util.Comparator;

public class HeapElementComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if (o1 instanceof Integer) {
			return Integer.compare((Integer) o1, (Integer) o2);
		} else if (o1 instanceof Float) {
			return Float.compare((Float) o1, (Float) o2);
		} else if (o1 instanceof Double) {
			return Double.compare((Double) o1, (Double) o2);
		} else if (o1 instanceof String) {
			return ((String) o1).compareTo((String) o2);
		} else {
			return 0;
		}
	}
}
