package stackutils;
import datastructures.StackLL;
public class ParanthesesChecker {

	/**
	 * Uses a Split String and a Stack to check if parentheses match
	 * 
	 * @param input
	 *            A string containing parentheses of types () [] {}
	 * @return True if each open parentheses is matched by a closing parentheses
	 */
	public static boolean checkParentheses(String input) {
		// create a string array and split the input
		// the input has all types of parantheses () [] {}
		String[] str = input.split(" ");
		// create a new stack
		StackLL<String> myList = new StackLL<String>();
		// loop through our string array
		for (int i = 0; i < str.length; i++) {
			// System.out.println(str[i]);
			// if our string equals any type of open parantheses
			if (str[i].equals("(") || str[i].equals("{") || str[i].equals("[")) {
				// then push (add ) the element to the parantheses
				myList.push(str[i]);
				// System.out.println("pushing" + str[i]);
				// if it equals to a closing parantheses
			} else if (str[i].equals(")")) {
				// System.out.println("popping" + str[i]);
				// check if it has a matching closing parantheses
				if (myList.peek().equals("(")) {
					// and pop it
					myList.pop();
				}
				else {
					return false;
				}
				// check if it has a matching closing parantheses
			} else if (str[i].equals("}")) {
				if (myList.peek().equals("{")) {
					//and pop
					myList.pop();
				}
				else {
					return false;
				}
				// check if it has a matching closing parantheses
			} else if (str[i].equals("]")) {
				if (myList.peek().equals("[")) {
					//and pop
					myList.pop();
				} else {
					return false;
				}

			} else
				return false;

		}
		//if the list is empty return true
		if (myList.isEmpty())

			return true;
		else
			return false;
	}

	/**
	 * Calls "checkParentheses" for each argument in "args" and prints out if
	 * they match or not
	 */
	public static void main(String args[]) {
		//create a boolen and pass in the check parantheses method 
		boolean outcome = checkParentheses("[ { ( ) [ ] } ]");
		boolean outcome2 = checkParentheses("{ [ } ]");
		boolean outcome3 = checkParentheses("( ( { { } ] ) )");
		boolean outcome4 = checkParentheses("( ( { { [ ] ( ) } ( ) } ) { [ ] } )");
		//print the outcome
		System.out.println("first test is " + outcome);
		System.out.println("second test is " + outcome2);
		System.out.println("third test is " + outcome3);
		System.out.println("fourth test is " + outcome4);

	}
}
