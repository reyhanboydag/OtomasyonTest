import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class ChromeDriver1 {
	public enum DriverType{
		CHROME,FIREFOX
	}
	protected static WebDriver driver;
	protected static DriverType driverType=DriverType.CHROME;
	protected final static String CHROME_PATH="/Users/Reyhan/Downloads/Compressed/chromedriver_win32/chromedriver.exe";
	protected final static String FIREFOX_PATH="/Users/Reyhan/Downloads/Compressed/geckodriver-v0.26.0-win64/geckodriver.exe";
	protected static DesiredCapabilities capabilities=new DesiredCapabilities();
	protected boolean acceptNextAlert=true;
	//çalışıcak ilan ilk kısımdır
	@BeforeClass
	public static void driverControl() throws Exception {
		ChromeOptions chromeOptions;
		switch(driverType) {
			case CHROME:
				System.setProperty("webdriver.chrome.driver", CHROME_PATH);
				chromeOptions=new ChromeOptions().merge(capabilities);
				driver=new ChromeDriver(chromeOptions);
				break;
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
				capabilities.setBrowserName(BrowserType.FIREFOX);
				driver=new FirefoxDriver(new FirefoxOptions(capabilities));
				break;		
		}
	}
	//test için çalışacak olan son kısımdır
	@AfterClass
	public static void cleanup() {
		driver.quit();
	}
	
}
