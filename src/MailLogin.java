package src;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MailLogin{
	private WebDriver wd;
	private String url;
	private String userName;
	private String userPass;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		wd=new ChromeDriver();
		url="https://www.onet.pl/";
		userName="cokolwiek";
		userPass="roniezcokolwiek";
	}
	@Test
	public void loginNegative(){
		wd.get(url);

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wd.findElement(By.xpath(".//button/span[text()='Przejd� do serwisu']")).click();
		wd.findElement(By.partialLinkText("E-MAIL")).click();

		
		WebElement loginName=wd.findElement(By.name("login"));
		loginName.clear();
		loginName.sendKeys(userName);
		
		WebElement loginPass=wd.findElement(By.id("mailFormPassword"));
		loginPass.clear();
		loginPass.sendKeys(userPass);
		wd.findElement(By.xpath(".//input[@value='Zaloguj si�']")).click();
		Assert.assertTrue(wd.getPageSource().contains("Wprowad� poprawny adres e-mail"));
	}
	@After
	public void tearDown(){
		wd.quit();
	}
}
