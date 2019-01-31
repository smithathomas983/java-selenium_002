package l12A_S1_WebDriverTitle;

import org.openqa.selenium.WebDriver;

public class DriverValidation {
	
	WebDriver driver;
	
	public DriverValidation(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void webpage(String url) {
		driver.get(url);
	}
	
	public void titleValidation(String title) {
		String t1= driver.getTitle();
		if (t1.contains(title)) {
			System.out.println("TC Pass...Correct title");
		}else {
			System.out.println("TC Fail....Incorrect title");
		}
	}
	
	public void closeBrowser(WebDriver driver) {
		driver.close();
	}
	
	
	
	 

}
