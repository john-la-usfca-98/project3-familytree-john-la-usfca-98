
/**
 * This class creates and displays a family tree.
 *
 */
public class A3 {
	/**
	 * Main method for testing family tree
	 * @param args unused
	 */
	public static void main(String[] args) {
		FamilyTree tree = new FamilyTree();
		// Details for Eleanor Roosevelt
		tree.addPerson("Anna Eleanor Roosevelt", 1884, 1962); // DOB, death
		tree.addEvent("Anna Eleanor Roosevelt", 1961, "1st Chair of the Presidential Commission on the Status of Women");
		tree.addEvent("Anna Eleanor Roosevelt", 1947, "1st United States Representative to the United Nations Commission on Human Rights");
		tree.addEvent("Anna Eleanor Roosevelt", 1946, "1st Chair of the United Nations Commission on Human Rights");

		// Details & marriage for Franklin Delano Roosevelt
		tree.addPerson("Franklin Delano Roosevelt", 1882, 1945); // DOB, death
		tree.addRelationship("Franklin Delano Roosevelt", "Anna Eleanor Roosevelt", "married");

		// Details & parents for Franklin Delano Roosevelt Jr.
		tree.addPerson("Franklin Delano Roosevelt Jr.", 1914, 1988);
		tree.addRelationship("Anna Eleanor Roosevelt", "Franklin Delano Roosevelt Jr.", "parent");
		tree.addEvent("Franklin Delano Roosevelt Jr.", 1963, "Member of the U.S. House of Representatives from New York's 20th district");
		tree.addEvent("Franklin Delano Roosevelt Jr.", 1949, "United States Under Secretary of Commerce");

		tree.addPerson("Franklin Delano Roosevelt III", 1938);
		tree.addRelationship("Franklin Delano Roosevelt Jr.", "Franklin Delano Roosevelt III", "parent");

		tree.addPerson("Anna Eleanor Roosevelt Halsted", 1906);
		tree.addRelationship("Anna Eleanor Roosevelt", "Anna Eleanor Roosevelt Halsted", "parent");

		tree.addPerson("Anna Eleanor Roosevelt Dall", 1927);
		tree.addRelationship("Anna Eleanor Roosevelt Halsted", "Anna Eleanor Roosevelt Dall", "parent");

		tree.addPerson("Curtis Roosevelt Dall", 1930);
		tree.addRelationship("Anna Eleanor Roosevelt Halsted", "Curtis Roosevelt Dall", "parent");

		tree.addPerson("John Roosevelt Boettiger", 1939);
		tree.addRelationship("Anna Eleanor Roosevelt Halsted", "John Roosevelt Boettiger", "parent");

		tree.print();
	}
}
