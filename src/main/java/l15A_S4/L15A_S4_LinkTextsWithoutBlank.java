package l15A_S4;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L15A_S4_LinkTextsWithoutBlank {

	public static void main(String[] args) {
		//Jan 3rd


		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");

		List<WebElement> tagNames=driver.findElements(By.tagName("a"));
		System.out.println("Total number of  links= "+ tagNames.size());

		int count=0;

		for(int i=0; i<tagNames.size();i++) {
			String linkText=tagNames.get(i).getText();
			if (linkText.length()>0) {
				System.out.println(linkText);
				count++;
			}
		}

		System.out.println("Total links with text= " +count);
		driver.close();	
	}

}
