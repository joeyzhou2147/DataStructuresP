package Jan29_01;
import java.util.Arrays;
import java.util.Random;


public class Class {

	Person[] students;
	private static final int STUDENT_COUNT = 50;
	private int inUse = 0;
	private int maxStudents;

	public Class() {
		students = new Person[STUDENT_COUNT];
		maxStudents = STUDENT_COUNT;
	}

	public Class(int initialCapacity) {
		students = new Person[initialCapacity];
		maxStudents = initialCapacity;
	}

	public void add(String name, int age, String city) {
		if (inUse < maxStudents) {
			students[inUse++] = new Person(name, age, city);
		}
	}

	public void ensureCapacity(int minimumCapacity) {

		Person[] biggerArray;
		
		if (students.length < minimumCapacity) {
			biggerArray = new Person[minimumCapacity];
			System.arraycopy(students, 0, biggerArray, 0, inUse);
			students = biggerArray;
		}

	}

	public int size() {
		return inUse;
	}

	public void addAll(Class addend) {
		ensureCapacity(inUse + addend.size());
		System.arraycopy(addend.students, 0, students, inUse, addend.inUse);
		inUse += addend.size();
	}

	public Class clone() {
		Class rtn;

		try {
			rtn = (Class) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Does not implement cloneable");
		}
		
		rtn.students = students.clone();
		return rtn;
	}
	
	public int countOccurrences(Person target) {
		int answer;
		int index;
		
		answer = 0;
		for (index = 0; index < inUse; index++) {
			if (target.equals(students[index])) {
				answer++;
			}
		}
		
		return answer;
	}
	

	public Person remove() {
		Person rtn = null;
		Random rnd = new Random();

		if (inUse > 0) {
			rtn = students[0];
			students[0] = students[--inUse];
		}

		//				if (inUse > 0) {
		//					int x = rnd.nextInt(inUse);
		//					rtn = students[x];
		//					students[x] = students[--inUse];
		//				}

		return rtn;
	}

	@Override
	public String toString() {
		String rtn = "";
		rtn += inUse + " Students in class\n";
		for (int i = 0; i < inUse; i++) {
			rtn += students[i] + "\n";
		}


		return rtn;
	}

	public void emptyBag() {
		// Setting this to 0 does not free memory
		//		inUse = 0;

		while (remove() != null);

		// Too intimate with the details of implementation
		//		for (int i = 0; i < inUse; i++) {
		//			students[i] = null;
		//		}
		//		inUse = 0;
	}

}
