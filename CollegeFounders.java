import datastructures.LinkedList;

public class CollegeFounders {
	// initialize and create new LinkedList<Founder>
	private LinkedList<Founder> newFounder = new LinkedList<Founder>();

	/**
	 * adds a founder to our newFounder
	 * 
	 * @param f
	 */
	public void addFounder(Founder f) {
		// if the linked list is empty
		if (newFounder.isEmpty()) {
			// call insert first from the linked list
			// insert in the first position
			newFounder.insertFirst(f);
		} else {
			// else insert last
			newFounder.insertLast(f);
		}
	}

	/**
	 * calls toString method from linkedlist
	 */
	public String toString() {
		// returns toString
		return newFounder.toString();
	}
}
