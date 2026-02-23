package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OutputInColor {
 static	RemoteWebDriver driver;
	@Test
	public static void SubcatageriesOfKidsmenuInColorFormat() throws InterruptedException {
		 driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		WebElement element = driver.findElement(By.xpath("//a[@href=\"/shop/kids\"]"));
		// element.click();
		// element.sendKeys(Keys.ENTER);
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@data-group=\"kids\"]/descendant::ul/li/a"));
		System.out.println(elements.size());
		String red="\u001B[34m";
		String Reset="\u001B[0m";
		int count = 0;
		for (WebElement elemt : elements) {
			
			
			String text=elemt.getText();
			if(text.equalsIgnoreCase("boys clothing")||
					text.equalsIgnoreCase("girls clothing")||
					text.equalsIgnoreCase("footwear")||
					text.equalsIgnoreCase("infants")) {
				System.out.println(red+text+Reset);
			}else {
				System.out.println(text);
			}
			count++;

		}
		Assert.assertEquals(elements.size(), count);

	}

}
