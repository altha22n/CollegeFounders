package tester;
import stackutils.ParanthesesChecker;
import static org.junit.Assert.*;

import org.junit.Test;



/**
 * 	This class checks if the parantheses match in a stack
 *  
 * @author Nada Al-Thawr
 *
 */
public class ParanthesesCheckerTest {
	
	@Test
	public void paranthesesTest1() {
		// test if parantheses match 
		
				String message = "Testing if parantheses match, true expected";
				assertEquals(message, true, ParanthesesChecker.checkParentheses("[ { ( ) [ ] } ]"));
			}
	public void paranthesesTest2() {
		// test if parantheses match 
		
				String message = "Testing if parantheses match, false expected";
				assertEquals(message, false, ParanthesesChecker.checkParentheses("{ [ } ]"));
			}
	public void paranthesesTest3() {
		// test if parantheses match 
		
				String message = "Testing if parantheses match, false expected";
				assertEquals(message, false, ParanthesesChecker.checkParentheses("( ( { { } ] ) )"));
			}
	public void paranthesesTest4() {
		// test if parantheses match 
		
				String message = "Testing if parantheses match, true expected";
				assertEquals(message, true, ParanthesesChecker.checkParentheses("( ( { { [ ] ( ) } ( ) } ) { [ ] } )"));
			}
		
	}
/*
 * This is how far I got in the lab, didn't have time to get to the next part
 */


