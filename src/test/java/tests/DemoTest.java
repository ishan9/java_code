package tests;



import org.testng.annotations.Test;


public class DemoTest {
	@Test () 
	public void test() {
		System.out.println(System.getProperty("testarg"));		
	}
}
