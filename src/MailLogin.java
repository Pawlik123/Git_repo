package src;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	public void test1_LoginNegative(){
		wd.get(url);

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wd.findElement(By.xpath(".//button/span[text()='Przejdü do serwisu']")).click();
		wd.findElement(By.partialLinkText("E-MAIL")).click();

		
		WebElement loginName=wd.findElement(By.name("login"));
		loginName.clear();
		loginName.sendKeys(userName);
		
		WebElement loginPass=wd.findElement(By.id("mailFormPassword"));
		loginPass.clear();
		loginPass.sendKeys(userPass);
		wd.findElement(By.xpath(".//input[@value='Zaloguj siÍ']")).click();
		Assert.assertTrue(wd.getPageSource().contains("Wprowadü poprawny adres e-mail"));
	}

	@Test
	public void test2_OpenNews(){
		// Otworz strone glowna
		wd.get(url);

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wd.findElement(By.xpath(".//button/span[text()='Przejdü do serwisu']")).click();
		// Otwiera zakladke Wiadomosci( Konsola i w ChroPath wpisujemy xpath ) 
		// contains - zawiera //a[contains(text(), 'blabla' )] <- zawiera tekst "blabla" w obiekcie a.
		wd.findElement(By.xpath(".//div[@id='tabMenu']//a[contains(text(),'Wiadomoúci')]")).click();

		boolean wynik = wd.findElement(By.xpath(".//img[@alt='Wiadomoúci']")).isEnabled();
		
		Assert.assertTrue(wynik);
	}

	@Test
	public void test3_OpenSport(){
		wd.get(url);
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wd.findElement(By.xpath(".//button/span[text()='Przejdü do serwisu']")).click();
		wd.findElement(By.xpath(".//div[@id='tabMenu']//a[contains(text(), 'Sport')]")).click();
		boolean wynik=wd.findElement(By.xpath(".//img[@alt='Sport']")).isEnabled();
		
		Assert.assertTrue(wynik);
	}
	
	@After
	public void tearDown(){
		wd.quit();
	}
}
