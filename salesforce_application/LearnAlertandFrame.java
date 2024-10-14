package salesforce_application;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlertandFrame {
public static void main(String[] args) {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.switchTo().frame("iframeResult");
	driver.findElement(By.xpath("//button[text()='Try it']")).click();
	Alert ala = driver.switchTo().alert();
	ala.accept();
	String res = driver.findElement(By.xpath("//p[@id='demo']")).getText();
	System.out.println(res);
	driver.close();
}
}
