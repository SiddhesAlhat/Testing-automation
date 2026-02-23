package orangehrm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	@Test(priority=1,description="check login msg")
	public static void verifyLoginMsg() {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--incognito");
		RemoteWebDriver driver=new ChromeDriver(option);
		driver.get("");
		driver.findElement(By.xpath("//div[@text()='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//div[@text()='password']")).sendKeys("admin123");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successful")));
		Assert.assertEquals(msg.getText(),"login successful");
		
	}

}
