
/**
 * An event of person.
 *
 */
public class Event implements Comparable<Event> {
	private int year;
	private String content;
	/**
	 * Constructs an event
	 * @param year the year of event
	 * @param content the content of event
	 */
	public Event(int year, String content) {
		this.year = year;
		this.content = content;
	}

	/**
	 * Returns the string representation of event.
	 * 
	 * @return string representation of event
	 */
	@Override
	public String toString() {
		return String.format("%d: %s", year, content);
	}

	/**
	 * Compares two events by year of event
	 * 
	 * @param o the object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Event o) {
		return this.year - o.year;
	}

}
