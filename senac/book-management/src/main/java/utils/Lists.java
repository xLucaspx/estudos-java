package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lists {
	public static <T extends Comparable<? super T>> List<T> getSortedList(Set<T> set) {
		var list = new ArrayList<>(set);
		Collections.sort(list);
		return list;
	}
}
