package hubSpotTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class L22A_S11_HubSpotLoginTest {

	WebDriver driver;

	@BeforeMethod
	public void sepUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://app.hubspot.com/login");
	}

	@Test
	public void verifyLoginPageTitle_test() {
		System.out.println("=======verifyLoginPageTitle_test=====");
		String title = driver.getTitle();
		System.out.println("Login Page Title is :" + title);
		Assert.assertEquals("title is wrong", "HubSpot Login", title);
	}

	@Test
	public void verifyLoginButton_Test() {
		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		Assert.assertTrue(loginButton.isDisplayed());

	}

	@Test
	public void login_Test() {
		driver.findElement(By.id("username")).sendKeys("smithathomas983@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@123");
		driver.findElement(By.id("loginBtn")).click();

		System.out.println(driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Getting Started | HubSpot"));
		String loginTitle = driver.getTitle();
		System.out.println("LoginTitle: " + loginTitle);
		Assert.assertEquals("Getting Started | HubSpot", loginTitle);
	}

	@Test
	public void profileName_test() {
		driver.findElement(By.id("username")).sendKeys("smithathomas983@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@123");
		driver.findElement(By.id("loginBtn")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("account-name ")));

		String loginName = driver.findElement(By.className("account-name ")).getText();
		Assert.assertEquals("Smitha Testing", loginName);

		System.out.println("Profile Name: " + loginName);

	}
	@Test
	public void validityOfSearchButton_Test() {
		driver.findElement(By.id("username")).sendKeys("smithathomas983@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@123");
		driver.findElement(By.id("loginBtn")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("account-name ")));
		
		Boolean searchButton=driver.findElement(By.id("navSearch-input")).isDisplayed();
		Assert.assertTrue("Search button is not present", searchButton);;
		
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
