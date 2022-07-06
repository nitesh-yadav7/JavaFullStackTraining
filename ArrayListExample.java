/* Task 1 -  Make arayList and display all its value */
/* ask 2 - insert element at the first position of array list */
/* Task 3 - sort the array list */
/* Task 4 - shuffle the arraylist */
/*  */

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
		int n = 5;

		ArrayList<Integer> list = new ArrayList<Integer>(n);

		for (int i = 1; i <= n; i++) {
			list.add(i);
        }

		System.out.println("list: " + list);

		list.add(0, 7);

		System.out.println("add element at the 0th index: " + list);

		Collections.sort(list);

		System.out.println("sorted list: " + list);

		Collections.shuffle(list);

		System.out.println("shuffled list: " + list);

		for (int item : list) {
			System.out.println(item + " at index " + list.indexOf(item));
		}
    }
}
