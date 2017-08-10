public class Founder {
	// private string variables for the id, name, year and college
	private String ID_num;
	private String name;
	private String year;
	private String college;

	/**
	 * constructor
	 * @param ID
	 * @param name
	 * @param year
	 * @param college
	 */
	public Founder(String ID, String name, String year, String college) {
		//set this to all the variables 
		this.ID_num = ID;
		this.name = name;
		this.year = year;
		this.college = college;
	}
	/**
	 * toString method
	 */
	public String toString() {
		//print the results
		String result = ('\n' + "[" + "id: " + ID_num + '\n' + name + '\n'
				+ year + '\n' + college + '\n' + "]");
		//return the results
		return result;

	}

}
