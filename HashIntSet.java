import java.util.ArrayList;

public class HashIntSet {

	private class Node{
		public int data;
		public Node next;

		public Node(int value) {
			data = value;
			next = null;
		}
		public Node(int value, Node next) {
			data = value;
			this.next = next;
		}
	}

	private Node[] elements;
	private int size;
	public HashIntSet() {
		elements = new Node[10];
		size = 0;
	}

	public int hash(int i) {
		return (Math.abs(i) % elements.length);
	}

	public void add(int value) {
		if(!contains(value)) {
			int h = hash(value);
			Node newNode = new Node(value);
			newNode.next = elements[h];
			elements[h] = newNode;
			size++;

		}
	}
	public boolean contains(int value) {
		Node current = elements[hash(value)];
		while(current != null) {
			if(current.data == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public String toString() {
		String s = "";
		for(Node n:elements) {
			Node current = n;
			while(current != null) {
				s += current.data + " ";
				current = current.next;
			}
		}
		return s;
	}

	public void remove(int value) {
		int h = hash(value);
		if (elements[h] != null && elements[h].data == value) {
			elements[h] = elements[h].next;
			size--;
		} else {
			Node current = elements[h];
			while (current != null && current.next != null) {
				if (current.next.data == value) {
					current.next = current.next.next;
					size--;
					return;
				}
				current = current.next;
			}
		}
	}
		public void addAll(HashIntSet set) {
			for(Node n : set.elements) {
				Node current = n;
				while(current != null) {
					add(current.data);
					current = current.next;
				}
			}
		}
		public boolean equals(Object o) {
			if(o instanceof HashIntSet) {
				HashIntSet set = (HashIntSet) o;
				for(Node n : set.elements) {
					Node current = n;
					while(current != null) {
						if(!contains(current.data)) {
							return false;
						}
						current = current.next;
					}
				}
				return true;
			}
			return false;
		}
		public void removeAll(HashIntSet set) {
			for(Node n : set.elements) {
				Node current = n;
				while(current != null) {
					remove(current.data);
					current = current.next;
				}
			}
		}
		public void retainAll(HashIntSet set) {
			for(Node n : elements) {
				Node current = n;
				while(current != null) {
					if(!set.contains(current.data)) {
						remove(current.data);
					}
					current = current.next;
				}
			}
		}
		public ArrayList<Integer> toArrayHashIntSet() {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(Node n : elements) {
				Node current = n;
				while(current != null) {
					list.add(current.data);
					current = current.next;
				}
			}
			return list;
		}


	/* BJP4 Exercise 18.1: addAllHashIntSet
	 * Write a method named addAll that could be placed inside 
	 * the HashIntSet class. This method accepts another HashIntSet 
	 * as a parameter and adds all elements from that set into the 
	 * current set, if they are not already present.
	 *
	 * For example, if a set s1 contains [1, 2, 3] and another set 
	 * s2 contains [1, 7, 3, 9], the call of s1.addAll(s2); would change 
	 * s1 to store [1, 2, 3, 7, 9] in some order.
	 *
	 * You are allowed to call methods on your set and/or the other set. 
	 * Do not modify the set passed in. This method should run in O(N) time 
	 * where N is the number of elements in the parameter set passed in. 
	 */

	/* BJP4 Exercise 18.3: equalsHashIntSet
	 * Write a method in the HashIntSet class called equals that accepts 
	 * another object as a parameter and returns true if the object is 
	 * another HashIntSet that contains exactly the same elements. 
	 * The internal hash table size and ordering of the elements does not matter, 
	 * only the sets of elements themselves.
	 */

	/* BJP4 Exercise 18.4: removeAllHashIntSet
	 * Write a method in the HashIntSet class called removeAll that accepts 
	 * another hash set as a parameter and ensures that this set does not contain 
	 * any of the elements from the other set. For example, if the set stores 
	 * [-2, 3, 5, 6, 8] and the method is passed [2, 3, 6, 8, 11], your set would 
	 * store [-2, 5] after the call.
	 */

	/* BJP4 Exercise 18.5: retainAllHashIntSet
	 * Write a method in the HashIntSet class called retainAll that accepts 
	 * another hash set as a parameter and removes all elements from this set that 
	 * are not contained in the other set. For example, if the set stores [-2, 3, 5, 6, 8] 
	 * and the method is passed [2, 3, 6, 8, 11], your set would store [3, 6, 8].
	 */

	/* BJP4 Exercise 18.6: toArrayHashIntSet
	 * Write a method in the HashIntSet class called toArray that returns the elements of 
	 * the set as a filled array. The order of the elements in the array is not important 
	 * as long as all elements from the set are present in the array, with no extra empty 
	 * slots before or afterward.
	 */


	
	public static void main(String[] args) {
		//testing add ALL
		HashIntSet set1 = new HashIntSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		HashIntSet set2 = new HashIntSet();
		set2.add(1);
		set2.add(7);
		set2.add(3);
		set2.add(9);
		//set1.addAll(set2);
		System.out.println(set1);

		//testing equals
		System.out.println(set1.equals(set2));
		int x = 10;
		System.out.println(set1.equals(x));
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(7);
		list.add(3);
		list.add(9);
		System.out.println(set2.equals(list)); //false
		//testing remove all
		HashIntSet set3 = new HashIntSet();
		set3.add(-2);
		set3.add(3);
		set3.add(5);
		set3.add(6);
		set3.add(8);
		HashIntSet set4 = new HashIntSet();
		set4.add(2);
		set4.add(3);
		set4.add(6);
		set4.add(8);
		set4.add(11);
		set3.removeAll(set4);
		System.out.println(set3); // [-2, 5]
		//testing retain all
		HashIntSet set5 = new HashIntSet();
		set5.add(-2);
		set5.add(3);
		set5.add(5);
		set5.add(6);
		set5.add(8);
		HashIntSet set6 = new HashIntSet();
		set6.add(2);
		set6.add(3);
		set6.add(6);
		set6.add(8);
		set5.retainAll(set6);
		System.out.println(set5); // [3, 6, 8]
		//testing to array
		HashIntSet set7 = new HashIntSet();
		set7.add(-2);
		set7.add(3);
		set7.add(5);
		set7.add(6);
		set7.add(8);
		ArrayList<Integer> list2 = set7.toArrayHashIntSet();
		System.out.println(list2); // [-2, 3, 5, 6, 8]


	}

}
