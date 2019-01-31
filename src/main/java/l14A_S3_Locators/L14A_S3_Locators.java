package l14A_S3_Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L14A_S3_Locators {

	public static void main(String[] args) {
		
		
		//System.setProperty("WebDriver.Chrome.driver", "C://selenium/chromedriver_win32");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.id("u_0_c")).sendKeys("Smitha");
		driver.findElement(By.id("u_0_e")).sendKeys("Thomas");
		driver.findElement(By.name("reg_email__")).sendKeys("9000000300");
		driver.findElement(By.xpath("//*[@id=\'u_0_o\']")).sendKeys("test123");
		driver.findElement(By.id("u_0_u")).click();
		
		
	}
}
