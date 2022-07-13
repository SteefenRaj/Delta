package Dental;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.google.common.io.Files;

public class DeltaDentalTest {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("mobiles under 15000");
		driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"See more\"]")).click();
		driver.findElement(By.xpath("//i[@class=\"a-icon a-icon-checkbox\"]//ancestor::li[@id=\"p_89/MI\"]//descendant::span[text()=\"MI\"]")).click();
		Thread.sleep(2000);
		WebElement mobileName = driver.findElement(By.xpath("//span[text()='Mi Redmi -Note 7S (Onyx Black, 64GB, 4GB RAM)']"));
		mobileName.click();
		System.out.println(mobileName);
		Thread.sleep(2000);
				
		Set<String> allWin = driver.getWindowHandles();
		for(String win:allWin)
		{
			String title = driver.switchTo().window(win).getTitle();
			System.out.println("Title Name : "+title);
		}
		String price = driver.findElement(By.xpath("//div[@id='apex_desktop']//descendant::span[text()='₹13,490.00']")).getText();
		System.out.println("Mobile Price :"+price);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(5000);
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\stephen\\OneDrive\\Desktop\\Picture\\addToCart.jpg");
		Files.copy(src, des);
		
		String itemAdded = driver.findElement(By.xpath("//div[@id='attachDisplayAddBaseAlert']")).getText();
		System.out.println("Message : "+itemAdded);
		

	}

}
