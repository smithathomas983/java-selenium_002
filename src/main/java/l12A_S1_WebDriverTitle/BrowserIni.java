package l12A_S1_WebDriverTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserIni {
	WebDriver driver;
	
	public WebDriver browser(String browser) {
		if(browser.contains("Chrome")) {
			System.setProperty("WebDriver.Chrome.driver", "C://selenium/chromedriver_win32");
		    driver = new ChromeDriver();
		  		}
		return driver;
	}

}
