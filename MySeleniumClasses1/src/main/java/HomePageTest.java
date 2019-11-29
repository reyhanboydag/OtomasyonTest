import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import static org.junit.matchers.JUnitMatchers.*;

public class HomePageTest extends ChromeDriver1 {
	@BeforeClass
	public static void homePage() {
		//"https://www.finartz.com/" sayfasının açıldığı aşamadır. ekran maximixe edilir.
		//açılan sayfanın başlığı ile karşılaştırma yapılır ve bir sonraki aşamaya geçilir.
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);	
		driver.get("https://www.finartz.com/");	
		driver.manage().window().maximize();
		Assert.assertEquals("Finartz - Homepage", driver.getTitle());		
	}
	@Test
	public void test1() throws InterruptedException {	
		//Solutions sayfasının açıldığı aşamadır. a etiketinin yolu verilmiştir.
		//sayfada yer alan başlıklar cssSelecor ile elementler konsolda yazdırılır.
		driver.findElement(By.xpath("//html/body/div[3]/div[1]/nav/div/div[2]/div/a[3]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> solutionsHeaders=driver.findElements(By.cssSelector(".section-title-wrapper h2"));
		for(int i=0;i<solutionsHeaders.size();i++) {
			System.out.println(solutionsHeaders.get(i).getText());
		}
		
	}
	@Test
	public void test2() throws InterruptedException{
		//blog sayfasının açıldığı aşamadır
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/nav/div/div[2]/div/a[6]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void test3() throws InterruptedException{
		/*blog sayfasında arama işleminin gerçekleştiği aşamadır
		 * blog sayfası yeni bir pencerede açılır ve arama iconun yolu belirtilir 
		 * Financial Services input alanına yazılır ve Search işlemi gerçekleştirilir
		 * test işlemi başarıyla gerçekleştiril ve kalıtımı alınan ChromeDriver1'dan yer alan afterclass methodu
		 * çalışır	
		 * */
		((JavascriptExecutor)driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		driver.get("https://blog.finartz.com/");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/nav/div[1]/label")).click();
		WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/nav/div[1]/label/input"));
		element.click();
		element.clear();
		element.sendKeys("Financial Services");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[6]/div[1]/div/a[2]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
	}

}
