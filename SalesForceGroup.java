package salesforce_application;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesForceGroup {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable otifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		driver.executeScript("arguments[0].click();", ele);
		//*[name()='svg']//*[local-name()='path']
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@data-key='chevrondown'])[6]")).click();
		//driver.executeScript("arguments[0].click();", ele1);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Work Type Group']"))).click();
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		driver.executeScript("arguments[0].click();", ele1);
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input")).sendKeys("Sales force Automation by Ajith");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String verify = driver.findElement(By.xpath("//div[@class='slds-media__body']")).getText();
		if (verify.contains("Ajith")) {
			System.out.println("Work Type Name Verified Sceecessfully");
		}
		else
			System.out.println("Work Type Name Not Verified");
driver.quit();
	}
}
