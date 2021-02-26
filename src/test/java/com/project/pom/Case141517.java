package com.project.pom;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case141517 {
	
	WebDriver driver;
	CheckLinks page;
  @Test
public void chekList() {
	  assertTrue(page.checkListPage(), "Hay Links Rotos");
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		page = new CheckLinks(driver);
		driver.get("https://www.choucairtesting.com/empleos-testing/");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
