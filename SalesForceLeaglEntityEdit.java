package salesforce_application;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForceLeaglEntityEdit {
public static void main(String[] args) throws InterruptedException {
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("leaf@2024");
	driver.findElement(By.id("Login")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	Thread.sleep(2000);
    WebElement clicklegalentity = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
    driver.executeScript("arguments[0].click();", clicklegalentity);
    WebElement clicklegalentity1=  driver.findElement(By.xpath("(//span[text()='Legal Entities'])[1]"));
    driver.executeScript("arguments[0].click();", clicklegalentity1);
    driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys("SalesForce Automation by Ajith",Keys.ENTER);
    Thread.sleep(3000);
    WebElement clickdd = driver.findElement(By.xpath("(//div[contains(@class,'forceVirtualActionMarker')]//span)[1]"));
    driver.executeScript("arguments[0].click()", clickdd);
    driver.findElement(By.xpath("//a[@title='Edit']")).click();
    driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("Testleaf");
    driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Sales Force");
   // driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux fix-slds-input_faux ')]")).click();
    String verify = driver.findElement(By.xpath("//span[text()='Active']")).getText();
    if (verify.contains("Active")) {
		System.out.println("Status Verified");
	}
    else
    	System.out.println("Status Not Verified");
    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
    driver.close();
}
}
