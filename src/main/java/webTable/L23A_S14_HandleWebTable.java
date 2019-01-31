package webTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L23A_S14_HandleWebTable {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		String xpath_rowCount = "//table[@id='customers']//tr";
		String xpath_ColumnCount = "//table[@id='customers']//tr/th";

		String bXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String mXpath = "]/td[";
		String eXpath = "]";

		// *[@id="customers"]/tbody/tr[1]/th[1]
		// [@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[3]
		// *[@id="customers"]/tbody/tr[5]/td[1]

		L23A_S14_HandleWebTable obj = new L23A_S14_HandleWebTable();

		int rowCount = obj.tableCount(driver, xpath_rowCount);
		System.out.println("Total rows: " + rowCount);

		int columnCount = obj.tableCount(driver, xpath_ColumnCount);
		System.out.println("Total Columns: " + columnCount);
		obj.getValuesFromEachRow(driver, bXpath, mXpath, eXpath, xpath_rowCount, xpath_ColumnCount);

		driver.quit();

	}

	/**
	 * This method  returns the Count of rows or columns
	 * 
	 * @param driver
	 * @param xpath
	 * @return count
	 */
	public int tableCount(WebDriver driver, String xpath) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		int count = list.size();
		return count;
	}
	/**
	 * This method  prints  values from each row
	 * @param driver
	 * @param bXpath
	 * @param mXpath
	 * @param eXpath
	 * @param row_Count
	 * @param column_Count
	 */

	public void getValuesFromEachRow(WebDriver driver, String bXpath, String mXpath, String eXpath, String row_Count,
			String column_Count) {
		ArrayList<String> ar = new ArrayList<String>();

		for (int i = 2; i < tableCount(driver, row_Count); i++) {
			for (int j = 1; j <= tableCount(driver, column_Count); j++) {

				String rowXpath = bXpath + i + mXpath + j + eXpath;
				String value = driver.findElement(By.xpath(rowXpath)).getText();
				ar.add(value);

			}
			System.out.println(ar);
			ar.clear();

		}

	}
}
