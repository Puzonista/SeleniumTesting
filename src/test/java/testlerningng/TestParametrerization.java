package testlerningng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;
public class TestParametrerization {
	@DataProvider
	public Object[][] getData() {
		String sheetName = "LoginTest";
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\LoginTest.xlsx");
		int rowCount = excel.getRowCount(sheetName);
		int colCount = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rowCount-1][colCount-1];
		
		System.out.println("rows:"+rowCount+":----columns:"+colCount);
		
		return data;
	}

	@Test(dataProvider = "getData")
	public void doLogin(String username, String password) {

	}
}
