import java.util.Map;
import java.util.TreeMap;

/**
 * This class manages people and relations in family.
 *
 */
public class FamilyTree {
	private Map<String, Person> people;
	/**
	 * Constructs a family tree
	 */
	public FamilyTree() {
		people = new TreeMap<String, Person>();
	}

	/**
	 * Adds a person to family tree
	 * @param name name of person
	 * @param dob date of birth
	 * @param dod date of dead
	 */
	public void addPerson(String name, int dob, int dod) {
		Person person = new Person();
		person.setName(name);
		person.setDob(dob);
		person.setDod(dod);
		people.put(name, person);
	}

	/**
	 * Adds a person to family tree
	 * 
	 * @param name name of person
	 * @param dob date of birth
	 */
	public void addPerson(String name, int dob) {
		addPerson(name, dob, 0);
	}

	/**
	 * Adds an event to person
	 * @param name the name of person
	 * @param year the year of event
	 * @param content the content of event
	 */
	public void addEvent(String name, int year, String content) {
		Person person = people.get(name);
		if (person == null) {
			System.out.println("No such person!");
			return;
		}
		person.addEvent(year, content);
	}

	/**
	 * Adds relationship for two people
	 * 
	 * @param nameA the first person
	 * @param nameB the second person
	 * @param relation the relationship
	 */
	public void addRelationship(String nameA, String nameB, String relation) {
		Person personA = people.get(nameA);
		if (personA == null) {
			System.out.println("No such person!");
			return;
		}
		Person personB = people.get(nameB);
		if (personB == null) {
			System.out.println("No such person!");
			return;
		}
		if (relation.equals("married")) {
			personA.addSpouse(personB);
			personB.addSpouse(personA);
		} else if (relation.equals("parent")) {
			personA.addChild(personB);
			personB.addParent(personA);
		} else {
			System.out.println("Bad relation!");
		}
	}

	/**
	 * Prints the family tree.
	 */
	public void print() {
		for (Person person : people.values()) {
			if (person.isRoot()) {
				person.print(0);

			}
		}
	}
}
