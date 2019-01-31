package l12A_S1_WebDriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L12A_S1_WebDriverBasics {
	public static void main(String[] args) {

		System.setProperty("WebDriver.Chrome.driver", "C://selenium/chromedriver_win32");
		WebDriver driver = new ChromeDriver();

		driver.get("http://facebook.com");

		String title = driver.getTitle();

		if (title.contains("Facebook")) {
			System.out.println("TC Pass===Correct title");
		} else {
			System.out.println("TC Fail===Incorrect title");
		}

		driver.close();
 
	}

}
