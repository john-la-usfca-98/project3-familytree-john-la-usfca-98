import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used to represent a person in the family.
 */
public class Person {
	private String name;
	private int dob;
	private int dod;
	private ArrayList<Person> spouses;
	private ArrayList<Person> children;
	private ArrayList<Event> events;
	private ArrayList<Person> parents;

	/**
	 * Constructs a person
	 */
	public Person() {
		spouses = new ArrayList<Person>();
		children = new ArrayList<Person>();
		events = new ArrayList<Event>();
		parents = new ArrayList<Person>();
	}

	/**
	 * Gets name of person
	 * @return name of person
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of person
	 * @param name name of person
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets year of birth
	 * @return year of birth
	 */
	public int getDob() {
		return dob;
	}

	/**
	 * Sets year of birth
	 * @param dob year of birth
	 */
	public void setDob(int dob) {
		this.dob = dob;
	}

	/**
	 * Gets year of death
	 * @return year of death
	 */
	public int getDod() {
		return dod;
	}

	/**
	 * Sets year of death
	 * @param dod year of death
	 */
	public void setDod(int dod) {
		this.dod = dod;
	}

	/**
	 * Adds a spouse
	 * @param person the spouse
	 */
	public void addSpouse(Person person) {
		if (hasRelation(person)) {
			System.out.println("Multiple relation!");
			return;
		}
		spouses.add(person);
	}

	/**
	 * Add a child
	 * @param person the child
	 */
	public void addChild(Person person) {
		if (hasRelation(person)) {
			System.out.println("Multiple relation!");
			return;
		}
		children.add(person);
	}

	/**
	 * Add a parent
	 * @param person the parent
	 */
	public void addParent(Person person) {
		if (hasRelation(person)) {
			System.out.println("Multiple relation!");
			return;
		}
		parents.add(person);
	}

	/**
	 * Adds an event to person
	 * @param year the year of event
	 * @param content the content of event
	 */
	public void addEvent(int year, String content) {
		Event event = new Event(year, content);
		events.add(event);
	}

	/**
	 * Indicates if there is a direct relationship between two people.
	 * @param person the other person
	 * @return true if they have relationship, otherwise false
	 */
	public boolean hasRelation(Person person) {
		return parents.contains(person) || children.contains(person) || spouses.contains(person);
	}

	/**
	 * Indicates if the person is top level in family
	 * @return true if has no parents, otherwise false
	 */
	public boolean isRoot() {
		return parents.isEmpty();
	}

	/**
	 * Prints the person
	 * @param level used to control indentation
	 */
	public void print(int level) {
		String s = String.format("%s (%d-%s)", name, dob, dod == 0 ? "" : dod);
		Collections.sort(events);
		for (Event event : events) {
			s += String.format("; %s", event);
		}
		for (Person spouse : spouses) {
			s += " m. " + spouse.getName();
		}
		for (int i = 0; i < level; i++) {
			System.out.print("  ");
		}
		System.out.println(s);
		System.out.println();
		for (Person child : children) {
			child.print(level + 1);
		}
	}
}
