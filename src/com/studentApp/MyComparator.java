package com.studentApp;

import java.util.Comparator;

public class MyComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		
		
		String s1=o1.toString();
		String s2=o2.toString();
		return s1.compareTo(s2);
	}

}
