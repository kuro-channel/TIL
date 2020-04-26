package jv.silver.nine.two;

import java.util.Comparator;

public class SampleComparator implements Comparator<Sample>{

	@Override
	public int compare(Sample s1, Sample s2) {
		if(s1.getId() < s2.getId()) { //
			return 1;
		}
		if(s2.getId() < s1.getId()) {
			return -1;
		}
		return 0;
	}
}