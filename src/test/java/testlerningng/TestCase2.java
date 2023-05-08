package testlerningng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

	@Test(groups = {"high","med"})
	public void validateTitle() {

		String actual_title = "Gmail.com";
		String expected_title = "yahoo.com";
		/*
		 * if(actual_title.equals(expected_title)) {
		 * System.out.println("Test case pass"); }else {
		 * System.out.println("Test case fail"); }
		 */

		System.out.println("Beggining");

		SoftAssert asrt = new SoftAssert();

		asrt.assertEquals(actual_title, expected_title, "Titles are not matching");
		// isElementPresent - boolean
		asrt.assertTrue(false, "Element not found");
		asrt.fail("Forcefully failing the test");

		System.out.println("Ending");
		
		
		asrt.assertAll();
	}
}
