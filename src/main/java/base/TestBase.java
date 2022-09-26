package base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestBase {
	
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/meghamapalagama/"
				+ "eclipse-workspace/expressproject/chromedriver 3");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.express.com/");
		
	}
	
	@Test
	public void expressTitleTest() {
		String b=driver.getTitle();
		System.out.println(b);
		//Assert.assertEquals(b, "Men's and Women's Clothing - Shop jeans, dresses, and suits");
	}
	
	@Test
	public void closePopup() throws InterruptedException {
		driver.findElement(By.cssSelector(".srOnly"));
		Thread.sleep(5000);
	}
	
    @Test
	public void loginPage() throws InterruptedException {
		driver.findElement(By.cssSelector("button[aria-label='Focus Close Modal']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[3]/div[2]/div[1]/button")).click();
		driver.findElement(By.cssSelector("input[aria-label='Email'][id='email']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.cssSelector("input[aria-label='Password'][id='password']")).sendKeys("abcd1234");
		driver.findElement(By.cssSelector("button[data-testid='submit-element']")).click();
	} 
	
	@Test
	public void expressLogoImageTest() {
		boolean logopresnt= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/a/img")).isDisplayed();
		System.out.println(logopresnt);

	}
	
	@Test
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
	
}
	