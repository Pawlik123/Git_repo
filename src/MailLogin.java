package src;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MailLogin {
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
		
	}
	@After
	public void tearDown(){
		wd.quit();
	}
}
