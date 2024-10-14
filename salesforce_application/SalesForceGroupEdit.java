package salesforce_application;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesForceGroupEdit {
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
		driver.findElement(By.xpath("//a[contains(@title,'Recently Viewed')]/span")).click();
		driver.findElement(By.xpath("(//div[@part='input-container']/input)[1]")).sendKeys("Salesforce Automation by Ajith",Keys.ENTER);
		Thread.sleep(3000);
		WebElement editClick = driver.findElement(By.xpath("(//div[contains(@class,'forceVirtualActionMarker')]//span)[1]"));
		driver.executeScript("arguments[0].click();", editClick);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[contains(@class,'slds-input_faux fix-slds-input_faux slds-combobox__input-value')]")).click();
		driver.findElement(By.xpath("//span[@title='Capacity']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		driver.findElement(By.xpath("//a[contains(@title,'Salesforce')]")).click();
		 String res = driver.findElement(By.xpath("(//span[contains(@class,'test-id__field-value')])[2]")).getText();
		if (res.contains("Automation")) {
			System.out.println("Description updated");
		}
		else 
			System.out.println("Description not updated");
	}
}
