package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L19A_S8_ElementAction {

	// Jan 9th
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		String url = "https://www.google.com/";
		// By selector=By.linkText("Gmail");
		By selector1 = By.name("q");
		String key = "selenium";

		launchUrl(url);
		String titlePage = getPageTitle();
		if (titlePage.equals("Google")) {
			System.out.println("TC Pass");
		} else {
			System.out.println("TC Fail");
		}

		// getElement(selector);

		sendKeysElement(selector1, key);
		clickElement(selector1);
		quitDriver();

	}

	/**
	 * This method is used to launch the url. If the url is blank or null , it will
	 * throw an exception. If url is correct it will launch the url
	 * 
	 * @param url
	 */
	public static void launchUrl(String url) {

		if (url.equals("") || url.equals(null)) {
			try {
				throw new Exception("Url is blank or null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				driver.get(url);
			} catch (Exception e) {
				System.out.println("URL didnot load  " + url);
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

	}

	/**
	 * This method is used to navigate to new url. If url is blank or null , it will
	 * throw an exception. IF url is correct it will launch the url
	 * 
	 * @param url
	 */
	public static void navigateToUrl(String url) {

		if (url.equals("") || url.equals(null)) {
			try {
				throw new Exception("URL is blank or null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				driver.navigate().to(url);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Url didnot load " + url);
				System.out.println(e.getMessage());
			}
		}

	}

	/**
	 * This method is used to return the tile of the page.
	 * 
	 * @return title
	 */
	public static String getPageTitle() {

		String title = null;
		try {
			title = driver.getTitle();
			System.out.println("Title of the page is: " + title);
			return title;
		} catch (Exception e) {
			try {
				throw new Exception("Title not found");
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			System.out.println("Title not found");
		}
		return title;
	}

	/**
	 * This method will return webElement and throws an exception if the element is
	 * not found or visible
	 * 
	 * @param selector
	 * @return
	 */
	public static WebElement getElement(By selector) {

		try {
			return driver.findElement(selector);
		} catch (Exception e) {
			try {
				throw new Exception("Element not found or not visible");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return null;

	}

	/**
	 * This method is to click on the element ,after finding the element using
	 * getElement()
	 * 
	 * @param selector
	 */
	public static void clickElement(By selector) {
WebElement element=getElement(selector);
if(element!=null) {
		try {
			element.click();
		} catch (Exception e) {
			try {
				throw new Exception("Element  not able to click ");
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}}

	}

	/**
	 * This method is to send keys to the element after finding the element using
	 * getElement()
	 * 
	 * @param selector
	 * @param keys
	 */
	public static void sendKeysElement(By selector, String keys) {
		WebElement element=getElement(selector);
		if(element!=null) {
		
		try {
			element.sendKeys(keys);
		} catch (Exception e) {
			try {
				throw new Exception("Element not found of not able to send keys");
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}}

	}
/**
 * This method quit the browsers that has been opened in the testing process
 */
	public static void quitDriver() {
		try {
			driver.quit();
		} catch (Exception e) {
			try {
				throw new Exception("driver not able to close");
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}

	}

}
