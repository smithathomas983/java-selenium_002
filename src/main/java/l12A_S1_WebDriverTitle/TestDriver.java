package l12A_S1_WebDriverTitle;

import org.openqa.selenium.WebDriver;

public class TestDriver {
	public static void main(String[] args) {

		WebDriver driver;

		BrowserIni b1 = new BrowserIni();
		driver = b1.browser("Chrome");

		DriverValidation d1 = new DriverValidation(driver);
		d1.webpage("https://www.facebook.com/");
		d1.titleValidation("Facebook");
		d1.closeBrowser(driver);

	}

}
