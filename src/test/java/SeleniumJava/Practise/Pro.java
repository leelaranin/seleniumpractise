package SeleniumJava.Practise;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pro {
	public static void main(String[] args) throws InterruptedException,IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//getTitle
		String str =driver.getTitle();
		System.out.println(str);
		//getCurrentUrl
		String s = driver.getCurrentUrl();
		System.out.println(s);
		boolean b = driver.findElement(By.id("but2")).isDisplayed();
		System.out.println(b);
		Thread.sleep(5000);
		boolean bool = driver.findElement(By.id("but2")).isEnabled();
		System.out.println(bool);
		boolean se = driver.findElement(By.id("radio2")).isSelected();
		System.out.println(se);
		driver.findElement(By.id("link1")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("Open a popup window")).click();
		//Handling Windows
		Set<String>set = driver.getWindowHandles();
		Iterator<String>itr = set.iterator();
		String mainwindow = itr.next();
		String childwindow = itr.next();
		driver.switchTo().window(childwindow);
		driver.close();
		driver.switchTo().window(mainwindow);
		//Handling alerts
		driver.findElement(By.id("alert1")).click();
		Alert alert = driver.switchTo().alert();
		String ale = alert.getText();
		System.out.println(ale);
		Thread.sleep(5000);
		alert.accept();
		driver.switchTo().defaultContent();
		//Handling iframes
		WebElement fram =driver.findElement(By.id("iframe2"));
		driver.switchTo().frame(fram);
		driver.findElement(By.xpath("//*[@id=\"PageList1\"]/div/ul/li[2]/a")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//textarea[@id='ta1']")).sendKeys("Leela");
		//Handling multi-selection boxes
		WebElement multiselectionField = driver.findElement(By.id("multiselect1"));
		Select select = new Select(multiselectionField);
		select.selectByVisibleText("Swift");
		select.selectByIndex(2);
		//Action class
		WebElement blog = driver.findElement(By.id("blogsmenu"));
		Actions action = new Actions(driver);
		action.moveToElement(blog).perform();
		WebElement sele = driver.findElement(By.xpath("//a//span[text()='Selenium143']"));
		action.moveToElement(sele).click().build().perform();
		driver.navigate().back();
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("leela");
		action.doubleClick(search).perform();
		//key class
		WebElement compen = driver.findElement(By.linkText("compendiumdev"));
		action.keyDown(Keys.CONTROL).click(compen).keyUp(Keys.CONTROL).build().perform();
		Set<String>change = driver.getWindowHandles();
		Iterator<String>iter = change.iterator();
		String firstwindow = iter.next();
		String secondwindow = iter.next();
		driver.switchTo().window(secondwindow);
		driver.close();
		driver.switchTo().window(firstwindow);
		WebElement username = driver.findElement(By.xpath("//input[@name='userid']"));
		WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		username.sendKeys("leela");
		action.sendKeys(Keys.TAB).perform();
		password.sendKeys("12345");
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		alert.accept();
		//Take a screenshot
		 File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file,new File("screenshot\\screenshot.png"));
		 //Handling Auto-suggestive dropdown
		 driver.navigate().to("https://www.makemytrip.com/");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		 Thread.sleep(3000);
		 WebElement city = driver.findElement(By.xpath("//input[@placeholder='From']"));
		 city.click();
		 Thread.sleep(3000);
		 city.sendKeys("hyd");
		 int i=0;
		 while(i>4) {
			 city.sendKeys(Keys.DOWN);
			 i++;
		 }
		 Thread.sleep(2000);
		 city.sendKeys(Keys.ENTER); 
		 driver.navigate().back();
		 
		 }
}

