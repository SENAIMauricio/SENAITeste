package testFront;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageHome {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getenv("Driver"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://online.sp.senai.br/");
	}
	
	@Test
	public void testarPagina() {
		String originalWindow = driver.getWindowHandle();
		driver.findElement(By.className("Fiesp")).click();
		driver.switchTo().window(originalWindow);
		driver.findElement(By.className("ciesp")).click();
		driver.switchTo().window(originalWindow);
		driver.findElement(By.className("sesi")).click();
		driver.switchTo().window(originalWindow);
		driver.findElement(By.className("senai")).click();
		driver.switchTo().window(originalWindow);
		driver.findElement(By.className("irs")).click();
		driver.switchTo().window(originalWindow);
		driver.findElement(By.id("Busca1_txtFiltro")).sendKeys("excel");
		driver.findElement(By.id("Busca1_btnBusca")).sendKeys(Keys.ENTER);
	}
	
	@After
	public void fechar() {
		driver.close();
	}
}
