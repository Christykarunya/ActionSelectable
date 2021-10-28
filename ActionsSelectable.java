package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSelectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions builder= new Actions(driver);
		
		//to select item 1 to item 3 using Mouse action
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		
		builder.clickAndHold(item1).moveToElement(item3).release().perform();
		
		//to select item5 and item7 using Keyboard action
		WebElement item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		builder.keyDown(Keys.CONTROL).click(item7).click(item5).keyUp(Keys.CONTROL).perform();

	}

}
