package l16A_S5_DropDownList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class L16A_S5_DropDownList {
	//Jan 4th
			public static void main(String[] args) {
				
				WebDriver driver = new ChromeDriver();
								
				driver.get("https://www.facebook.com/");
				WebElement month=driver.findElement(By.id("month"));
				WebElement day=driver.findElement(By.id("day"));
				WebElement year=driver.findElement(By.id("year"));
				
				dropDownList(month);
				dropDownList(day);
				dropDownList(year);
				
				selectAValueFromDropDown(month,"Jan");
				selectAValueFromDropDown(day,"21");
				selectAValueFromDropDown(year,"1985");
			}
			
			public static void dropDownList(WebElement e) {
				
				Select daySelect=new Select(e);
				List<WebElement> list=daySelect.getOptions();
				int totalDays= list.size()-1;
				System.out.println(list.get(0).getText()+"'"+"s listed: "+totalDays);
				for (int i=1;i<list.size();i++) {
					
					String value=list.get(i).getText();
					System.out.println(value);
				}
				
				System.out.println("===============");
			}

			public static void selectAValueFromDropDown(WebElement e, String s) {
				
				Select s1= new Select(e);
				List<WebElement> list=s1.getOptions();
				
				for(int j=0;j<list.size();j++) {
					
					String value= list.get(j).getText();
					if(value.equals(s)) {
						list.get(j).click();
						break;
					}
					
				}
				
				
			}
			}


