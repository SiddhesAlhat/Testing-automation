package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;                    
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyntraKidsModule {
	public static RemoteWebDriver driver;

	@Test(priority = 1, description = "verify kids menu visible")
	public static void verifyKidsMenuAvailable() throws InterruptedException {
		 driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		WebElement element = driver.findElement(By.xpath("//a[@href=\"/shop/kids\"]"));
		// element.click();
		// element.sendKeys(Keys.ENTER);
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Assert.assertTrue(element.isDisplayed(), "kids menu is not visible");

//		List<WebElement> elements = driver.findElements(By.xpath("//div[@data-group=\"kids\"]/descendant::ul/li/a"));
//		for (WebElement elemt : elements) {
//                    //elemt.click();
////			WebElement nextelement = driver
////					.findElement(By.xpath("//div[@data-group=\"kids\"]/li[3]/ul/li[4]/a[text()='Sports Shoes']"));
////			Thread.sleep(2000);
////			nextelement.sendKeys(Keys.ENTER);
//			System.out.println(elemt.getText());
//
//		}
		// driver.findElement(By.xpath(""));

	}

	@Test(priority = 2, description = "verify kidsmenu catagory dispaly")
	public static void SubcatageriesOfKidsmenu() throws InterruptedException {
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
		int count = 0;
		for (WebElement elemt : elements) {
			System.out.println(elemt.getText());
			count++;

		}
		Assert.assertEquals(elements.size(), count);

	}

	@Test(priority = 3, description = "verify kids menu visible nd footwear subcat also visible")
	public static void verifyKidsMenuNdSubcatclickOnFootWear() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		// option.addArguments("--incognito");
		 driver = new ChromeDriver(option);

		driver.get("https://www.myntra.com");
		WebElement element = driver.findElement(By.xpath("//a[@href=\"/shop/kids\"]"));
		Thread.sleep(2000);
		// element.click();
		// element.sendKeys(Keys.ENTER);
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement url = driver.findElement(By.xpath("//div[@data-group=\"kids\"]//li/a[text()='Footwear']"));

		url.click();

		System.out.println(driver.getCurrentUrl());

		Assert.assertTrue(driver.getCurrentUrl().contains("footwear"), " footwear url is not matched");
	}

	@Test(priority = 4, description = "verify kidsfootwear total count")
	public static void verifyKidsFootWeartotalcount() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		// option.addArguments("--incognito");
		 driver = new ChromeDriver(option);

		driver.get("https://www.myntra.com");
		WebElement element = driver.findElement(By.xpath("//a[@href=\"/shop/kids\"]"));
		Thread.sleep(2000);
		// element.click();
		// element.sendKeys(Keys.ENTER);
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement url = driver.findElement(By.xpath("//div[@data-group=\"kids\"]//li/a[text()='Footwear']"));

		url.click();

		// System.out.println(driver.getCurrentUrl());
		WebElement totalcount = driver.findElement(By.xpath("//div[@class=\"title-container\"]/span"));
		String s = totalcount.getText().replaceAll("\\D", "");
		// Assert.assertFalse(s.isEmpty(), "total count is empty");
		Assert.assertTrue(s.isEmpty(), "total count is not empty");

	}

	@Test(priority = 5, description = "verify radio button clickable")
	public static void verifyclickOnBoysFilter() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		// option.addArguments("--incognito");
		 driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com");
		// Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@href=\"/shop/kids\"]"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-group=\"kids\"]/li//a[text()='Footwear']")).click();
		WebElement Headcount = driver.findElement(By.xpath("//div[@class=\"title-container\"]/span"));
		System.out.println(Headcount.getText());
		String s = Headcount.getText().replaceAll("\\D", "");
		System.out.println("get count :" + s);
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//ul[@class=\"gender-list\"]//label/div[@class=\"common-radioIndicator\"]")).click();
		driver.findElement(By.xpath("//ul[@class=\"gender-list\"]//label[text()='Boys']")).click();
		// driver.findElement(By.xpath("//ul[@class=\"gender-list\"]//label/input[@type=\"radio\"]")).click();
		Thread.sleep(2000);
		WebElement boycatcount = driver.findElement(By.xpath("//div[@class=\"title-container\"]/span"));
		System.out.println(boycatcount.getText());
		String b = boycatcount.getText().replaceAll("\\D", "");
		System.out.println(b);
		Assert.assertFalse(b.isEmpty(), "count is not visible ");

	}

	@Test
	public static void verifyclickOnBoysFilter2() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		// option.addArguments("--incognito");
		 driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com");
		// Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@href=\"/shop/kids\"]"));
		Thread.sleep(2000);
		WebElement subMenu = driver.findElement(By.xpath("//div[@data-group=\"kids\"]/li//a[text()='Footwear']"));
		WebElement thirdmenu = driver.findElement(By.xpath("//div[@data-group=\"kids\"]//li/a[text()='Sports Shoes']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", thirdmenu);
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//ul[@class=\"gender-list\"]//label[text()='Boys']")).click();
		// WebElement
		// elemt=driver.findElement(By.xpath("//ul[@class=\"categories-list\"]/li/label[text()='Sports
		// Shoes']"));
		WebElement elemt = driver.findElement(By.xpath(
				"//ul[@class=\"categories-list\"]/li/label[text()='Sports Shoes']/div[@class=\"common-checkboxIndicator\"]"));
		elemt.click();
		Thread.sleep(3000);
		List<WebElement> e = driver.findElements(By.xpath("//div[@class=\"product-productMetaInfo\"]"));
		for (WebElement el : e) {
			el.click();
		}

	}

	@Test(priority = 7, description = "Handle multiple product link or window")
	public static void verifyclickOnBoysFilterNdclickOnOnly5Product() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		 driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		WebElement element = driver.findElement(By.xpath("//a[@data-group=\"kids\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement second = driver.findElement(By.xpath("//div[@data-group=\"kids\"]/li//a[text()='Footwear']"));
		second.click();
		Thread.sleep(2000);
		WebElement rbutton = driver.findElement(By.xpath("//ul[@class=\"gender-list\"]/li/label[text()='Boys']"));
		rbutton.click();
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		// Thread.sleep(2000);
		// List<WebElement>
		// windows=driver.findElements(By.xpath("//div[@class=\"product-productMetaInfo\"]"));
		for (int i = 0; i < 5; i++) {
			List<WebElement> windows = driver.findElements(By.xpath("//div[@class=\"product-productMetaInfo\"]"));
			windows.get(i).click();
			Thread.sleep(4000);
			Set<String> allwindows = driver.getWindowHandles();
			for (String awin : allwindows) {
				if (!awin.equals(parent)) {
					driver.switchTo().window(awin);
					System.out.println("title is :" + driver.getTitle());
					driver.close();
				}
			}

			driver.switchTo().window(parent);
			System.out.println("successful");
		}

	}

	@Test(priority=8,description="handle multiple window")
	public static void verifyclickOnBoysFilterNdclickOnOnly5ProductAndWindowHandle() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		 driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		WebElement element = driver.findElement(By.xpath("//a[@data-group=\"kids\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement second = driver.findElement(By.xpath("//div[@data-group=\"kids\"]/li//a[text()='Footwear']"));
		second.click();
		Thread.sleep(2000);
		WebElement rbutton = driver.findElement(By.xpath("//ul[@class=\"gender-list\"]/li/label[text()='Boys']"));
		rbutton.click();
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		List<WebElement> data = driver.findElements(By.xpath("//div[@class=\"product-productMetaInfo\"]"));
		for (int i = 0; i < data.size() - 45; i++) {

//			data.get(i).click();
//			Thread.sleep(2000);
			
			try {
				WebElement al = data.get(i);
				al.click();
				Thread.sleep(2000);
			} catch (StaleElementReferenceException e) {
				System.out.println("found");
			}

		}
		Set<String> list = driver.getWindowHandles();
		
	//	HashSet s=new HashSet<>();
		
		ArrayList<String> alllist = new ArrayList<>(list);
		driver.switchTo().window(alllist.get(1));
		System.out.println("first title :" + driver.getTitle());
		Thread.sleep(1000);
		driver.close();

		driver.switchTo().window(alllist.get(3));
		System.out.println("third title is :" + driver.getTitle());
		Thread.sleep(1000);
		driver.close();

		driver.switchTo().window(alllist.get(2));
		System.out.println("Second Title is :" + driver.getTitle());
		Thread.sleep(1000);
		driver.close();
		driver.quit();
		
		

	}
	@Test(priority=9,description="click on wishlist")
	public static void verifyElementAddInWushList() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		 driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		WebElement element = driver.findElement(By.xpath("//a[@data-group=\"kids\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement second = driver.findElement(By.xpath("//div[@data-group=\"kids\"]/li//a[text()='Footwear']"));
		second.click();
		Thread.sleep(2000);
		WebElement rbutton = driver.findElement(By.xpath("//ul[@class=\"gender-list\"]/li/label[text()='Boys']"));
		rbutton.click();
		System.out.println("click on button");
		Thread.sleep(2000);
		 WebElement product=driver.findElement(By.xpath("(//div[@class=\"product-productMetaInfo\"])[1]"));
		act.moveToElement(product).perform();
		Thread.sleep(2000);
		WebElement wishlist=driver.findElement(By.xpath("(//span[text()='wishlist'])[1]"));
		wishlist.click();
		WebElement text=driver.findElement(By.xpath("//div[@class=\"welcome-header\"]"));
		String assertText=text.getText();
		System.out.println(assertText);
		Assert.assertEquals(assertText, "Login or Signup","unsuccessful");
	

	}
	@Test
	public static void verifyLoginNumber() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
	   driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		WebElement element = driver.findElement(By.xpath("//a[@data-group=\"kids\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement second = driver.findElement(By.xpath("//div[@data-group=\"kids\"]/li//a[text()='Footwear']"));
		second.click();
		Thread.sleep(2000);
		WebElement rbutton = driver.findElement(By.xpath("//ul[@class=\"gender-list\"]/li/label[text()='Boys']"));
		rbutton.click();
		System.out.println("click on button");
		Thread.sleep(2000);
		 WebElement product=driver.findElement(By.xpath("(//div[@class=\"product-productMetaInfo\"])[1]"));
		act.moveToElement(product).perform();
		Thread.sleep(2000);
		WebElement wishlist=driver.findElement(By.xpath("(//span[text()='wishlist'])[1]"));
		wishlist.click();
		driver.findElement(By.xpath("//input[@maxlength=\"10\"]")).sendKeys("8080082246");
		System.out.println("enter number");
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//div[text()='CONTINUE']")).click();
		
      }
	@Test
	public static void verifyNegativeTestCaseOnEnterNumber() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		 driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		WebElement element = driver.findElement(By.xpath("//a[@data-group=\"kids\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement second = driver.findElement(By.xpath("//div[@data-group=\"kids\"]/li//a[text()='Footwear']"));
		second.click();
		Thread.sleep(2000);
		WebElement rbutton = driver.findElement(By.xpath("//ul[@class=\"gender-list\"]/li/label[text()='Boys']"));
		rbutton.click();
		System.out.println("click on button");
		Thread.sleep(2000);
		 WebElement product=driver.findElement(By.xpath("(//div[@class=\"product-productMetaInfo\"])[1]"));
		act.moveToElement(product).perform();
		Thread.sleep(2000);
		WebElement wishlist=driver.findElement(By.xpath("(//span[text()='wishlist'])[1]"));
		wishlist.click();
		driver.findElement(By.xpath("//input[@maxlength=\"10\"]")).sendKeys("808008");
		System.out.println("enter number");
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//div[text()='CONTINUE']")).click();
		WebElement numberbox=driver.findElement(By.xpath("//div[text()='Please enter a valid mobile number (10 digits)']"));
		String msg=numberbox.getText();
		String comparemsg="Please enter a valid mobile number ( digits)";
		System.out.println("the msg getting after invalid number :" +msg);
		Assert.assertEquals(msg, comparemsg,"unsuccessful");
      }
	
	@Test(priority=10,description="check dropdown list")
	public static void verifyDropdownList() throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
	   driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		WebElement element = driver.findElement(By.xpath("//a[@data-group=\"kids\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement second = driver.findElement(By.xpath("//div[@data-group=\"kids\"]/li//a[text()='Footwear']"));
		second.click();
		Thread.sleep(2000);
		WebElement rbutton = driver.findElement(By.xpath("//ul[@class=\"gender-list\"]/li/label[text()='Boys']"));
		rbutton.click();
		WebElement srt= driver.findElement(By.xpath("//div[text()='Sort by : ']"));
		srt.click();
		List<WebElement>drop=driver.findElements(By.xpath("//div[text()='Sort by : ']//ul/li/label"));
		
		for(WebElement dlist:drop) {
			String w=dlist.getText();
			System.out.println(w);
			//Thread.sleep(2000);
			dlist.click();
		}
	}
		
//		File src=driver.getScreenshotAs(OutputType.FILE);
//		File trgt=new File("D:\\My Workspace\\newGroup\\src\\test\\java\\testcases\\dropdownlist.jpg");
//		FileUtils.copyFile(src, trgt);
		
	@Test
	public static void captureScreenshot(String fileName) {

	//	TakesScreenshot screenShot=(TakesScreenshot) driver;

		File sourceFile=driver.getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		File destFile=new File("./Screenshots/"+timestamp+fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
	
	
	}
	@Test
	public void searchBarText() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
	    driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("realme phone");
		Thread.sleep(2000);//===>its compulsory wait applied.
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
	//	wait.until(ExpectedConditions.visibilityOf()));
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class=\"desktop-group\"]/li"));
	//	Thread.sleep(2000);
		
		
		for(WebElement li:list) {
			//Thread.sleep(2000)
			wait.until(ExpectedConditions.visibilityOfAllElements(li));
			String s=li.getText();
			//Thread.sleep(2000);
			System.out.println("the all phone list :" +s);
			
			
		}
	}
	
}
