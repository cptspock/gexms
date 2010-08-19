package tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareTester {

	public static void main(String[] args) {
		Name nameArray[] = { new Name("John", "Lennon"),
				new Name("Peter", "Paul"), new Name("Groucho", "Marx"),
				new Name("Oscar", "Grouch") };
		List<Name> names = Arrays.asList(nameArray);
		Collections.sort(names);
		System.out.println(names);
	}
}

class Name implements Comparable<Name> {
	private final String firstName, lastName;

	public Name(String firstName, String lastName) {
		if (firstName == null || lastName == null)
			throw new NullPointerException();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String firstName() {
		return firstName;
	}

	public String lastName() {
		return lastName;
	}

	public int compareTo(Name n) {
		int lastCmp = lastName.compareTo(n.lastName);
		return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
	}

	public String toString() {
		return firstName + " " + lastName;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Name))
			return false;
		Name n = (Name) o;
		return n.firstName.equals(firstName) && n.lastName.equals(lastName);
	}
}
