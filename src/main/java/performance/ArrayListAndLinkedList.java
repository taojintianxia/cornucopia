/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package performance;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author Kane.Sun
 */
public class ArrayListAndLinkedList {

	@SuppressWarnings("rawtypes")
	public static void main(String... args) {
		ArrayList<Comparable> arrayList = new ArrayList<>();
		LinkedList<Comparable> linkedList = new LinkedList<>();
		long start = System.currentTimeMillis();

		for (int i = 0; i < 50000; i++) {
			arrayList.add(i);
		}
		System.out.println("ArrayList add use " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			arrayList.get((int) (50000 * Math.random()));
		}
		System.out.println("ArrayList get use " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			arrayList.remove((int) (50000 * Math.random()));
		}
		System.out.println("ArrayList remove use " + (System.currentTimeMillis() - start));

		arrayList = null;
		System.gc();

		start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			linkedList.add(i);
		}
		System.out.println("LinkedList add use " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			linkedList.get((int) (50000 * Math.random()));
		}
		System.out.println("LinkedList get use " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			linkedList.remove((int) (50000 * Math.random()));
		}
		System.out.println("LinkedList remove use " + (System.currentTimeMillis() - start));

		linkedList = null;
		System.gc();
	}
}
