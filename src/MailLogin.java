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
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MailLogin{
	private WebDriver wd;
	private String url;
	private String userName;
	private String userPass;
	private String szukaj;
	private String czegoszukasz;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		wd=new ChromeDriver(options);
		url="https://www.onet.pl/";
		userName="cokolwiek";
		userPass="roniezcokolwiek";
		szukaj="Sport Onet";
		czegoszukasz="Dzien kobiet";
	}
	@Test
	public void test1_LoginNegative(){
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

	@Test
	public void test2_OpenNews(){
		// Otworz strone glowna
		wd.get(url);

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wd.findElement(By.xpath(".//button/span[text()='Przejd� do serwisu']")).click();
		// Otwiera zakladke Wiadomosci( Konsola i w ChroPath wpisujemy xpath ) 
		// contains - zawiera //a[contains(text(), 'blabla' )] <- zawiera tekst "blabla" w obiekcie a.
		wd.findElement(By.xpath(".//div[@id='tabMenu']//a[contains(text(),'Wiadomo�ci')]")).click();

		boolean wynik = wd.findElement(By.xpath(".//img[@alt='Wiadomo�ci']")).isEnabled();
		
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

		wd.findElement(By.xpath(".//button/span[text()='Przejd� do serwisu']")).click();
		wd.findElement(By.xpath(".//div[@id='tabMenu']//a[contains(text(), 'Sport')]")).click();
		boolean wynik=wd.findElement(By.xpath(".//img[@alt='Sport']")).isEnabled();
		
		Assert.assertTrue(wynik);
	}
	
	
	@Test
	public void test4_OpenBiznes(){
		wd.get(url);
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wd.findElement(By.xpath(".//button/span[text()='Przejd� do serwisu']")).click();
		wd.findElement(By.xpath(".//div[@id='tabMenu']//a[contains(text(),'Biznes')]")).click();
		boolean wynik=wd.findElement(By.xpath(".//div[@class='menuRow']")).isEnabled();
		
		Assert.assertTrue(wynik);
	}

	@Test
	public void test5_OpenKultura(){
		wd.get(url);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wd.findElement(By.xpath(".//button/span[text()='Przejd� do serwisu']")).click();
		wd.findElement(By.xpath(".//div[@id='tabMenu']//a[contains(text(),'Kultura')]")).click();
		boolean wynik1=wd.findElement(By.xpath(".//a[@class='serviceLogo']")).isEnabled();
		Assert.assertTrue(wynik1);
		wd.findElement(By.xpath(".//a[@data-gtm='menuLevel1-film']")).click();
		boolean wynik=wd.findElement(By.xpath(".//a[@class='serviceLogo']")).isEnabled();
		Assert.assertTrue(wynik);	
	}
	
	@Test
	public void test6_OpenStyl�ycia(){
		wd.get(url);
		try{
			TimeUnit.SECONDS.sleep(10);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		wd.findElement(By.xpath(".//button/span[text()='Przejd� do serwisu']")).click();	
		wd.findElement(By.xpath(".//div[@id='tabMenu']//a[contains(text(),'Styl �ycia')]")).click();
		boolean wynik=wd.findElement(By.xpath(".//body[@class='lifestyleMainpage']")).isEnabled();
		Assert.assertTrue(wynik);
		wd.findElement(By.xpath(".//div[@id='tabMenu']//a[contains(text(),'Moda')]")).click();
		boolean wynik1= wd.findElement(By.xpath(".//body[@class='lifestyleMainpage']")).isEnabled();
		Assert.assertTrue(wynik1);
	}
	@Test
	public void test7_OpenSzukajwWyszukiwarce(){
		wd.get(url);
		try{
			TimeUnit.SECONDS.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		wd.findElement(By.xpath(".//button/span[text()='Przejd� do serwisu']")).click();
		WebElement poleszukaj=wd.findElement(By.id("searchQuery"));
		poleszukaj.clear();
		poleszukaj.sendKeys(szukaj);
		wd.findElement(By.xpath(".//input[@id='searchSubmit']")).click();
		wd.findElement(By.xpath(".//a[contains(text(), 'Sport -')]")).click();
		boolean wynik=wd.findElement(By.xpath(".//img[@alt='Sport']")).isEnabled();
		Assert.assertTrue(wynik);
	}
	
	@Test
	public void test8_Open_Zakupy(){
		wd.get(url);
		try{
			TimeUnit.SECONDS.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		wd.findElement(By.xpath(".//button/span[text()='Przejd� do serwisu']")).click();
		wd.findElement(By.xpath(".//span[contains(text(),'Zakupy')]")).click();
		WebElement poleczegoszukasz=wd.findElement(By.xpath(".//input[@placeholder='czego szukasz?']"));
		poleczegoszukasz.clear();
		poleczegoszukasz.sendKeys(czegoszukasz);
		wd.findElement(By.xpath("."
				+ "//input[@class='mobile-hidden']")).click();
		boolean wynik_=wd.findElement(By.xpath(".//h1[@class='filters-header']")).isEnabled();
		Assert.assertTrue(wynik_);
	}
	@After
	public void tearDown(){
		wd.quit();
	}
}
