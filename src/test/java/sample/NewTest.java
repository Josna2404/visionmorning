package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.coverfox.com/");
  }
}
